package com.pudi.springmvc.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User
{
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Task> task;

    public List<Task> getTask()
    {
        return task;
    }

    public void setTask(List<Task> task)
    {
        this.task = task;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
