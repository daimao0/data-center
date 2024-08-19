package com.dm.trigger.http.controller;

import com.dm.api.http.DatasetService;
import com.dm.api.vo.DatasetVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daimao
 * @date 2024/8/18 18:12
 */

@RestController
@RequestMapping(value = "/api/v1/dataset")
public class DatasetController {
    @Resource
    private  DatasetService datasetService;


    @GetMapping
    public DatasetVO dataset(Long id) {
        return datasetService.getById(id);
    }
}
