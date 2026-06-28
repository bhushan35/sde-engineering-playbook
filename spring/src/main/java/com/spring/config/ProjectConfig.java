package com.spring.config;

import com.spring.beans.Employee;
import org.springframework.context.annotation.*;

@Configuration
@Import({AnotherProjectConfig.class})
@ComponentScan( basePackages = {"com.spring.beans"})
public class ProjectConfig {

    @Bean(name = "firstEmployee")
    @Description("firest employee")
    public Employee employee1() {
        return new Employee("Test1");
    }

    @Bean(value = "secondEmployee")
    @Primary
    public Employee employee2() {
        return new Employee("Test2");
    }

    @Bean ( "thirdEmployee")
    public Employee employee3() {
        return new Employee("Test3");
    }

    @Bean ({ "emp1", "emp2"})
    public Employee employee4() {
        return new Employee("Test4");
    }
}
