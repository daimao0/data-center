package com.dm.domain.dataset.commond;

import com.dm.common.enums.DatasetStatus;
import com.dm.common.enums.DimType;
import com.dm.common.enums.MeasureType;
import com.dm.common.exception.validation.NotEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-09 17:03
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class DatasetSaveCmd {
    /**
     * 数据集名称
     */
    @NotBlank(message = "数据集名称不能为空")
    private String name;
    /**
     * 状态：offline、未上线；online、已上线；editing、编辑中（已上线）
     */
    @NotEnum(clazz = DatasetStatus.class, method = "get", message = "数据集状态枚举不存在")
    private DatasetStatus status;
    /**
     * 度量字段
     */
    private List<MeasureSaveCmd> measures;
    /**
     * 维度字段
     */
    private List<DimSaveCmd> dims;


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Accessors(chain = true)
    public static class MeasureSaveCmd {

        @NotBlank(message = "字段名称不能为空")
        private String enName;

        @NotBlank(message = "显示名称不能为空")
        private String displayName;

        @NotBlank(message = "字段类型不能为空")
        private MeasureType measureType;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Accessors(chain = true)
    public static class DimSaveCmd {

        @NotBlank(message = "字段名称不能为空")
        private String enName;

        @NotBlank(message = "显示名称不能为空")
        private String displayName;

        @NotBlank(message = "字段类型不能为空")
        private DimType dimType;
    }
}
