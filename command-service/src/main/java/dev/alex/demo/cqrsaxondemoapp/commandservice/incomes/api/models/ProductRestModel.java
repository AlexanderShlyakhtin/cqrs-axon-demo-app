package dev.alex.demo.cqrsaxondemoapp.commandservice.incomes.api.models;

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
