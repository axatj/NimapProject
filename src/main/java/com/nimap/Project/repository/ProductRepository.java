package com.nimap.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.Project.entity.Product;


public interface ProductRepository extends JpaRepository<Product,Long> {

}
