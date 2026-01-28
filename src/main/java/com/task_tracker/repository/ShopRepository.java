package com.task_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task_tracker.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
