package com.SpringFaces.view;


import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowired;

import com.SpringFaces.model.Todo;
import com.SpringFaces.service.TodoService;

@Component
@Scope("view")
public class TodoBean {
    
    @Autowired
    private TodoService todoService;

    private List<Todo> list;
    
    private boolean selectAll;
    
    @PostConstruct
    public void init(){
        try{
            this.list = new ArrayList<>(this.todoService.getTodo());
            this.selectAll = false;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public List<Todo> getList() {
        return list;
    }

    public void setList(List<Todo> list) {
        this.list = list;
    }

    public boolean isSelectAll() {
        return selectAll;
    }

    public void setSelectAll(boolean selectAll) {
        this.selectAll = selectAll;
    }
    
}
