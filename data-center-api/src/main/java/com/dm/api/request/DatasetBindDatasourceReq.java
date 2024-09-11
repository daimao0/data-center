package com.dm.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 数据集数据源请求参数
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-09 21:02
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Schema(title = "数据集数据源保存参数")
public class DatasetBindDatasourceReq {

    @Schema(description = "数据集id")
    @NotEmpty(message = "数据集id不能为空")
    private Long datasetId;
    /**
     * 数据源名称
     */
    @Schema(description = "数据源名称")
    @NotBlank(message = "数据源名称不能为空")
    private String name;
    /**
     * 数据源类型：sql、sql类型；csv、csv类型；rts、实时传输类型
     */
    @NotBlank(message = "数据源类型：sql类型；file类型；rts、实时传输类型")
    @Schema(description = "数据源类型：sql类型；file类型；rts、实时传输类型")
    private String datasourceType;
}
