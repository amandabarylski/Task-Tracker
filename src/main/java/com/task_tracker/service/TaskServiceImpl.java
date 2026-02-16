package com.task_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return user;
	}

	@Override
	public Day getDayById(int dayId) {
		Day day = dayRepository.findById(dayId).orElseThrow(() -> new ResourceNotFoundException("Day", "Id", dayId));
		return day;
	}

	@Override
	public Task getTaskById(int taskId) {
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task", "Id", taskId));
		return task;
	}

//	@Override
//	public Shop getShopById(int shopId) {
//		Shop shop = shopRepository.findById(shopId).orElseThrow(() -> new ResourceNotFoundException( "User", "Id", shopId));
//		return shop;
//	}

	
	//Post methods
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Day addDay(Day day) {
		return dayRepository.save(day);
	}

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Reward addReward(Reward reward) {
		return rewardRepository.save(reward);
	}

	
	//Put methods
	@Override
	public User updateUser(User user, int pointChange, int userId) {
		User userChange = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		int newAmount = user.getPoints() + pointChange;
		
		userChange.setUserName(user.getUserName());
		userChange.setPoints(newAmount);
		
		return userRepository.save(userChange);
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
	public Day updateDay(Day day, int dayId) {
		Day dayChange = dayRepository.findById(dayId).orElseThrow(() -> new ResourceNotFoundException("Day", "Id", dayId));
		
		dayChange.setDate(day.getDate());
		dayChange.setDoublePoints(day.isDoublePoints());
		
		return dayRepository.save(dayChange);
	}

	@Override
	public Category updateCategory(Category category, int categoryId) {
		Category categoryChange = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
		
		categoryChange.setName(category.getName());
		categoryChange.setValue(category.getValue());
		
		return categoryRepository.save(categoryChange);
	}

	@Override
	public Task updateTask(Task task, int taskId) {
		Task taskChange = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task", "Id", taskId));
		
		taskChange.setName(task.getName());
		taskChange.setCategory(task.getCategory());
		
		return taskRepository.save(taskChange);
	}

	@Override
	public Reward updateReward(Reward reward, int rewardId) {
		Reward rewardChange = rewardRepository.findById(rewardId).orElseThrow(() -> new ResourceNotFoundException("Reward", "Id", rewardId));
		
		rewardChange.setName(reward.getName());
		rewardChange.setCost(reward.getCost());
		
		return rewardRepository.save(rewardChange);
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
