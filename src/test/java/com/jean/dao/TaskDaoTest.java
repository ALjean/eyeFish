package com.jean.dao;

import com.jean.entry.Task;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import runner.BaseTest;

/**
 * Created by stas on 30.05.15.
 */
public class TaskDaoTest extends BaseTest {

    private Task task;

    private int id;

    @Before
    public void init(){
        task = new Task();
        task.setName("TestTaskName");
        task.setDescription("Test Description JUNIT");

        id = 1;
    }

//    void create(Task task);
//    Task read(int id);
//    Task update(Task task);
//    boolean delete(int id);

    @Test
    public void createTest(){
        taskDao.create(task);
    }

    @Test
    public void readTest(){
        Task t= taskDao.read(id);
        assertEquals(t.getName(), "TestTaskName");
    }
}
