package com.dm.dao.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 数据集表
 * @author daimao
 * @date 2024/8/18 14:26
 */
@TableName(value = "t_dataset")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DatasetPO {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField(value = "name")
    private String name;
}
