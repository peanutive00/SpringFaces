package com.SpringFaces.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Criteria;

import com.SpringFaces.model.Todo;
import com.SpringFaces.dao.TodoDao;


@Repository("todoDao")
public class TodoDaoImpl implements TodoDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void persitTodo(Todo todo) {
        this.sessionFactory.getCurrentSession()
                           .save(todo);
    }

    @Override
    public List<Todo> findTodo() {
        List<Todo> result = (List<Todo>) this.sessionFactory.getCurrentSession()
                                                            .createCriteria(Todo.class)
                                                            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return result;
    }

    @Override
    public Todo findTodo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mergeTodo(Todo todo) {
        this.sessionFactory.getCurrentSession().update(todo);
    }

    @Override
    public void removeTodo(Todo todo) {
        this.sessionFactory.getCurrentSession().delete(todo);
    }
    
}
