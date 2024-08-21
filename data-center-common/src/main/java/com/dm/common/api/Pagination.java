package com.dm.common.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2023-01-04 2:32 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Schema(title = "分页参数")
public class Pagination {


    @Schema(title = "当前页")
    private Long page;

    @Schema(title = "页面大小")
    private Long size;

    public Long getPage() {
        return  page == null || page <= 0 ? 1 : page;
    }

    public Long getSize() {
        return  size == null || size <= 0 ? 10 : size;
    }
}
