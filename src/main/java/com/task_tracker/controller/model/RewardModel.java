package com.task_tracker.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RewardModel {
	
	private String rewardName;
	private int cost;
	private int userId;

}
