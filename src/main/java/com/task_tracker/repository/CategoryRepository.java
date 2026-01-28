package com.task_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task_tracker.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
