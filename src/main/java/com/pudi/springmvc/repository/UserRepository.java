package com.pudi.springmvc.repository;

import com.pudi.springmvc.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByFirstName(String firstName);
    User findByLastName(String lastName);
}
