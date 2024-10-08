package com.dm.infrastructure.db.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * SQL数据集
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-20 16:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "t_datasource_sql")
public class DatasourceSQLPO {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 数据源id
     */
    @TableField(value = "datasource_id")
    private Long datasourceId;
    /**
     * 数据集SQL
     */
    @TableField(value = "base_sql")
    private String baseSQL;
    /**
     * 数据集版本号
     */
    @TableField(value = "version")
    private Integer version;
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
    @TableLogic(value = "null",delval = "now()")
    private LocalDateTime deletedAt;
}
