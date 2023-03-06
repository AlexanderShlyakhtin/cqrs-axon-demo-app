package dev.alex.demo.cqrsaxomdemoapp.queryservice.outcomes.postgres.repositories;

import dev.alex.demo.cqrsaxomdemoapp.queryservice.outcomes.postgres.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, String> {

}
