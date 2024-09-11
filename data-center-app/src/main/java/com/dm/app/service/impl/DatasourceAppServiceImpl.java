package com.dm.app.service.impl;

import com.dm.api.http.DatasourceAppService;
import com.dm.api.request.DatasourceSaveReq;
import com.dm.api.vo.DatasourceVO;
import com.dm.app.convert.DatasourceConvert;
import com.dm.domain.datasource.model.DatasourceDO;
import com.dm.domain.datasource.repository.DatasourceRepository;
import com.dm.domain.datasource.service.DatasourceService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-23 17:23
 */
@Service
public class DatasourceAppServiceImpl implements DatasourceAppService {
    @Resource
    private DatasourceRepository datasourceRepository;
    @Resource
    private DatasourceService datasourceService;

    /**
     * 查询数据源详情
     *
     * @param id 数据源id
     * @return 数据源详情
     */
    @Override
    public DatasourceVO getById(Long id) {
        DatasourceDO datasourceDO = datasourceRepository.findById(id);
        return DatasourceConvert.toDatasourceVO(datasourceDO);
    }

    /**
     * 保存数据源
     *
     * @param datasourceSaveReq 数据源保存参数
     */
    @Override
    public void save(@Validated DatasourceSaveReq datasourceSaveReq) {
        DatasourceDO datasourceDO = DatasourceConvert.toDatasourceDO(datasourceSaveReq);
        datasourceRepository.save(datasourceDO);
    }

    /**
     * 数据源试跑
     *
     * @param id 数据源id
     * @return 试跑结果
     */
    @Override
    public List<Map<String, Object>> trial(Long id) {
        DatasourceDO datasourceDO = datasourceRepository.findById(id);
        return datasourceService.trail(datasourceDO);
    }
}
