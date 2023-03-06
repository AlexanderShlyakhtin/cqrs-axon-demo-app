package dev.alex.demo.cqrsaxomdemoapp.queryservice.incomes.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRestModel {

    private String name;
    private BigDecimal price;
    private Integer quantity;
}
