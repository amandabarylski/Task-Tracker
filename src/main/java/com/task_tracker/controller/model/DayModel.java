package com.task_tracker.controller.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DayModel {
	
	private String dayName;
	private LocalDate date;
	private boolean doublePoints;
	
	//Like categories, tasks are added to existing days and the model doesn't require a list.
	private int userId;

}
