package com.dm.common.api;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yanchenyang17958
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(title = "分页响应")
public class Page<T> {
    /**
     * 返回值
     */
    @Schema(title = "返回值")
    private List<T> data;

    /**
     * 当前页
     */
    @Schema(title = "当前页", minimum = "1")
    private Long page;
    /**
     * 页面大小
     */
    @Schema(title = "页面大小")
    private Long size;
    /**
     * 总量
     */
    @Schema(title = "总数")
    private Long total;


    public static <T> Page<T> toPage(Long page, Long size, Long total, List<T> data) {
        Page<T> twoWheelOrderInfoPage = new Page<>();
        twoWheelOrderInfoPage.setPage(page);
        twoWheelOrderInfoPage.setSize(size);
        twoWheelOrderInfoPage.setTotal(total);
        twoWheelOrderInfoPage.setData(data);
        return twoWheelOrderInfoPage;
    }
}