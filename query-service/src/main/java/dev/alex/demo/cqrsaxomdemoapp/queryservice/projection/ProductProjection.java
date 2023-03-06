package dev.alex.demo.cqrsaxomdemoapp.queryservice.projection;

import dev.alex.demo.cqrsaxomdemoapp.queryservice.incomes.models.ProductRestModel;
import dev.alex.demo.cqrsaxomdemoapp.queryservice.outcomes.postgres.models.ProductModel;
import dev.alex.demo.cqrsaxomdemoapp.queryservice.outcomes.postgres.repositories.ProductRepository;
import dev.alex.demo.cqrsaxomdemoapp.queryservice.queries.GetAllProductsQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductProjection {

    private final ProductRepository productRepository;

    @QueryHandler
    public List<ProductRestModel> handle(GetAllProductsQuery getAllProductsQuery) {
        List<ProductModel> productModels =
                productRepository.findAll();

        List<ProductRestModel> productRestModels = productModels
                .stream()
                .map(productModel -> ProductRestModel
                        .builder()
                        .quantity(productModel.getQuantity())
                        .name(productModel.getName())
                        .price(productModel.getPrice())
                        .build())
                .toList();

        return productRestModels;

    }
}
