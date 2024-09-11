package com.dm.infrastructure.db.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * csv文件存储类型
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-03 20:50
 */
@TableName(value = "t_data_storage_csv")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class DataStorageCSVPO {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 数据仓储id
     */
    @TableField(value = "data_storage_id")
    private Long dataStorageId;
    /**
     * 文件路径
     */
    @TableField(value = "path")
    private String path;
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
