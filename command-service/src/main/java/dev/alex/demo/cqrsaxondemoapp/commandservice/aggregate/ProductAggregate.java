package dev.alex.demo.cqrsaxondemoapp.commandservice.aggregate;

import dev.alex.demo.cqrsaxondemoapp.commandservice.events.ProductCreatedEvent;
import dev.alex.demo.cqrsaxondemoapp.commandservice.commands.CreateProductCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        ProductCreatedEvent productCreatedEvent =
                new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand, productCreatedEvent);
        AggregateLifecycle.apply(productCreatedEvent);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        this.productId = productCreatedEvent.getProductId();
        this.name = productCreatedEvent.getName();
        this.quantity = productCreatedEvent.getQuantity();
        this.price = productCreatedEvent.getPrice();
    }

    public ProductAggregate() {

    }


}
