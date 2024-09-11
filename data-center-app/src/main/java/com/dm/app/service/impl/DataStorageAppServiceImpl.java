package com.dm.app.service.impl;

import com.dm.api.request.DataStorageUploadReq;
import com.dm.api.http.DataStorageAppService;
import org.springframework.stereotype.Service;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-03 21:01
 */
@Service
public class DataStorageAppServiceImpl implements DataStorageAppService {

    /**
     * 覆盖上传
     *
     * @param cmd 上传参数
     */
    @Override
    public void cover(DataStorageUploadReq cmd) {

    }
}
