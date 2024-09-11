package com.dm.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-23 17:33
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Schema(title = "数据源保存参数")
public class DatasourceSaveReq {

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
