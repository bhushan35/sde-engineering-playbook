package com.spring.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


@Getter
@Setter
@ToString
@Component
public class Vehicle implements InitializingBean, DisposableBean {
        String name;

        @PostConstruct
        public void init() {
            System.out.println("initializing vehicle bean properties");
            name= "Test789";
        }

    @PreDestroy
    public void destroy1() {
        System.out.println("destroying bean vehicle jakarta");
    }

    public void destroy() {
        System.out.println("destroying bean vehicle spring");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("initializing vehicle bean properties after propertySet");
        name= "Test987";
    }
}
