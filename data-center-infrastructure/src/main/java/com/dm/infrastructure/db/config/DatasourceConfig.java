package com.dm.infrastructure.db.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author daimao
 * @date 2024/8/18 13:22
 */
@Configuration
@MapperScan(value = "com.dm.infrastructure.db.mapper")
public class DatasourceConfig {
}
