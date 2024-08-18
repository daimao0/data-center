package com.dm.trigger.http.controller;

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
    @GetMapping
    public String dataset(Long id){
        return "index";
    }
}
