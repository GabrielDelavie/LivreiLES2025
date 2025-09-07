package com.livrei.les.ecomercy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livrei.les.ecomercy.domain.Category;
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
