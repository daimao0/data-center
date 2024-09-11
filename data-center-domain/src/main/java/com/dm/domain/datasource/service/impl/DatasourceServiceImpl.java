package com.dm.domain.datasource.service.impl;

import com.dm.common.utils.CSVUtil;
import com.dm.domain.datasource.model.DatasourceCSVDO;
import com.dm.domain.datasource.model.DatasourceDO;
import com.dm.domain.datasource.repository.DatasourceRepository;
import com.dm.domain.datasource.service.DatasourceService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-10 20:56
 */
@Service
public class DatasourceServiceImpl implements DatasourceService {

    @Resource
    private DatasourceRepository datasourceRepository;
    @Resource
    private CSVUtil csvUtil;

    /**
     * 保存数据源
     *
     * @param datasourceDO 数据源
     */
    @Override
    public void save(DatasourceDO datasourceDO) {
        datasourceRepository.save(datasourceDO);
    }

    /**
     * 数据源试跑
     *
     * @param datasourceDO 数据源域
     * @return 试跑结果
     */
    @Override
    public List<Map<String, Object>> trail(DatasourceDO datasourceDO) {
        List<Map<String, Object>> data = null;
        switch (datasourceDO.getDatasourceType()) {
            case CSV -> {
                DatasourceCSVDO datasourceCSVDO = (DatasourceCSVDO) datasourceDO;
                data = csvUtil.readCSV(datasourceCSVDO.getPath(), 20);
            }
        }
        return data;
    }
}
