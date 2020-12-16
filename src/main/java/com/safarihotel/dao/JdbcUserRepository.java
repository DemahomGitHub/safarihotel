package com.safarihotel.dao;

import com.safarihotel.helper.RowMapperHelper;
import com.safarihotel.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class JdbcUserRepository implements UserRepository {

    private final String DEF_USERS_BY_USERNAME_QUERY =
                         "select username, password, full_name, enabled " +
                         "from Users " +
                         "where username = ?";

    private final JdbcTemplate jdbc;

    @Autowired
    public JdbcUserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public User findByUsername(String username) {
        try {
            return this.jdbc.queryForObject(DEF_USERS_BY_USERNAME_QUERY, RowMapperHelper.mapRowToUser, username);
        } catch (DataAccessException ex) {
            log.info("No such username ["+username+"]");
            log.info(ex.getMessage());
            return null;
        }
    }
}
