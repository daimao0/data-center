package com.dm.api.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 数据源详情
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-23 17:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Schema(title = "数据源详情")
public class DatasourceVO {

    @Schema(title = "数据源id",minimum = "1")
    private Long id;

    @Schema(title = "数据源名称")
    private String name;

    @Schema(title = "数据源类型：file、mysql、presto")
    private String datasourceType;

    @Schema(title = "创建时间")
    private String createdAt;

    @Schema(title = "更新时间")
    private String updatedAt;
}
