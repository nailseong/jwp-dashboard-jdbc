package com.techcourse.config;

import java.util.Objects;
import javax.sql.DataSource;
import org.h2.jdbcx.JdbcDataSource;

public class DataSourceConfig {

    private static DataSource INSTANCE;

    private DataSourceConfig() {
    }

    public static DataSource getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = createJdbcDataSource();
        }
        return INSTANCE;
    }

    private static JdbcDataSource createJdbcDataSource() {
        final var jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;");
        jdbcDataSource.setUser("");
        jdbcDataSource.setPassword("");
        return jdbcDataSource;
    }
}
