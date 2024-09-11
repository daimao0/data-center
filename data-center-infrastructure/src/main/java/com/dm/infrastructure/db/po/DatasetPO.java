package com.dm.infrastructure.db.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 数据集表
 *
 * @author daimao
 * @date 2024/8/18 14:26
 */
@TableName(value = "t_dataset")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class DatasetPO {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 数据集名称
     */
    @TableField(value = "name")
    private String name;
    /**
     * 状态：offline、未上线；online、已上线；editing、编辑中（已上线）
     */
    @TableField(value = "status")
    private String status;
    /**
     * 当前版本号
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
