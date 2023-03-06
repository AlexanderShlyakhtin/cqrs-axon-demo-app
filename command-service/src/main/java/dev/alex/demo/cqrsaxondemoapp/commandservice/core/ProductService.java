package dev.alex.demo.cqrsaxondemoapp.commandservice.core;

import dev.alex.demo.cqrsaxondemoapp.commandservice.incomes.api.models.ProductRestModel;
import dev.alex.demo.cqrsaxondemoapp.commandservice.commands.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    private final CommandGateway commandGateway;

    public ProductService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }


    public String createProductCommand(ProductRestModel productRestModel) {
        CreateProductCommand createProductCommand =
                CreateProductCommand
                        .builder()
                        .productId(UUID.randomUUID().toString())
                        .name(productRestModel.getName())
                        .quantity(productRestModel.getQuantity())
                        .price(productRestModel.getPrice())
                        .build();
        String result = commandGateway.sendAndWait(createProductCommand);

        return result;
    }
}
