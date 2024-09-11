package com.dm.infrastructure.db.repository.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dm.common.api.ResponseCode;
import com.dm.common.enums.DataSourceType;
import com.dm.common.exception.BaseException;
import com.dm.domain.datasource.model.DatasourceDO;
import com.dm.domain.datasource.repository.DatasourceRepository;
import com.dm.infrastructure.convert.DatasourceConvert;
import com.dm.infrastructure.db.mapper.DatasourceCSVMapper;
import com.dm.infrastructure.db.mapper.DatasourceMapper;
import com.dm.infrastructure.db.po.DatasourceCSVPO;
import com.dm.infrastructure.db.po.DatasourcePO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 数据源仓储服务
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-23 15:55
 */
@Component
public class DatasourceRepositoryImpl implements DatasourceRepository {
    @Resource
    private DatasourceMapper datasourceMapper;
    @Resource
    private DatasourceCSVMapper datasourceCSVMapper;

    /**
     * 保存数据源
     *
     * @param datasourceDO 数据源
     */
    @Override
    public void save(DatasourceDO datasourceDO) {
        //保存数据源表
        DatasourcePO datasourcePO = DatasourceConvert.toDatasourcePO(datasourceDO);
        datasourceMapper.insert(datasourcePO);
        datasourceDO.setId(datasourcePO.getId());
        //保存CSV数据源
        switch (datasourceDO.getDatasourceType()) {
            case CSV -> datasourceCSVMapper.insert(DatasourceConvert.toDatasourceCSVPO(datasourceDO));
        }
    }

    /**
     * 根据id查询数据源
     *
     * @param id 数据源id
     * @return 数据源
     */
    @Override
    public DatasourceDO findById(Long id) {
        DatasourcePO datasourcePO = datasourceMapper.selectById(id);
        DataSourceType dataSourceType = DataSourceType.get(datasourcePO.getDatasourceType());
        if (dataSourceType == null) {
            throw new BaseException(ResponseCode.DATASOURCE_NOT_EXIST);
        }
        switch (dataSourceType) {
            case CSV -> {
                Wrapper<DatasourceCSVPO> queryWrapper = new LambdaQueryWrapper<DatasourceCSVPO>()
                        .eq(DatasourceCSVPO::getDatasourceId, id);
                DatasourceCSVPO datasourceCSVPO = datasourceCSVMapper.selectOne(queryWrapper);
                DatasourceDO datasourceDO = DatasourceConvert.toDatasourceDO(datasourceCSVPO);
                datasourceDO.setName(datasourcePO.getName())
                        .setDatasourceType(DataSourceType.get(datasourcePO.getDatasourceType()));
                return datasourceDO;
            }
        }
        return null;
    }

    /**
     * 根据数据集查询数据源
     *
     * @param id 数据集id
     * @return 数据源
     */
    @Override
    public List<DatasourceDO> listByDatasetId(Long id) {
        Wrapper<DatasourcePO> queryWrapper = new LambdaQueryWrapper<DatasourcePO>()
                .eq(DatasourcePO::getDatasetId, id);
        List<DatasourcePO> datasourcePOS = datasourceMapper.selectList(queryWrapper);
        return datasourcePOS.stream().map(e -> findById(e.getId())).toList();
    }
}
