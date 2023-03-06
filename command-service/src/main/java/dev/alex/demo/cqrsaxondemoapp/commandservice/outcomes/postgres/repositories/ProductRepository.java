package dev.alex.demo.cqrsaxondemoapp.commandservice.outcomes.postgres.repositories;

import dev.alex.demo.cqrsaxondemoapp.commandservice.outcomes.postgres.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, String> {

}
