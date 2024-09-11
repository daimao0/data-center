package com.dm.api.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

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
    private Long id;

    @Schema(title = "数据集名称")
    private String name;

    @Schema(title = "状态：0、未上线；1、已上线；2、编辑中（已上线）")
    private String status;

    @Schema(title = "当前版本号")
    private Integer version;

    @Schema(title = "创建时间")
    private String createdAt;

    @Schema(title = "更新时间")
    private String updatedAt;

    @Schema(title = "度量")
    private List<MeasureVO> measures;

    @Schema(title = "维度")
    private List<DimVO> dims;
}
