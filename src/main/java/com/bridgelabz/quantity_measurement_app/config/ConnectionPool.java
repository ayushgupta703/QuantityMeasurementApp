package com.bridgelabz.quantity_measurement_app.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class ConnectionPool {

    private static final HikariDataSource dataSource;

    static {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(
                ApplicationConfig.getProperty("db.url")
        );

        config.setUsername(
                ApplicationConfig.getProperty("db.username")
        );

        config.setPassword(
                ApplicationConfig.getProperty("db.password")
        );

        config.setMaximumPoolSize(
                Integer.parseInt(
                        ApplicationConfig.getProperty("hikari.maximumPoolSize")
                )
        );

        config.setMinimumIdle(
                Integer.parseInt(
                        ApplicationConfig.getProperty("hikari.minimumIdle")
                )
        );

        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}