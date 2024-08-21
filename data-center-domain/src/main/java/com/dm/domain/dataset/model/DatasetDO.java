package com.dm.domain.dataset.model;

import com.dm.common.enums.DatasetStatus;
import com.dm.common.enums.DatasetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 数据集抽象类
 *
 * @author daimao
 * @date 2024/8/19 1:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class DatasetDO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 数据集名称
     */
    private String name;
    /**
    * 数据集类型
    */
    private DatasetType datasetType;
    /**
     * 数据集状态
     */
    private DatasetStatus datasetStatus;
    /**
     * 版本号
      */
    private Integer version;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 管理员
     */
    private String managers;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
