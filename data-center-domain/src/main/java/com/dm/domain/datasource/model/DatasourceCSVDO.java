package com.dm.domain.datasource.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * CSV数据源
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-10 19:44
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class DatasourceCSVDO extends DatasourceDO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 数据源id
     */
    private Long datasourceId;
    /**
     * 文件路径
     * 可以是oss
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
}
