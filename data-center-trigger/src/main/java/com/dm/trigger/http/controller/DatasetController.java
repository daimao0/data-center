package com.dm.trigger.http.controller;

import com.dm.api.http.DatasetAppService;
import com.dm.api.request.DatasetBindDatasourceReq;
import com.dm.api.request.DatasetSaveReq;
import com.dm.api.vo.DatasetVO;
import com.dm.common.api.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author daimao
 * @date 2024/8/18 18:12
 */
@Tag(name = "数据集控制器", description = "数据集接口")
@RestController
@RequestMapping(value = "/api/v1/dataset")
public class DatasetController {
    @Resource
    private DatasetAppService datasetAppService;


    @GetMapping("/{id}")
    @Operation(summary = "查询数据集", description = "根据id查询数据集")
    public Response<DatasetVO> getById(@PathVariable("id") Long id) {
        DatasetVO vo = datasetAppService.getById(id);
        return Response.success(vo);
    }

    @PostMapping
    @Operation(summary = "保存数据集", description = "保存数据集")
    public Response<Void> save(@RequestBody @Validated DatasetSaveReq datasetSaveReq) {
        datasetAppService.save(datasetSaveReq);
        return Response.success();
    }

    @PostMapping("/bind/datasource")
    @Operation(summary = "数据集绑定数据源", description = "数据集绑定数据源")
    public Response<Void> bindDatasource(@RequestBody @Validated DatasetBindDatasourceReq req) {
        datasetAppService.bindDatasource(req);
        return Response.success();
    }

    @PostMapping(value = "/upload/file")
    @Operation(summary = "上传文件生成数据集", description = "上传文件生成数据集")
    public Response<Void> uploadFileGenDataset(@RequestParam("file") MultipartFile file) {
        datasetAppService.uploadFileGenDataset(file);
        return Response.success();
    }

    @GetMapping("{id}/trial/data")
    @Operation(summary = "根据数据集试跑数据", description = "根据数据集试跑数据")
    public Response<List<Map<String, Object>>> trial(@PathVariable("id") Long id) {
        List<Map<String, Object>> data = datasetAppService.trial(id);
        return Response.success(data);
    }
}
