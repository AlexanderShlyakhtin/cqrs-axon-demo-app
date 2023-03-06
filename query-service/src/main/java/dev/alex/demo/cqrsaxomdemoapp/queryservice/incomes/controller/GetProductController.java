package dev.alex.demo.cqrsaxomdemoapp.queryservice.incomes.controller;

import dev.alex.demo.cqrsaxomdemoapp.queryservice.core.ProductService;
import dev.alex.demo.cqrsaxomdemoapp.queryservice.incomes.models.ProductRestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class GetProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductRestModel> getAllProducts() {
        List<ProductRestModel> productRestModels = productService.getAllProduct();
        return productRestModels;
    }
}
