package com.task_tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task_tracker.entity.Category;
import com.task_tracker.entity.Day;
import com.task_tracker.entity.Reward;
import com.task_tracker.entity.Task;
import com.task_tracker.entity.User;
import com.task_tracker.service.TaskServiceImpl;

@RestController
@RequestMapping("/task_tracker")
public class TaskController {

	@Autowired
	TaskServiceImpl taskService;
	
	//Get methods
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) {
		return new ResponseEntity<User>(taskService.getUserById(userId), HttpStatus.OK);
	}
	
	@GetMapping("/day/{dayId}")
	public ResponseEntity<Day> getDayById(@PathVariable int dayId) {
		return new ResponseEntity<Day>(taskService.getDayById(dayId), HttpStatus.OK);
	}
	
	@GetMapping("/task/{taskId}")
	public ResponseEntity<Task> getTaskById(@PathVariable int taskId) {
		return new ResponseEntity<Task>(taskService.getTaskById(taskId), HttpStatus.OK);
	}
	
	//Post methods
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<User>(taskService.addUser(user), HttpStatus.CREATED);
	}
	
	@PostMapping("/day")
	public ResponseEntity<Day> addDay(@RequestBody Day day) {
		return new ResponseEntity<Day>(taskService.addDay(day), HttpStatus.CREATED);
	}
	
	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		return new ResponseEntity<Category>(taskService.addCategory(category), HttpStatus.CREATED);
	}
	
	@PostMapping("/task")
	public ResponseEntity<Task> addTask(@RequestBody Task task) {
		return new ResponseEntity<Task>(taskService.addTask(task), HttpStatus.CREATED);
	}
	
	@PostMapping("/reward")
	public ResponseEntity<Reward> addReward(@RequestBody Reward reward) {
		return new ResponseEntity<Reward>(taskService.addReward(reward), HttpStatus.CREATED);
	}
	
	
	//Put methods
	
	@PutMapping("/user/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User user, int pointChange) {
		return new ResponseEntity<User>(taskService.updateUser(user, pointChange, userId), HttpStatus.OK);
	}
	
	@PutMapping("/day/{dayId}")
	public ResponseEntity<Day> updateDay(@PathVariable int dayId, @RequestBody Day day) {
		return new ResponseEntity<Day>(taskService.updateDay(day, dayId), HttpStatus.OK);
	}
	
	@PutMapping("/category/{categoryId}")
	public ResponseEntity<Category> updateCategory(@PathVariable int categoryId, @RequestBody Category category) {
		return new ResponseEntity<Category>(taskService.updateCategory(category, categoryId), HttpStatus.OK);
	}
	
	@PutMapping("/task/{taskId}")
	public ResponseEntity<Task> updateTask(@PathVariable int taskId, @RequestBody Task task) {
		return new ResponseEntity<Task>(taskService.updateTask(task, taskId), HttpStatus.OK);
	}
	
	@PutMapping("/reward/{rewardId}")
	public ResponseEntity<Reward> updateReward(@PathVariable int rewardId, @RequestBody Reward reward) {
		return new ResponseEntity<Reward>(taskService.updateReward(reward, rewardId), HttpStatus.OK);
	}
	
	
	//Delete methods
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId) {
		taskService.deleteUser(userId);
		return new ResponseEntity<String>("User successfully deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/reward/{rewardId}")
	public ResponseEntity<String> deleteReward(@PathVariable int rewardId) {
		taskService.deleteReward(rewardId);
		return new ResponseEntity<String>("Reward successfully deleted", HttpStatus.OK);
	}
	
}
