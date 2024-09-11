package com.dm.domain.datastorage.model;

import com.dm.common.enums.StorageType;
import com.dm.domain.datastorage.commond.DataUploadCmd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 数据仓储域
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-04 11:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public abstract class DataStorageDO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 数据源id
     */
    private Long datasourceId;
    /**
     * 数据存储类型
     */
    private StorageType storageType;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 数据仓储覆盖
     *
     * @param dataUploadCmd 数据上传参数
     */
    public abstract void cover(DataUploadCmd dataUploadCmd);

    /**
     * 数据仓储追加
     *
     * @param dataUploadCmd 数据上传参数
     */
    public abstract void append(DataUploadCmd dataUploadCmd);
}
