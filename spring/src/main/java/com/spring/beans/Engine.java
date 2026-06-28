package com.spring.beans;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Engine {

    String name;

//    @Lazy
//    Car car;
    Engine() {
        System.out.println("Engine bean created");
    }


    @PostConstruct
    public void init() {
        this.name = "V8";
    }

    @Override
    public String toString() {
        return "Engine{" +
                "name='" + name + '\'' +
                '}';
    }
}
