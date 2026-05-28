package org.example.restapi.service;

import org.example.restapi.domain.Coffee;
import org.example.restapi.dto.CoffeeResponse;

import java.util.List;

public interface CoffeeService {
        List<CoffeeResponse> getCoffees();

        CoffeeResponse getCoffeeById(Integer id);

        List<CoffeeResponse> searchCoffee(String name, Double price);


}
