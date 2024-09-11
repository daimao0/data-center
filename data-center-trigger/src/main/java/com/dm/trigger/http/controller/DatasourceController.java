package com.dm.trigger.http.controller;

import com.dm.api.request.DataStorageUploadReq;
import com.dm.api.request.DatasourceSaveReq;
import com.dm.api.http.DataStorageAppService;
import com.dm.api.http.DatasourceAppService;
import com.dm.api.vo.DatasourceVO;
import com.dm.common.api.Response;
import com.dm.common.api.ResponseCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-23 01:20
 */

@Tag(name = "数据源控制器", description = "数据源接口")
@RestController
@RequestMapping(value = "/api/v1/datasource")
public class DatasourceController {
    @Resource
    private DatasourceAppService datasourceAppService;

    @Resource
    private DataStorageAppService dataStorageAppService;
    @GetMapping("/{id}")
    @Operation(summary = "查询数据源", description = "根据id查询数据源")
    public Response<DatasourceVO> getById(@PathVariable("id") Long id) {
        DatasourceVO vo = datasourceAppService.getById(id);
        return Response.success(vo);
    }

    @PostMapping
    @Operation(summary = "保存数据源", description = "保存数据源")
    public Response<DatasourceVO> save(@RequestBody DatasourceSaveReq datasourceSaveReq) {
        datasourceAppService.save(datasourceSaveReq);
        return Response.success();
    }


    @PostMapping("/data/cover")
    @Operation(summary = "上传文件", description = "上传文件")
    public Response<Void> cover(@Validated DataStorageUploadReq dataStorageUploadReq) {
        //验证文件是否为空
        if (dataStorageUploadReq.getFile().isEmpty()) {
            return Response.failed(ResponseCode.VALIDATE_FAILED, "文件不存在");
        }
        dataStorageAppService.cover(dataStorageUploadReq);
        return Response.success();
    }

    @GetMapping("{id}/trial/data")
    @Operation(summary = "试跑数据",description = "试跑数据")
    public Response<List<Map<String,Object>>> trial(@PathVariable("id")Long id){
        List<Map<String,Object>> data = datasourceAppService.trial(id);
        return Response.success(data);
    }
}
