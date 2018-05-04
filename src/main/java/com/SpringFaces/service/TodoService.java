package com.SpringFaces.service;

import com.SpringFaces.model.Todo;
import java.util.List;

public interface TodoService {
    
    void createTodo(Todo todo);
    
    List<Todo> getTodo();
    
    Todo getTodo(int id);
    
    void updateTodo(Todo todo);
    
    void deleteTodo(Todo todo);
    
}
