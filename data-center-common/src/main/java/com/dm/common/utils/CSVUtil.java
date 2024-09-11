package com.dm.common.utils;

import cn.hutool.core.collection.CollUtil;
import com.dm.common.api.ResponseCode;
import com.dm.common.exception.BaseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CSV文件工具类
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-04 19:38
 */
@Component
public class CSVUtil {
    /**
     * 存储根节点
     */
    @Value("${data.storage.rootPath}")
    private final String rootPath = "/Users/yanchenyang17958/Desktop/work/data";
    private static final String SUFFIX = ".csv";
    /**
     * 缓冲区大小
     */
    private static final int BUFFER_SIZE = 1024 * 1024;

    private static final String SEPARATOR = ",";
    private static final String BORDER = "&$";

    /**
     * 生成文件
     *
     * @param fileName 文件名
     * @param data     数据
     */
    public String genFile(String dir, String fileName, List<Map<String, Object>> data, boolean append) {
        String suffix = fileName.substring(fileName.length() - 4);
        if (!SUFFIX.equals(suffix)) {
            throw new BaseException(ResponseCode.FILE_FORMAT_INCORRECT);
        }
        if (CollUtil.isEmpty(data)) {
            throw new BaseException(ResponseCode.FILE_IS_BLANK);
        }
        String dirPath = Paths.get(rootPath, dir).toString();
        String fullPath = Paths.get(dirPath, fileName).toString();
        File file = new File(fullPath);
        //创建文件夹
        if (!file.getParentFile().exists()) {
            boolean success = file.getParentFile().mkdirs();
            if (!success) {
                throw new BaseException(ResponseCode.FILE_PARENT_CREATE_FAILURE);
            }
        }
        //创建文件
        try {
            FileWriter fileWriter = new FileWriter(fullPath, append);
            //字节缓冲
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, BUFFER_SIZE);
            //获得表头
            Map<String, Object> head = data.get(0);
            String header = toLineStr(new ArrayList<>(head.keySet()));
            if (append) {
                String fileHead = new BufferedReader(new FileReader(file)).readLine();
                if (!header.equals(fileHead)) {
                    throw new BaseException(ResponseCode.CSV_HEAD_NOT_SAME);
                }
            } else {
                //写入表头
                bufferedWriter.write(header);
                bufferedWriter.newLine();
            }
            //写入值
            for (Map<String, Object> row : data) {
                String line = toLineStr(row.values().stream().toList());
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fullPath;
    }


    /**
     * 读CSV文件
     *
     * @param file 文件
     * @return 返回数据
     */
    public List<Map<String, Object>> readCSV(MultipartFile file) {
        List<Map<String, Object>> rows = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()), BUFFER_SIZE);
            String head = bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Map<String, Object> row = parseLine(head, line);
                rows.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    /**
     * 读CSV文件
     *
     * @param fullPath  全地址
     * @param readCount 读取行数
     * @return 返回数据
     */
    public List<Map<String, Object>> readCSV(String fullPath, int readCount) {
        File file = new File(fullPath);
        List<Map<String, Object>> rows = new ArrayList<>();
        int index = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file), BUFFER_SIZE);
            String head = bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null && index++ < readCount) {
                Map<String, Object> row = parseLine(head, line);
                rows.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    /**
     * 读CSV文件
     *
     * @param fullPath  全地址
     * @return 返回数据
     */
    public List<Map<String, Object>> readCSV(String fullPath) {
        File file = new File(fullPath);
        List<Map<String, Object>> rows = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file), BUFFER_SIZE);
            String head = bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Map<String, Object> row = parseLine(head, line);
                rows.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    /**
     * 将一行元素生成字符串
     *
     * @param row 一行数据
     * @return 字符串
     */
    private String toLineStr(List<Object> row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row.size(); i++) {
            String cellStr = row.get(i).toString();
            if (cellStr.contains(SEPARATOR)) {
                sb.append(BORDER).append(cellStr).append(BORDER);
            } else {
                sb.append(cellStr);
            }
            if (i < row.size() - 1) {
                sb.append(SEPARATOR);
            }
        }
        return sb.toString();
    }

    /**
     * 解析row
     *
     * @param head   表头
     * @param rowStr 行字符
     * @return 解析行
     */
    private Map<String, Object> parseLine(String head, String rowStr) {
        List<Object> headArr = splitLine(head);
        List<Object> rowArr = splitLine(rowStr);
        Map<String, Object> result = new HashMap<>();
        for (int i = 0; i < headArr.size(); i++) {
            result.put(headArr.get(i).toString(), rowArr.get(i));
        }
        return result;
    }

    private List<Object> splitLine(String row) {
        String[] arr = row.split(SEPARATOR);
        List<Object> result = new ArrayList<>();
        //跨界元素 (cell中存在分割符)当sb有值时表示跨界拼接没有结束
        StringBuilder sb = new StringBuilder();
        for (String item : arr) {
            //跨界的开始
            if (item.length() > 2 && BORDER.equals(item.substring(0, BORDER.length()))) {
                sb.append(item.substring(BORDER.length()));
                continue;
            }
            //跨界的结束
            if (item.length() > 2 && BORDER.equals(item.substring(item.length() - BORDER.length()))) {
                sb.append(item, 0, item.length() - BORDER.length());
                result.add(sb.toString());
                sb = new StringBuilder();
                continue;
            }
            //如果存在跨界
            if (!sb.isEmpty()) {
                sb.append(item);
                continue;
            }
            //如果不存在跨界
            result.add(item);
        }
        return result;
    }
}
