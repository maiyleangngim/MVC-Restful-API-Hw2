package org.example.restapi.controller;

import org.example.restapi.dto.CoffeeResponse;
import org.example.restapi.service.CoffeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coffees")
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService){
        this.coffeeService = coffeeService;
    }
    @GetMapping
    public List<CoffeeResponse> getCoffees(){
        return coffeeService.getCoffees();
    }
}
