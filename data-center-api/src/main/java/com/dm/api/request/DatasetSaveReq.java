package com.dm.api.request;

import com.dm.common.enums.DatasetStatus;
import com.dm.common.exception.validation.NotEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author daimao
 * @date 2024/8/19 1:02
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Schema(title = "数据集保存参数")
public class DatasetSaveReq {
    /**
     * 数据集名称
     */
    @Schema(description = "数据集名称")
    @NotBlank(message = "数据集名称不能为空")
    private String name;
    /**
     * 状态：offline、未上线；online、已上线；editing、编辑中（已上线）
     */
    @NotEnum(clazz = DatasetStatus.class, method = "get", message = "数据集状态枚举不存在")
    @Schema(description = " 状态：offline、未上线；online、已上线；editing、编辑中（已上线）")
    private String status;
    /**
     * 度量字段
     */
    @Schema(title = "度量字段")
    private List<MeasureSaveReq> measures;
    /**
     * 维度字段
     */
    @Schema(title = "维度字段")
    private List<DimSaveReq> dims;


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Accessors(chain = true)
    @Schema(title = "度量创建参数")
    public static class MeasureSaveReq {

        @Schema(description = "字段名称")
        @NotBlank(message = "字段名称不能为空")
        private String enName;

        @Schema(description = "显示名称")
        @NotBlank(message = "显示名称不能为空")
        private String displayName;

        @Schema(description = "字段类型")
        @NotBlank(message = "字段类型不能为空")
        private String measureType;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Accessors(chain = true)
    @Schema(title = "维度创建参数")
    public static class DimSaveReq {

        @Schema(description = "字段名称")
        @NotBlank(message = "字段名称不能为空")
        private String enName;

        @Schema(description = "显示名称")
        @NotBlank(message = "显示名称不能为空")
        private String displayName;

        @Schema(description = "字段类型")
        @NotBlank(message = "字段类型不能为空")
        private String dimType;
    }
}
