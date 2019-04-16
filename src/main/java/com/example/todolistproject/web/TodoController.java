package com.example.todolistproject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.todolistproject.domain.TaskTypeRepository;
import com.example.todolistproject.domain.ToDoRepository;
import com.example.todolistproject.domain.Todo;

@Controller
public class TodoController {
	@Autowired
	private ToDoRepository repository;

	@Autowired
	private TaskTypeRepository trepository;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String todolist(Model model) {
		Todo todo = new Todo();
		model.addAttribute("todo", todo);
		return "index";
	}

	// Show all tasks
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String index() {
		return "redirect:signup";
	}

	@RequestMapping(value = "/todolist", method = RequestMethod.GET)
	public String todoList(Model model) {
		model.addAttribute("todo", repository.findAll());
		return "todolist";
	}

	// RESTful service to get all tasks
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public @ResponseBody List<Todo> toDoRest() {
		return (List<Todo>) repository.findAll();
	}

	// RESTful service to get task by id
	@RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Todo> findTodoRest(@PathVariable("id") Long taskId) {
		return repository.findById(taskId);
	}

	// Add new task
	@RequestMapping(value = "/add")
	public String addTask(Model model) {
		model.addAttribute("todo", new Todo());
		model.addAttribute("tasktypes", trepository.findAll());
		return "addtask";
	}

	// Save new task
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Todo todo) {
		repository.save(todo);
		return "redirect:todolist";
	}

	// Delete task
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteTask(@PathVariable("id") Long taskId, Model model) {
		repository.deleteById(taskId);
		return "redirect:../todolist";
	}

	// Edit task
	@RequestMapping(value = "/edit/{id}")
	public String editTask(@PathVariable("id") Long taskId, Model model) {
		model.addAttribute("todo", repository.findById(taskId));
		model.addAttribute("types", trepository.findAll());
		return "edittask";
	}
}
