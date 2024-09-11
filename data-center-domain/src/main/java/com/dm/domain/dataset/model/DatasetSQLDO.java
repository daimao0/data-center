package com.dm.domain.dataset.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * SQL类型的数据集
 * @author: yanchenyang958@hellobike.com
 * @date: 2024-08-22 00:08
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class DatasetSQLDO extends DatasetDO{

    private String baseSQL;
}
