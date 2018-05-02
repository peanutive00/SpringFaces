package com.SpringFaces.view;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("view")
public class HelloWorldBean {

    private String helloMessage;

    @PostConstruct
    public void init(){
        this.helloMessage = "Hello World!!!";
    }
    
    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }
    
}
