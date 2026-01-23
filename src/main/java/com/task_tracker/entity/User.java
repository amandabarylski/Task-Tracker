package com.task_tracker.entity;

//I copied and pasted a large list of imports from an entity from my final project as I was not sure which ones I would need.
//Importing them all meant I had them easily available and could delete the ones I didn't need later.
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(nullable = false)
	private String userName;
	private int points;
	
	//I used a one to one relationship with a shared primary key as each user has an individual shop attached to them.
	//This is my first time using a one to one relationship so I am learning as I go.
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Shop shop;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Day> days = new ArrayList<>();
	
	//I was initially only going to connect categories to tasks, but as the user can create categories specific to them,
	//I wanted them to be deleted if the user was.
	//Tasks and Rewards, since they are tied to Day and Shop, would already be deleted through cascade.
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Category> createdCategories = new ArrayList<>();

}
