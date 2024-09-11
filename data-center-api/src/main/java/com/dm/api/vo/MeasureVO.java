package com.dm.api.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-08 21:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Schema(title = "度量VO")
public class MeasureVO {

    @Schema(description = "字段名称")
    private String enName;

    @Schema(description = "中文名称")
    private String displayName;

    @Schema(description = "字段类型")
    private String measureType;

    @Schema(description = "创建时间")
    private String createdAt;

    @Schema(description = "更新时间")
    private String updatedAt;
}
