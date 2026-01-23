package com.task_tracker.entity;

//Just like in the User entity, I started with a copy-paste.
import java.util.ArrayList;
import java.util.List;
//I imported java.time to try and incorporate the LocalDate class; I am hoping it will properly work between the database and frontend.
import java.time.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Day {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dayId;
	
	@Column(nullable = false)
	private LocalDate date;
	private boolean doublePoints;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "day", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Task> tasks = new ArrayList<>();
	
}
