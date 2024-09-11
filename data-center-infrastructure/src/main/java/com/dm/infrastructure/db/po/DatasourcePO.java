package com.dm.infrastructure.db.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 数据源
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-23 00:50
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
@TableName(value = "t_datasource")
public class DatasourcePO {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 数据集id
     */
    @TableField(value = "dataset_id")
    private Long datasetId;
    /**
     * 数据源名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 数据源类型:file、mysql、presto
     */
    @TableField(value = "datasource_type")
    private String datasourceType;
    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private LocalDateTime createdAt;
    /**
     * 更新时间
     */
    @TableField(value = "updated_at")
    private LocalDateTime updatedAt;
    /**
     * 删除时间
     */
    @TableField(value = "deleted_at")
    @TableLogic(value = "null", delval = "now()")
    private LocalDateTime deletedAt;
}
