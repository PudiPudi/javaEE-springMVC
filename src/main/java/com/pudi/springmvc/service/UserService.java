package com.pudi.springmvc.service;

import com.pudi.springmvc.model.User;
import com.pudi.springmvc.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User createUser(User user)
    {
        user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    public Iterable<User> getUsers()
    {
        return userRepository.findAll();
    }

    public User getUser(Long uid)
    {
        return userRepository.findOne(uid);
    }

    public void deleteUser(Long uid)
    {
        userRepository.delete(uid);
    }

}
