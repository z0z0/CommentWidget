package com.zopr.widget.dao.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by zorana on 2/21/16.
 */
public abstract class JdbcBaseRepository {

    private static final String CONNECTION_QUERY="select 'Connected to '|| current_database()||' as '||current_user";

    protected DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;

    protected JdbcBaseRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    protected JdbcBaseRepository() {
    }

    public String getDbStatus() {
        try {
            return this.jdbcTemplate.queryForObject(CONNECTION_QUERY, String.class);
        } catch (DataAccessException e) {
            int sqlErrorCode = 0;
            String sqlMessage = null;
            Throwable nestedThrowable = e;
            while (nestedThrowable != null) {
                if (nestedThrowable instanceof SQLException) {
                    SQLException sqlException = (SQLException) nestedThrowable;
                    sqlErrorCode = sqlException.getErrorCode();
                    sqlMessage = sqlException.getMessage();
                }
                nestedThrowable = nestedThrowable.getCause();
            }

            throw new IllegalStateException("Could not retrieve data ", e);
        }
    }
}
