package org.example.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.restapi.dto.CoffeeResponse;
import org.example.restapi.service.CoffeeService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
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


    // this one we catch the value from the url
    @GetMapping("/{id}")
    public CoffeeResponse getCoffeeById(@PathVariable Integer id){
        return coffeeService.getCoffeeById(id);
    }


    // this part we want to request the value from url
    @GetMapping("/search")
    public List<CoffeeResponse> searchCoffees(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "0") Double price
    ){
        return coffeeService.searchCoffee(name, price);
    }
}
