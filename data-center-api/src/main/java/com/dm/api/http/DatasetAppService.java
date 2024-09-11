package com.dm.api.http;

import com.dm.api.request.DatasetBindDatasourceReq;
import com.dm.api.request.DatasetSaveReq;
import com.dm.api.vo.DatasetVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-19 02:26
 */
public interface DatasetAppService {
    /**
     * 获得数据集VO
     *
     * @param id 数据集id
     * @return 数据集VO
     */
    DatasetVO getById(Long id);

    /**
     * 保存数据集
     *
     * @param datasetSaveReq 数据集保存参数
     */
    void save(@Validated DatasetSaveReq datasetSaveReq);

    /**
     * 上传文件生成数据集
     *
     * @param file 文件
     */
    void uploadFileGenDataset(MultipartFile file);

    /**
     * 绑定数据源
     *
     * @param req 参数
     */
    void bindDatasource(DatasetBindDatasourceReq req);

    /**
     * 根据数据集id试跑数据
     *
     * @param id 数据集id
     * @return 试跑结果
     */
    List<Map<String, Object>> trial(Long id);
}
