package com.task_tracker.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskModel {
	
	private String taskName;
	
	private int dayId;
	private int categoryId;

}
