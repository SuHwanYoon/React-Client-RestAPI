package com.yoon.rest.webservices.restfulwebservices.todo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "yoon", "리액트를 학습하기!!!!!!",
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "yoon", "Learn JavaScriptES6+ Now!",
				LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "yoon", "Learn Could Computing Now!",
				LocalDate.now().plusYears(3), false));

	}
	
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = 
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
		return todo;
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(Todo todo) {
		//id를 기준으로 삭제
		deleteById(todo.getId());
		// 새로운 todo 추가
		todos.add(todo);
	}
}