package dev.alex.demo.cqrsaxomdemoapp.queryservice.core;

import dev.alex.demo.cqrsaxomdemoapp.queryservice.incomes.models.ProductRestModel;
import dev.alex.demo.cqrsaxomdemoapp.queryservice.queries.GetAllProductsQuery;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final QueryGateway queryGateway;

    public List<ProductRestModel> getAllProduct() {
        GetAllProductsQuery getAllProductsQuery = new GetAllProductsQuery();
        List<ProductRestModel> productRestModels = queryGateway.query(getAllProductsQuery,
                        ResponseTypes.multipleInstancesOf(ProductRestModel.class))
                .join();
        return productRestModels;
    }
}
