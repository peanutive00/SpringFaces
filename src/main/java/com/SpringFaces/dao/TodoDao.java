package com.SpringFaces.dao;

import java.util.List;

import com.SpringFaces.model.Todo;

public interface TodoDao {
    
    void persitTodo(Todo todo);
    
    List<Todo> findTodo();
    
    Todo findTodo(int id);
    
    void mergeTodo(Todo todo);
    
    void removeTodo(Todo todo);
    
}
