package com.task_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task_tracker.entity.Day;

public interface DayRepository extends JpaRepository<Day, Integer> {

}
