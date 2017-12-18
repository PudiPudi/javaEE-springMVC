package com.pudi.springmvc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task
{
    public enum Priority {
        LOW, MEDIUM, HIGH
    }
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Priority priority;
    @Column
    private Date dueAt;
    @Column
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

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

    public Priority getPriority()
    {
        return priority;
    }

    public void setPriority(Priority priority)
    {
        this.priority = priority;
    }

    public Date getDueAt()
    {
        return dueAt;
    }

    public void setDueAt(Date dueAt)
    {
        this.dueAt = dueAt;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public User getAuthor()
    {
        return author;
    }

    public void setAuthor(User author)
    {
        this.author = author;
    }
}
