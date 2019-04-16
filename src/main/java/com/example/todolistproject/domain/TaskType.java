package com.example.todolistproject.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TaskType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tasktypeid;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tasktype")
	private List<Todo> todos;

	public TaskType() {
	}
	
	public TaskType(String name) {
		super();
		this.name = name;
	}

	public Long getTasktypeid() {
		return tasktypeid;
	}

	public void setTasktypeid(Long tasktypeid) {
		this.tasktypeid = tasktypeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	@Override
	public String toString() {
		return "TaskType [tasktypeid=" + tasktypeid + ", name=" + name + "]";
	}

}