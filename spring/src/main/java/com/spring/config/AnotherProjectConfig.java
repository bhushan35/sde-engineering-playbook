package com.spring.config;

import com.spring.beans.Employee;
import com.spring.beans.Person;
import com.spring.beans.ToyotaVehicle;
import com.spring.beans.Vehicle;
import org.springframework.context.annotation.*;

@Configuration
public class AnotherProjectConfig {
    @Bean
    public String string() {
        return "Bhushan";
    }

    @Bean
    public Integer integer() {
        return 20;
    }

    @Bean
    public ToyotaVehicle vehicle1() {
        ToyotaVehicle veh =  new ToyotaVehicle();
        veh.setName("Toyota");
        return veh;
    }
    @Bean
    public Person person() {
        Person person = new Person();
        person.setName("Bhushan");
        person.setVehicle(vehicle1());
        return person;
    }
    @Bean
    public Person person1(ToyotaVehicle vehicle) {
        Person person = new Person();
        person.setName("Bhushan Joshi");
        person.setVehicle(vehicle);
        return person;
    }


}
