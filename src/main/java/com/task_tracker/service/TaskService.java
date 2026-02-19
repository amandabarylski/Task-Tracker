package com.task_tracker.service;

import com.task_tracker.controller.model.CategoryModel;
import com.task_tracker.controller.model.DayModel;
import com.task_tracker.controller.model.RewardModel;
import com.task_tracker.controller.model.TaskModel;
import com.task_tracker.entity.Category;
import com.task_tracker.entity.Day;
import com.task_tracker.entity.Reward;
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
	
	//When fixing my other methods I needed the ability to get individual categories and rewards, so I added the get methods for them.
	public Category getCategoryById(int categoryId);
	
	public Reward getRewardById(int rewardId);
	
//	public List<Task> getDayTasks(int dayId);
//	
//	public List<Category> getUserCategories(int userId);
	
//	public Shop getShopById(int shopId);
	
//	public List<Reward> getUserRewards(int userId);
	
	
	//Post methods
	
	//Part of adding a user will be adding a shop, so I didn't create a separate method.
	//In the end, I removed shop entirely as it was redundant.
	public User addUser(User user);
	
	//After adding the models, I had to go back through and update the post and put methods to utilize them.
	//I decided to go one at a time as I had to update the implementation and controller as well.
	public Day addDay(DayModel dayModel);
	
	public Category addCategory(CategoryModel categoryModel);
	
	public Task addTask(TaskModel taskModel);
	
	public Reward addReward(RewardModel rewardModel);
	
	
	//Put methods
	//I wanted flexibility to fix any typos or change names or point amounts, 
	//so every entity besides shop (which has nothing to edit) got at least one put method.
	
	//I used two separate put methods for User as point changes will happen at different times than the user changing their name.
	//As other entities don't have that distinction I simply used a general put method for them.
	//Unfortunately, I was unable to use PutMapping to the same place twice, even with different parameters, and had to combine them.
	//I later changed it from requiring a user to requiring a user name.
	public User updateUser(String userName, int pointChange, int userId);
	
	public Day updateDay(DayModel dayModel, int dayId);
	
	public Category updateCategory(CategoryModel categoryModel, int categoryId);
	
	public Task updateTask(TaskModel taskModel, int taskId);
	
	public Reward updateReward(RewardModel rewardModel, int rewardId);
	
	
	//Delete methods
	//Most of the entities don't make sense to have delete methods as well as put methods.
	
	public void deleteUser (int userId);
	
	public void deleteReward(int rewardId);

}
