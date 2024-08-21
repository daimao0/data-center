package com.dm.trigger.http.controller;

import com.dm.api.command.DatasetSaveCmd;
import com.dm.api.http.DatasetService;
import com.dm.api.vo.DatasetVO;
import com.dm.common.api.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author daimao
 * @date 2024/8/18 18:12
 */
@Tag(name = "数据集控制器", description = "数据集接口")
@RestController
@RequestMapping(value = "/api/v1/dataset")
public class DatasetController {
    @Resource
    private DatasetService datasetService;


    @GetMapping("/{id}")
    @Operation(summary = "查询数据集", description = "根据id查询数据集")
    public Response<DatasetVO> getById(@PathVariable("id") Long id) {
        DatasetVO vo = datasetService.getById(id);
        return Response.success(vo);
    }

    @PostMapping
    @Operation(summary = "保存数据集",description = "保存数据集")
    public Response<Void> save(@RequestBody @Validated DatasetSaveCmd datasetSaveCmd){
        datasetService.save(datasetSaveCmd);
        return Response.success();
    }
}
