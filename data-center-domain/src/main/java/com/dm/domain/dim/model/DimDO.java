package com.dm.domain.dim.model;

import com.dm.common.enums.DimType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 维度域
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-05 21:02
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class DimDO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 数据集id
     */
    private Long datasetId;
    /**
     * 版本
     */
    private Integer version;
    /**
     * 度量英文名
     */
    private String enName;
    /**
     * 度量中文名
     */
    private String displayName;
    /**
     * 维度类型
     */
    private DimType dimType;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}