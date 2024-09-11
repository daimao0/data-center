package com.dm.infrastructure.db.repository.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dm.domain.datastorage.model.DataStorageCSVDO;
import com.dm.domain.datastorage.model.DataStorageDO;
import com.dm.domain.datastorage.repository.DataStorageRepository;
import com.dm.infrastructure.convert.DataStorageConvert;
import com.dm.infrastructure.db.mapper.DataStorageCSVMapper;
import com.dm.infrastructure.db.mapper.DataStorageMapper;
import com.dm.infrastructure.db.po.DataStorageCSVPO;
import com.dm.infrastructure.db.po.DataStoragePO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-04 15:43
 */
@Service
public class DataStorageRepositoryImpl implements DataStorageRepository {
    @Resource
    private DataStorageMapper dataStorageMapper;
    @Resource
    private DataStorageCSVMapper dataStorageCSVMapper;

    /**
     * 根据storage的主键Id
     *
     * @param dataStorageDO 数据仓储
     * @return 数据仓储
     */
    @Override
    public List<DataStorageDO> listDataStorageDO(DataStorageDO dataStorageDO) {
        //获得数据仓储
        DataStoragePO dataStoragePO = dataStorageMapper.selectById(dataStorageDO.getId());
        if (dataStoragePO == null) {
            return null;
        }
        //获得csv仓储
        switch (dataStorageDO.getStorageType()) {
            case CSV -> {
                Wrapper<DataStorageCSVPO> queryWrapper = new LambdaQueryWrapper<DataStorageCSVPO>()
                        .eq(DataStorageCSVPO::getDataStorageId, dataStorageDO.getId());
                List<DataStorageCSVPO> dataStorageCSVPOS = dataStorageCSVMapper.selectList(queryWrapper);
                List<DataStorageDO> dataStorageDOS = new ArrayList<>();
                for (DataStorageCSVPO dataStorageCSVPO : dataStorageCSVPOS) {
                    DataStorageCSVDO dataStorageCSVDO = DataStorageConvert.toDataStorageCSVDO(dataStorageCSVPO);
                    if (dataStorageCSVDO != null) {
                        dataStorageDOS.add(dataStorageCSVDO);
                    }
                }
                return dataStorageDOS;
            }
            default -> {
                return null;
            }
        }

    }

    /**
     * 保存数据仓储
     *
     * @param dataStorageDO 数据仓储
     */
    @Override
    public void save(DataStorageDO dataStorageDO) {
        //存储数据
        DataStoragePO dataStoragePO = dataStorageMapper.selectById(dataStorageDO.getId());
        if (dataStoragePO == null) {
            dataStoragePO = DataStorageConvert.toDataStoragePO(dataStorageDO);
            dataStorageMapper.insert(dataStoragePO);
        }
        //存储CSV数据
        switch (dataStorageDO.getStorageType()) {
            case CSV -> {
                DataStorageCSVDO dataStorageCSVDO = (DataStorageCSVDO) dataStorageDO;
                DataStorageCSVPO dataStorageCSVPO = DataStorageConvert.toDataStorageCSVPO(dataStorageCSVDO);
                dataStorageCSVMapper.insert(dataStorageCSVPO);
            }
        }
    }
}
