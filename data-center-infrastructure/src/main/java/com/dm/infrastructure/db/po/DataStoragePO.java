package com.dm.infrastructure.db.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 数据存储
 * 存储数据源的数据本系统单点设计使用csv文件；可以改成oss读csv或mongodb、tidb等高效数据库
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-03 20:26
 */
@TableName(value = "t_data_storage")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class DataStoragePO {
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
     * 数据集类型：sql、sql类型；csv、csv类型；rts、实时传输类型
     */
    @TableField(value = "storage_type")
    private String storageType;
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
