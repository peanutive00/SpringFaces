package com.SpringFaces.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.SpringFaces.model.Todo;
import com.SpringFaces.service.TodoService;
import com.SpringFaces.dao.TodoDao;



@Service("todoService")
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;
    
    @Transactional
    @Override
    public void createTodo(Todo todo) {
        todoDao.persitTodo(todo);
    }

    @Transactional
    @Override
    public Todo getTodo(int id) {
        return todoDao.findTodo(id);
    }
    
    @Transactional
    @Override
    public List<Todo> getTodo() {
        return todoDao.findTodo();
    }
    
    @Transactional
    @Override
    public void updateTodo(Todo todo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public void deleteTodo(Todo todo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
