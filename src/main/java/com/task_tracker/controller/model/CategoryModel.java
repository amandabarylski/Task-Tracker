package com.task_tracker.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryModel {

	private String categoryName;
	private int value;
	
	//I didn't include a list of task ids as the models are for streamlining the create process,
	//and tasks use existing categories.
	private int userId;
	
}
