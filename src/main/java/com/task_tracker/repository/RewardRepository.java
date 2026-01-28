package com.task_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task_tracker.entity.Reward;

public interface RewardRepository extends JpaRepository<Reward, Integer> {

}
