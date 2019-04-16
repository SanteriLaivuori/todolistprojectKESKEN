package com.example.todolistproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.todolistproject.domain.TaskType;
import com.example.todolistproject.domain.TaskTypeRepository;
import com.example.todolistproject.domain.ToDoRepository;
import com.example.todolistproject.domain.Todo;
import com.example.todolistproject.domain.User;
import com.example.todolistproject.domain.UserRepository;

@SpringBootApplication
public class TodolistprojectApplication {
	@Autowired
	private ToDoRepository repository;
	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(TodolistprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner Todo(ToDoRepository repository, TaskTypeRepository trepository,
			UserRepository urepository) {
		return (args) -> {

			trepository.save(new TaskType("Freetime"));
			trepository.save(new TaskType("School"));
			trepository.save(new TaskType("Work"));

			repository.save(new Todo("Read a book", 2019-4-16, trepository.findByName("Freetime").get(0)));

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};
	}
}