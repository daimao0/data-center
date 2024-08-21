package com.dm.app.service.impl;

import com.dm.api.command.DatasetSaveCmd;
import com.dm.api.http.DatasetService;
import com.dm.api.vo.DatasetVO;
import com.dm.app.convert.DatasetConvert;
import com.dm.domain.dataset.model.DatasetDO;
import com.dm.domain.dataset.repository.DatasetRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author daimao
 * @date 2024/8/19 1:02
 */
@Service
public class DatasetServiceImpl implements DatasetService {
    @Resource
    private DatasetRepository datasetRepository;

    /**
     * 获得数据集VO
     *
     * @param id 数据集id
     * @return 数据集VO
     */
    @Override
    public DatasetVO getById(Long id) {
        DatasetDO datasetDO = datasetRepository.findById(id);
        return DatasetConvert.toDatasetVO(datasetDO);
    }

    /**
     * 保存数据集
     *
     * @param datasetSaveCmd 数据集保存参数
     */
    @Override
    public void save(DatasetSaveCmd datasetSaveCmd) {
        DatasetDO datasetDO = DatasetConvert.toDatasetDO(datasetSaveCmd);
        datasetRepository.save(datasetDO);
    }


}
