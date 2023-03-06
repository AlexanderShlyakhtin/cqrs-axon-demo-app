package dev.alex.demo.cqrsaxondemoapp.commandservice.events;


import dev.alex.demo.cqrsaxondemoapp.commandservice.outcomes.postgres.models.ProductModel;
import dev.alex.demo.cqrsaxondemoapp.commandservice.outcomes.postgres.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventHandler {

    private final ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductModel product = new ProductModel();
        BeanUtils.copyProperties(event,product);
        productRepository.save(product);

    }
}
