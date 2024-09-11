package com.dm.domain.datasource.model;

import com.dm.common.enums.DataSourceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 数据源域
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-23 11:02
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class DatasourceDO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 数据集id
     */
    private Long datasetId;
    /**
     * 数据源名称
     */
    private String name;
    /**
     * 数据源类型:csv文件、mysql、presto
     */
    private DataSourceType datasourceType;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
