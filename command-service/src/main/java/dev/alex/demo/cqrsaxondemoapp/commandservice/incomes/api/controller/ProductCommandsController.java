package dev.alex.demo.cqrsaxondemoapp.commandservice.incomes.api.controller;

import dev.alex.demo.cqrsaxondemoapp.commandservice.core.ProductService;
import dev.alex.demo.cqrsaxondemoapp.commandservice.incomes.api.models.ProductRestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductCommandsController {

    private final ProductService productService;

    @PostMapping
    public String addProduct(@RequestBody ProductRestModel product) {
        productService.createProductCommand(product);
        return "Added product";
    }
}
