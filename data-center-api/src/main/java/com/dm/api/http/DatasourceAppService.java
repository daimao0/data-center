package com.dm.api.http;

import com.dm.api.request.DatasourceSaveReq;
import com.dm.api.vo.DatasourceVO;

import java.util.List;
import java.util.Map;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-23 16:27
 */
public interface DatasourceAppService {
    /**
     * 查询数据源详情
     * @param id 数据源id
     * @return 数据源详情
     */
    DatasourceVO getById(Long id);

    /**
     * 保存数据源
     * @param datasourceSaveReq 数据源保存参数
     */
    void save(DatasourceSaveReq datasourceSaveReq);

    /**
     * 数据源试跑
     * @param id 数据源id
     * @return 试跑结果
     */
    List<Map<String, Object>> trial(Long id);
}
