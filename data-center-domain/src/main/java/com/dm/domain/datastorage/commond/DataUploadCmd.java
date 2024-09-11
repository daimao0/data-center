package com.dm.domain.datastorage.commond;

import com.dm.common.enums.UploadMethod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * 数据存储上传参数
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-04 14:21
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class DataUploadCmd {
    /**
     * 数据存储id
     */
    @Schema(description = "数据仓储id")
    @NotNull(message = "数据存储id不能为空")
    private Long dataStorageId;
    /**
     * 文件名称
     */
    @Schema(description = "文件名称")
    @NotBlank(message = "文件名称不能为空")
    private String name;
    /**
     * 上传方式
     */
    @Schema(description = "上传方式")
    @NotNull(message = "上传方式不能为空")
    private UploadMethod uploadMethod;
    /**
     * 上传的数据
     */
    @NotEmpty(message = "上传的数据不能为空")
    private List<Map<String, Object>> data;
}
