package com.spring.beans.impl;

import com.spring.beans.Coffee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Expresso implements Coffee {
    @Override
    public String makeCoffee() {
        return "Expresso Coffee";
    }
}
