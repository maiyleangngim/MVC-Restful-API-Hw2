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
                .map(coffee -> new CoffeeResponse(coffee.getName(), coffee.getDescription(), coffee.getPrice()))
                .toList();
    }

    @Override
    public CoffeeResponse getCoffeeById(Integer id) {
        List<Coffee> coffee = coffeeRepository.beanCoffee();
        return coffee.stream()
                .filter(coffee1 -> coffee1.getId().equals(id))
                .findFirst()
                .map(coffee1 -> new CoffeeResponse(coffee1.getName(),coffee1.getDescription() ,coffee1.getPrice()))
                .orElse(null);
    }

    @Override
    public List<CoffeeResponse> searchCoffee(String name, Double price) {
        List<Coffee> coffee = coffeeRepository.beanCoffee();
        return coffee.stream()
                .filter(coffee1 -> coffee1.getName().toLowerCase().contains(name.toLowerCase()) && coffee1.getPrice().equals(price))
                .map(coffee1 -> new CoffeeResponse(coffee1.getName(), coffee1.getDescription(), coffee1.getPrice()))
                .toList();
    }
}
