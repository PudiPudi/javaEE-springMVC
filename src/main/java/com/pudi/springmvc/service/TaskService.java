package com.pudi.springmvc.service;

import com.pudi.springmvc.dto.CreateTaskDto;
import com.pudi.springmvc.model.Task;
import com.pudi.springmvc.model.TaskRepository;
import com.pudi.springmvc.model.User;
import com.pudi.springmvc.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class TaskService
{
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public Task createTask(CreateTaskDto createTaskDto)
    {
        Task task = new Task();

        task.setTitle(createTaskDto.getTitle());
        task.setDescription(createTaskDto.getDescription());
        task.setDueDate(createTaskDto.getDueDate());
        task.setPriority(createTaskDto.getPriority());

        task.setCreateDate(new Date());
        User user = userRepository.findOne(createTaskDto.getAuthorId());
        task.setAuthor(user);

        return taskRepository.save(task);
    }

    public Iterable<Task> getTasks()
    {
        return taskRepository.findAll();
    }

    public Task getTask(long tid)
    {
        return taskRepository.findOne(tid);
    }

    public void deleteTask(long tid)
    {
        taskRepository.delete(tid);
    }
}
