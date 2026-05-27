package org.example.restapi.service.impl;

import org.example.restapi.domain.Coffee;
import org.example.restapi.dto.CoffeeResponse;
import org.example.restapi.repository.CoffeeRepository;
import org.example.restapi.service.CoffeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {
    private final CoffeeRepository coffeeRepository;


    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public List<CoffeeResponse> getCoffees() {
        List<Coffee> coffees = coffeeRepository.beanCoffee();
        return coffees.stream()
                .filter(coffee -> coffee.getId() > 1)
                .map(coffee -> new CoffeeResponse(coffee.getName(), coffee.getDescription()))
                .toList();
    }

}
