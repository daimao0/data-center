package com.dm.infrastructure.db.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 数据集维度PO
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-20 17:06
 */
@TableName(value = "t_dataset_dim")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class DatasetDimPO {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 英文名
     */
    @TableField(value = "en_name")
    private String enName;
    /**
     * 中文名
     */
    @TableField(value = "cn_name")
    private String cnName;
    /**
     * 数据集id
     */
    @TableField(value = "dataset_id")
    private Integer datasetId;
    /**
     * 版本号
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
    @TableLogic
    private LocalDateTime deletedAt;
}
