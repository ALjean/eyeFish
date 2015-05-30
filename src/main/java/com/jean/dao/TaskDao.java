package com.jean.dao;

import com.jean.entry.Task;

/**
 * Created by stas on 30.05.15.
 */
public interface TaskDao {


    void create(Task task);

    Task read(int id);

    Task update(Task task);

    boolean delete(int id);

}
