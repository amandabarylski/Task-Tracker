package com.task_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task_tracker.controller.model.CategoryModel;
import com.task_tracker.controller.model.DayModel;
import com.task_tracker.controller.model.RewardModel;
import com.task_tracker.controller.model.TaskModel;
import com.task_tracker.entity.Category;
import com.task_tracker.entity.Day;
import com.task_tracker.entity.Reward;
import com.task_tracker.entity.Task;
import com.task_tracker.entity.User;
import com.task_tracker.exception.ResourceNotFoundException;
import com.task_tracker.repository.CategoryRepository;
import com.task_tracker.repository.DayRepository;
import com.task_tracker.repository.RewardRepository;
import com.task_tracker.repository.TaskRepository;
import com.task_tracker.repository.UserRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DayRepository dayRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	RewardRepository rewardRepository;
	
	
	//Get methods
	//In case I needed to make changes to avoid recursion, I first created a variable to hold the object being returned.
	//After my initial test, I had to come back to work on my methods as the recursion did indeed happen.
	@Override
	public User getUserById(int userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		for (Day day : user.getDays()) {
			day.setUser(null);
			day.getTasks().clear();
		}
		for (Category category : user.getCreatedCategories()) {
			category.setUser(null);
			category.getTasks().clear();
		}
		for (Reward reward : user.getRewards()) {
			reward.setUser(null);
		}
		return user;
	}

	@Override
	public Day getDayById(int dayId) {
		Day day = dayRepository.findById(dayId).orElseThrow(() -> new ResourceNotFoundException("Day", "Id", dayId));
		for (Task task : day.getTasks()) {
			task.setDay(null);
			task.setCategory(null);
		}
		day.setUser(null);
		return day;
	}
	
	@Override
	public Category getCategoryById(int categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
		category.setUser(null);
		category.getTasks().clear();
		return category;
	}

	@Override
	public Task getTaskById(int taskId) {
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task", "Id", taskId));
		task.setDay(null);
		task.getCategory().setTasks(null);
		task.getCategory().setUser(null);
		return task;
	}
	
	@Override
	public Reward getRewardById(int rewardId) {
		Reward reward = rewardRepository.findById(rewardId).orElseThrow(() -> new ResourceNotFoundException("Reward", "Id", rewardId));
		reward.setUser(null);
		return reward;
	}

//	@Override
//	public Shop getShopById(int shopId) {
//		Shop shop = shopRepository.findById(shopId).orElseThrow(() -> new ResourceNotFoundException( "User", "Id", shopId));
//		return shop;
//	}

	
	//Post methods
	
	//I didn't need to change my addUser method as there is nothing in the three lists upon user creation.
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Day addDay(DayModel dayModel) {
		Day day = new Day();
		User user = userRepository.findById(dayModel.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User", "Id", dayModel.getUserId()));
		
		day.setUser(user);
		day.setDate(dayModel.getDate());
		day.setDoublePoints(dayModel.isDoublePoints());
		
		return dayRepository.save(day);
	}

	@Override
	public Category addCategory(CategoryModel categoryModel) {
		Category category = new Category();
		User user = userRepository.findById(categoryModel.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", categoryModel.getUserId()));
		
		category.setUser(user);
		category.setName(categoryModel.getCategoryName());
		category.setValue(categoryModel.getValue());
		
		return categoryRepository.save(category);
	}

	@Override
	public Task addTask(TaskModel taskModel) {
		Task task = new Task();
		Day day = dayRepository.findById(taskModel.getDayId()).orElseThrow(() -> new ResourceNotFoundException("Day", "Id", taskModel.getDayId()));
		Category category = categoryRepository.findById(taskModel.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", taskModel.getCategoryId()));
		
		task.setDay(day);
		task.setCategory(category);
		task.setName(taskModel.getTaskName());
		
		return taskRepository.save(task);
	}

	@Override
	public Reward addReward(RewardModel rewardModel) {
		Reward reward = new Reward();
		User user = userRepository.findById(rewardModel.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", rewardModel.getUserId()));
		
		reward.setUser(user);
		reward.setName(rewardModel.getRewardName());
		reward.setCost(rewardModel.getCost());
		
		return rewardRepository.save(reward);
	}

	
	//Put methods
	@Override
	public User updateUser(String userName, int pointChange, int userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		int newAmount = user.getPoints() + pointChange;
		
		user.setUserName(userName);
		user.setPoints(newAmount);
		
		return userRepository.save(user);
	}
	
//	@Override
//	public User updatePoints(int pointChange, int userId) {
//		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
//		
//		int newAmount = user.getPoints() + pointChange;
//		user.setPoints(newAmount);
//		
//		return userRepository.save(user);
//	}

	@Override
	public Day updateDay(DayModel dayModel, int dayId) {
		Day day = dayRepository.findById(dayId).orElseThrow(() -> new ResourceNotFoundException("Day", "Id", dayId));
		
		day.setDate(dayModel.getDate());
		day.setDoublePoints(dayModel.isDoublePoints());
		
		return dayRepository.save(day);
	}

	@Override
	public Category updateCategory(CategoryModel categoryModel, int categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
		
		category.setName(categoryModel.getCategoryName());
		category.setValue(categoryModel.getValue());
		
		return categoryRepository.save(category);
	}

	@Override
	public Task updateTask(TaskModel taskModel, int taskId) {
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task", "Id", taskId));
		Category category = categoryRepository.findById(taskModel.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", taskModel.getCategoryId()));
		
		task.setName(taskModel.getTaskName());
		task.setCategory(category);
		
		return taskRepository.save(task);
	}

	@Override
	public Reward updateReward(RewardModel rewardModel, int rewardId) {
		Reward reward = rewardRepository.findById(rewardId).orElseThrow(() -> new ResourceNotFoundException("Reward", "Id", rewardId));
		
		reward.setName(rewardModel.getRewardName());
		reward.setCost(rewardModel.getCost());
		
		return rewardRepository.save(reward);
	}

	
	//Delete methods
	@Override
	public void deleteUser(int userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException( "User", "Id", userId));
		userRepository.delete(user);
	}

	@Override
	public void deleteReward(int rewardId) {
		Reward reward = rewardRepository.findById(rewardId).orElseThrow(() -> new ResourceNotFoundException( "Reward", "Id", rewardId));
		rewardRepository.delete(reward);
	}

}
