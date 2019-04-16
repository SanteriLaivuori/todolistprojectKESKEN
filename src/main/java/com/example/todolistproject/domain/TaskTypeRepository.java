package com.example.todolistproject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TaskTypeRepository extends CrudRepository<TaskType, Long> {

	List<TaskType> findByName(String name);
}
