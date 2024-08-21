package com.dm.api.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-19 01:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Schema(title = "数据集详情")
public class DatasetVO {
    @Schema(title = "数据集id",minimum = "1")
    private String id;

    @Schema(title = "数据集名称")
    private String name;

    @Schema(title = "数据集类型：数据集类型：0、sql类型；1、csv;2、实时传输类型")
    private Integer datasetType;

    @Schema(title = "状态：0、未上线；1、已上线；2、编辑中（已上线）")
    private Integer status;

    @Schema(title = "当前版本号")
    private Integer version;

    @Schema(title = "创建时间")
    private String createAt;

}
