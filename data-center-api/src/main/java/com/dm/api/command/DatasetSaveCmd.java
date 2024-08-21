package com.dm.api.command;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author daimao
 * @date 2024/8/19 1:02
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Schema(title = "数据集保存参数")
public class DatasetSaveCmd {
    /**
     * 数据集名称
     */
    @Schema(description = "数据集名称")
    @NotBlank(message = "数据集名称不能为空")
    private String name;
    /**
     * 数据集类型：0、sql类型；1、csv;2、实时传输类型
     */
    @Min(value = 0, message = "数据集类型：0、sql类型；1、csv;2、实时传输类型")
    @Schema(description = "数据集类型：0、sql类型；1、csv;2、实时传输类型")
    private Integer datasetType;
    /**
     * 状态：0、未上线；1、已上线；2、编辑中（已上线）
     */
    @Min(value = 0, message = "状态：0、未上线；1、已上线；2、编辑中（已上线）")
    @Schema(description = "状态：0、未上线；1、已上线；2、编辑中（已上线）")
    private Integer status;
    /**
     * 创建人
     */
    @Schema(description = "创建人")
    @NotBlank(message = "创建人不能为空")
    private String creator;
    /**
     * 管理员
     */
    @Schema(description = "管理员")
    @NotBlank(message = "管理员不能为空")
    private String managers;
}
