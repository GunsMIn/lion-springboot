package com.springboot.lionboot.pratice.dao;

import com.springboot.lionboot.pratice.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStrategy implements StatementStrategy {
    User user;

    public AddStrategy(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement makePreparedStatement(Connection connection) throws SQLException {
        PreparedStatement stmt = connection.prepareCall("insert into users(id, name, password) values(?,?,?);");
        stmt.setString(1, user.getId());
        stmt.setString(2, user.getName());
        stmt.setString(3, user.getPassword());
        return stmt;
    }
}
