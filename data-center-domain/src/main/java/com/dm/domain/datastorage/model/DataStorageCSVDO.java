package com.dm.domain.datastorage.model;

import com.dm.domain.datastorage.commond.DataUploadCmd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * csv文件数据仓储域
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-04 11:27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DataStorageCSVDO extends DataStorageDO{
    /**
     * 主键id
     */
    private Long id;
    /**
     * 数据仓储id
     */
    private Long dataStorageId;
    /**
     * 数据路径
     */
    private String path;
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
    @Override
    public void cover(DataUploadCmd dataUploadCmd) {

    }

    /**
     * 数据仓储追加
     *
     * @param dataUploadCmd 数据上传参数
     */
    @Override
    public void append(DataUploadCmd dataUploadCmd) {

    }
}
