package com.springboot.lionboot.pratice.dao;


import com.springboot.lionboot.pratice.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDao {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }


    RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
            return user;
        }
    };


    public int deleteAll() {
       return this.jdbcTemplate.update("DELETE FROM users");
    }

    public int getCount()  {
        return this.jdbcTemplate.queryForObject("SELECT count(*) FROM users;", Integer.class);
    }

    public void add(User user) {
//        Connection conn = connectionMaker.openConnection();
        this.jdbcTemplate.update("INSERT INTO users(id, name, password) VALUES(?, ?, ?);",
                user.getId(), user.getName(), user.getPassword());

    }

    public User findById(String id)  {
        String sql = "SELECT id, name, password FROM users WHERE id=?;";
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public List<User> getAll(){
        String sql = "SELECT * from users order by id";
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public int deleteById(String id) {

        return this.jdbcTemplate.update("delete from users where id = ?",id);
    }


}


