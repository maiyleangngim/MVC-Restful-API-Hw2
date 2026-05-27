package org.example.restapi.service;

import org.example.restapi.dto.CoffeeResponse;

import java.util.List;

public interface CoffeeService {
        List<CoffeeResponse> getCoffees();

}
