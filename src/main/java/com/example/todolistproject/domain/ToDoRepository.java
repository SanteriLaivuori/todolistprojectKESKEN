package com.example.todolistproject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<Todo, Long> {
	List<Todo> findByid(Long id);
}
