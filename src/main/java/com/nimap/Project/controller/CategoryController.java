package com.nimap.Project.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.Project.entity.Category;
import com.nimap.Project.service.CategoryService;

@RestController
	@RequestMapping("/api/categories")
	public class CategoryController {
		@Autowired
		private CategoryService categoryService;

		@GetMapping("/getallcategories")
		public Page<Category> getAllCategories(@RequestParam int page, @RequestParam int size) {
			return categoryService.getAllCategories(page, size);
		}

		@PostMapping("/createcategory")
		public Category createCategory(@RequestBody Category category) {
			return categoryService.createCategory(category);
		}

		@GetMapping("/getcategoryById/{id}")
		public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
			Optional<Category> category = categoryService.getCategoryById(id);
			return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
		}

		@PutMapping("/updatecategory/{id}")
		public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
			Category updatedCategory = categoryService.updateCategory(id, categoryDetails);
			return ResponseEntity.ok(updatedCategory);
		}

		@DeleteMapping("/deletecategory/{id}")
		public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
			categoryService.deleteCategory(id);
			return ResponseEntity.noContent().build();
		}

	}
