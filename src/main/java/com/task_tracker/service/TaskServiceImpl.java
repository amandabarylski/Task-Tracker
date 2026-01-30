package com.task_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.task_tracker.entity.Category;
import com.task_tracker.entity.Day;
import com.task_tracker.entity.Reward;
import com.task_tracker.entity.Shop;
import com.task_tracker.entity.Task;
import com.task_tracker.entity.User;
import com.task_tracker.repository.CategoryRepository;
import com.task_tracker.repository.DayRepository;
import com.task_tracker.repository.RewardRepository;
import com.task_tracker.repository.ShopRepository;
import com.task_tracker.repository.TaskRepository;
import com.task_tracker.repository.UserRepository;

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
	ShopRepository shopRepository;
	
	@Autowired
	RewardRepository rewardRepository;
	
	
	//Get methods
	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Day getDayById(int dayId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task getTaskById(int taskId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop getShopById(int shopId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//Post methods
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Day addDay(Day day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task addTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reward addReward(Reward reward) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//Put methods
	@Override
	public User updateUser(User user, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Day updateDay(Day day, int dayId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category updateCategory(Category category, int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task updateTask(Task task, int taskId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reward updateReward(Reward reward, int rewardId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//Delete methods
	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReward(int rewardId) {
		// TODO Auto-generated method stub
		
	}

}
