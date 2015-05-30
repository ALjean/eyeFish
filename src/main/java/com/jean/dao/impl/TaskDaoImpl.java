package com.jean.dao.impl;

import com.jean.dao.TaskDao;
import com.jean.entry.Task;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by stas on 30.05.15.
 */

@Component
public class TaskDaoImpl extends BaseDaoImpl implements TaskDao {


    @Override
    public void create(Task task) {
        String sql = "INSERT INTO (name, description) VALUES (?, ?)";
        int result = jdbcTemplate.update(sql, task.getName(), task.getDescription());

        if (result != 0) {
            System.out.println("save task" + task.getName());
        } else {
            System.out.println("failed save" + task.getName());
        }


    }

    @Override
    public Task read(int id) {
        String sql = "SELECT * FROM Task WHERE id = ?";

        Task task = jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Task>() {

            @Override
            public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setName(rs.getString("name"));
                task.setDescription(rs.getString("description"));
                return task;
            }
        });
        return task;
    }

    @Override
    public Task update(Task task) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
