package com.task_tracker.entity;

//I copied and pasted my import list from the User entity.
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Shop {

	@Id
	@Column(name = "user_id")
	private int userId;
	
	@ToString.Exclude
	@OneToOne
	@MapsId
	@JoinColumn(name = "user_id")
	private User user;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reward> rewards = new ArrayList<>();
	
}
