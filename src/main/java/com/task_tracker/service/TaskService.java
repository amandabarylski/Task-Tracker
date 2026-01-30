package com.task_tracker.service;

import com.task_tracker.entity.Category;
import com.task_tracker.entity.Day;
import com.task_tracker.entity.Reward;
import com.task_tracker.entity.Shop;
import com.task_tracker.entity.Task;
import com.task_tracker.entity.User;

public interface TaskService {
	
	//Get methods
	//There are no get all methods as everything is tied to a specific user.
	
	//I commented out the lists as I could access these lists through the parent objects.
	
	public User getUserById(int userId);
	
	public Day getDayById(int dayId);
	
//	public List<Day> getUserDays(int userId);
	
	public Task getTaskById(int taskId);
	
//	public List<Task> getDayTasks(int dayId);
//	
//	public List<Category> getUserCategories(int userId);
	
	public Shop getShopById(int shopId);
	
//	public List<Reward> getUserRewards(int userId);
	
	
	//Post methods
	
	//Part of adding a user will be adding a shop, so I didn't create a separate method.
	public User addUser(User user);
	
	public Day addDay(Day day);
	
	public Category addCategory(Category category);
	
	public Task addTask(Task task);
	
	public Reward addReward(Reward reward);
	
	
	//Put methods
	//I wanted flexibility to fix any typos or change names or point amounts, 
	//so every entity besides shop (which has nothing to edit) got a put method.
	
	public User updateUser(User user, int userId);
	
	public Day updateDay(Day day, int dayId);
	
	public Category updateCategory(Category category, int categoryId);
	
	public Task updateTask(Task task, int taskId);
	
	public Reward updateReward(Reward reward, int rewardId);
	
	
	//Delete methods
	//Most of the entities don't make sense to have delete methods as well as put methods.
	
	public void deleteUser (int userId);
	
	public void deleteReward(int rewardId);

}
