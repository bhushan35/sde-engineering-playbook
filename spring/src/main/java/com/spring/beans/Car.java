package com.spring.beans;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
@Getter
public class Car {
    String name;

//    @Autowired
    Engine engine;
    @Autowired
    Car( Engine engine) {
        this.engine = engine;
        System.out.println("car bean created");
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @PostConstruct
    public void init() {
        this.name = "Kia";
    }
}
