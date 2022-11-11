package io.github.dev_alan87.booking.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.dev_alan87.booking.domain.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
