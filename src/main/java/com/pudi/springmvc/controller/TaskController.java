package com.pudi.springmvc.controller;

import com.pudi.springmvc.dto.CreateTaskDto;
import com.pudi.springmvc.model.Task;
import com.pudi.springmvc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
public class TaskController
{
    @Autowired
    private TaskService taskService;

    @ResponseBody
    @PostMapping("/tasks")
    public Task createTask(@RequestBody CreateTaskDto createTaskDto)
    {
        return taskService.createTask(createTaskDto);
    }

    @ResponseBody
    @GetMapping("/tasks")
    public Iterable<Task> getTasks()
    {
        return taskService.getTasks();
    }

    @ResponseBody
    @GetMapping("/task/{tid}")
    public Task getTask(@PathVariable("tid") long tid)
    {
        return taskService.getTask(tid);
    }

    @ResponseBody
    @DeleteMapping("/task/{tid}")
    public void deleteTask(@PathVariable("tid") long tid)
    {
        taskService.deleteTask(tid);
    }
}
