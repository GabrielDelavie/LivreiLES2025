package com.livrei.les.ecomercy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livrei.les.ecomercy.domain.Product;
public interface ProductRepository extends JpaRepository<Product, Long> {

}
