package dev.alex.demo.cqrsaxomdemoapp.queryservice.outcomes.postgres.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class ProductModel {

    @Id
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
