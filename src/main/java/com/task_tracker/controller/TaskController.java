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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task_tracker.controller.model.CategoryModel;
import com.task_tracker.controller.model.DayModel;
import com.task_tracker.controller.model.RewardModel;
import com.task_tracker.controller.model.TaskModel;
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
	
	//Looking back at my previous project, I opted to use the same trick to avoid recursion,
	//which is adding the object and then using my get method in the created message.
	@PostMapping("/day")
	public ResponseEntity<Day> addDay(@RequestBody DayModel dayModel) {
		Day day = taskService.addDay(dayModel);
		return new ResponseEntity<Day>(taskService.getDayById(day.getDayId()), HttpStatus.CREATED);
	}
	
	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody CategoryModel categoryModel) {
		Category category = taskService.addCategory(categoryModel);
		return new ResponseEntity<Category>(taskService.getCategoryById(category.getCategoryId()), HttpStatus.CREATED);
	}
	
	@PostMapping("/task")
	public ResponseEntity<Task> addTask(@RequestBody TaskModel taskModel) {
		Task task = taskService.addTask(taskModel);
		return new ResponseEntity<Task>(taskService.getTaskById(task.getTaskId()), HttpStatus.CREATED);
	}
	
	@PostMapping("/reward")
	public ResponseEntity<Reward> addReward(@RequestBody RewardModel rewardModel) {
		Reward reward = taskService.addReward(rewardModel);
		return new ResponseEntity<Reward>(taskService.getRewardById(reward.getRewardId()), HttpStatus.CREATED);
	}
	
	
	//Put methods
	
	//As an existing user could have lists of other entities in them, I separated the update and return as I did for other entities.
	@PutMapping("/user/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestParam String userName, @RequestParam int pointChange) {
		User user = taskService.updateUser(userName, pointChange, userId);
		return new ResponseEntity<User>(taskService.getUserById(user.getUserId()), HttpStatus.OK);
	}
	
	@PutMapping("/day/{dayId}")
	public ResponseEntity<Day> updateDay(@PathVariable int dayId, @RequestBody DayModel dayModel) {
		Day day = taskService.updateDay(dayModel, dayId);
		return new ResponseEntity<Day>(taskService.getDayById(day.getDayId()), HttpStatus.OK);
	}
	
	@PutMapping("/category/{categoryId}")
	public ResponseEntity<Category> updateCategory(@PathVariable int categoryId, @RequestBody CategoryModel categoryModel) {
		Category category = taskService.updateCategory(categoryModel, categoryId);
		return new ResponseEntity<Category>(taskService.getCategoryById(category.getCategoryId()), HttpStatus.OK);
	}
	
	@PutMapping("/task/{taskId}")
	public ResponseEntity<Task> updateTask(@PathVariable int taskId, @RequestBody TaskModel taskModel) {
		Task task = taskService.updateTask(taskModel, taskId);
		return new ResponseEntity<Task>(taskService.getTaskById(task.getTaskId()), HttpStatus.OK);
	}
	
	@PutMapping("/reward/{rewardId}")
	public ResponseEntity<Reward> updateReward(@PathVariable int rewardId, @RequestBody RewardModel rewardModel) {
		Reward reward = taskService.updateReward(rewardModel, rewardId);
		return new ResponseEntity<Reward>(taskService.getRewardById(reward.getRewardId()), HttpStatus.OK);
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
