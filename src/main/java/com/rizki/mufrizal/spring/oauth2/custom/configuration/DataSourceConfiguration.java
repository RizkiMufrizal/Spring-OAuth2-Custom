package com.rizki.mufrizal.spring.oauth2.custom.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since Jan 30, 2017
 * @Time 12:49:36 PM
 * @Encoding UTF-8
 * @Project Spring-OAuth2-Custom
 * @Package com.rizki.mufrizal.spring.oauth2.custom.configuration
 *
 */
@Configuration
@PropertySource("classpath:application.yml")
public class DataSourceConfiguration {

    @Autowired
    private Environment environment;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
        dataSourceConfig.setJdbcUrl(environment.getRequiredProperty("spring.datasource.url"));
        dataSourceConfig.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        dataSourceConfig.setPassword(environment.getRequiredProperty("spring.datasource.password"));
        dataSourceConfig.setMaximumPoolSize(Integer.parseInt(environment.getRequiredProperty("spring.datasource.maximumPoolSize")));
        dataSourceConfig.setMinimumIdle(Integer.parseInt(environment.getRequiredProperty("spring.datasource.minimumIdle")));
        dataSourceConfig.setMaxLifetime(Integer.parseInt(environment.getRequiredProperty("spring.datasource.maxLifetime")));
        dataSourceConfig.setConnectionTimeout(Long.parseLong(environment.getRequiredProperty("spring.datasource.connectionTimeout")));
        dataSourceConfig.setIdleTimeout(Long.parseLong(environment.getRequiredProperty("spring.datasource.idleTimeout")));
        dataSourceConfig.addDataSourceProperty("poolName", environment.getRequiredProperty("spring.datasource.poolName"));
        dataSourceConfig.addDataSourceProperty("cachePrepStmts", "true");
        dataSourceConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        dataSourceConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return new HikariDataSource(dataSourceConfig);
    }
}
