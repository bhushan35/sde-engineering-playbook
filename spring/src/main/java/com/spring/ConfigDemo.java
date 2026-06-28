package com.spring;

import com.spring.beans.*;
import com.spring.config.AnotherProjectConfig;
import com.spring.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigDemo {
    public static void main(String[] args) {
        Employee employee = new Employee("kartik");
        System.out.println("Non spring bean "+ employee.getName());

       //var  context =  new AnnotationConfigApplicationContext(ProjectConfig.class, AnotherProjectConfig.class);
        var  context =  new AnnotationConfigApplicationContext(ProjectConfig.class);
       var emp = context.getBean(Employee.class);
       System.out.println("spring bean  emp= "+ emp.getName());

        var s = context.getBean(String.class);
        System.out.println("spring bean String = "+ s);

        var i = context.getBean(Integer.class);
        System.out.println("spring bean Int = "+ i);
        var emp1 = context.getBean("emp2",Employee.class);
        System.out.println("spring bean  emp1= "+ emp1.getName());

        // component annotation
        var veh = context.getBean("vehicle",Vehicle.class);
        System.out.println("spring bean  vehicle= "+ veh.getName());

        var  person = context.getBean("person",Person.class);
        var vehicle = context.getBean("vehicle1", ToyotaVehicle.class);
        System.out.println("Person Name from spring context= "+ person.getName());
        System.out.println("Vehicle1 Name from spring context= "+ vehicle.getName());
        System.out.println("Vehicle owen by person= "+ person.getVehicle());

        var  person1 = context.getBean("person1",Person.class);
        System.out.println("Person1 Name from spring context= "+ person1.getName());
        System.out.println("Vehicle1 Name from spring context= "+ vehicle.getName());
        System.out.println("Vehicle owen by person1= "+ person1.getVehicle());


        var  car = context.getBean(Car.class);
        var  engine = context.getBean(Engine.class);
        System.out.println("Car Name from spring context= "+ car.getName());
        System.out.println("Engine Name from spring context= "+ engine.getName());
        System.out.println("Engine owen by car= "+ car.getEngine());

        var coffeeShop = context.getBean(CoffeeShop.class);
        Coffee coffee = coffeeShop.getCoffee();
        System.out.println(coffee.makeCoffee());

        context.close();
    }
}
