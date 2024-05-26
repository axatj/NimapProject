package com.nimap.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.Project.entity.Category;



public interface CategoryRepository extends JpaRepository<Category,Long> {

}
