package com.dm.api.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

/**
 * 数据存储上传参数
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-04 00:40
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Schema(title = "数据存储上传参数")
public class DataStorageUploadReq {
    /**
     * 数据源id
     */
    @Schema(description = "数据源id")
    @NotNull(message = "数据源id不能为空")
    private Long datasourceId;
    /**
     * 上传方式：cover:覆盖、append:追加
     */
    @Schema(description = "上传方式")
    @NotBlank(message = "上传方式")
    private String uploadMethod;
    /**
     * 上传的文件
     */
    @Schema(description = "上传的文件")
    @NotNull(message = "上传文件不能为空")
    private MultipartFile file;

}
