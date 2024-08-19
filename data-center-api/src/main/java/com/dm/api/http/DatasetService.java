package com.dm.api.http;

import com.dm.api.vo.DatasetVO;

/**
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-19 02:26
 */
public interface DatasetService {
    /**
     * 获得数据集VO
     * @param id 数据集id
     * @return 数据集VO
     */
    DatasetVO getById(Long id);

}
