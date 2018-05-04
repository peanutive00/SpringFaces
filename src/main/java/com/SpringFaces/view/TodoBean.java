package com.SpringFaces.view;

import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowired;

import com.SpringFaces.model.Todo;
import com.SpringFaces.service.TodoService;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.primefaces.context.RequestContext;

@Component
@Scope("view")
public class TodoBean implements Serializable {

    private static final long serialVersionUID = 475918891428093041L;
    
    @Autowired
    private TodoService todoService;

    private List<Todo> list;
    
    private Todo todo;

    private Todo oldTodo;
    
    private boolean selectAll;

    @PostConstruct
    public void init() {
        try {
            this.list = new ArrayList<>(this.todoService.getTodo());
            this.todo = new Todo();
            this.selectAll = false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public void createTodo(){
        try{
            this.todoService.createTodo(todo);
            this.init();
            RequestContext.getCurrentInstance().execute("PF('createTodoDlg').hide();");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public void updateTodo(){
        try{
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public void deleteTodo(){
        try{
            for(Todo t : this.list){
               this.todoService.deleteTodo(todo);
            }
            this.init();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public void selectAllJobListener() {
        this.selectAll = !this.selectAll;
        if (this.selectAll == false) {
            for (Todo t : this.list) {
                t.setSelected(true);
            }
        }else{
            for (Todo t : this.list) {
                t.setSelected(false);
            }
        }
    }
    
    public Date getMinDate() {
        return Calendar.getInstance().getTime();
    }
    
    public List<Todo> getList() {
        return list;
    }

    public void setList(List<Todo> list) {
        this.list = list;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public Todo getOldTodo() {
        return oldTodo;
    }

    public void setOldTodo(Todo oldTodo) {
        this.oldTodo = oldTodo;
    }
    
    public boolean isSelectAll() {
        return selectAll;
    }

    public void setSelectAll(boolean selectAll) {
        this.selectAll = selectAll;
    }

}
