package com.dm.api.http;

import com.dm.api.request.DataStorageUploadReq;

/**
 * 数据存储服务
 *
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-09-03 20:57
 */
public interface DataStorageAppService {

    /**
     * 覆盖上传
     *
     * @param cmd 上传参数
     */
    void cover(DataStorageUploadReq cmd);
}
