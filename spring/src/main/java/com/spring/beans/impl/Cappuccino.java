package com.spring.beans.impl;

import com.spring.beans.Coffee;
import org.springframework.stereotype.Component;

@Component
public class Cappuccino implements Coffee {
    @Override
    public String makeCoffee() {
        return "Cappuccino Coffee";
    }
}
