package ru.lomov.lesson_7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lomov.lesson_7.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
