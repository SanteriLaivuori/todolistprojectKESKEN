package com.example.todolistproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String todo;
	private int date;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "typeid")
	private TaskType ttype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public TaskType getTtype() {
		return ttype;
	}

	public void setTtype(TaskType ttype) {
		this.ttype = ttype;
	}
	
	

	public Todo(String todo, int date, TaskType ttype) {
		super();
		this.todo = todo;
		this.date = date;
		this.ttype = ttype;
	}

	public Todo() {
		super();

	}

	@Override
	public String toString() {
		if (this.ttype != null)
		return "Todo [id=" + id + ", todo=" + todo + ", date=" + date + this.getTtype() +"]";
		else
			return "Todo [id=" + id + ", todo=" + todo + ", date=" + date + "]";
	}
	

}
