package com.pudi.springmvc.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long>
{
    List<Task> findTasksByAuthorId(Long uid);
}
