package org.example.restapi.repository;

import org.example.restapi.domain.Coffee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CoffeeRepository {

    @Bean
    public List<Coffee> beanCoffee(){
        Coffee coffee = new Coffee(1, "Black coffee", "60%", 3.0);
        Coffee coffee2 = new Coffee(2, "Green tea", "90%", 4.5);
        Coffee coffee3 = new Coffee(3, "Milk tea", "100%", 2.5);
        return Arrays.asList(coffee, coffee2, coffee3);
    }

}
