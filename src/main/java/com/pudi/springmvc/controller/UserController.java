package com.pudi.springmvc.controller;

import com.pudi.springmvc.model.User;
import com.pudi.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/users")
    public Iterable<User> getUsers()
    {
        return userService.getUsers();
    }

    @ResponseBody
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long uid)
    {
        return userService.getUser(uid);
    }

    @ResponseBody
    @PostMapping("/users")
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long uid)
    {
        userService.deleteUser(uid);
    }

}
