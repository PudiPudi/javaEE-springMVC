package com.pudi.springmvc.dto;

import com.pudi.springmvc.model.Task;

import java.util.Date;

public class CreateTaskDto
{
    private String title;
    private String description;
    private Task.Priority priority;
    private Date dueDate;
    private Long authorId;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Task.Priority getPriority()
    {
        return priority;
    }

    public void setPriority(Task.Priority priority)
    {
        this.priority = priority;
    }

    public Date getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }

    public Long getAuthorId()
    {
        return authorId;
    }

    public void setAuthorId(Long authorId)
    {
        this.authorId = authorId;
    }
}
