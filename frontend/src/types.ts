export interface User {
	userId: number,
	userName: string,
	points: number,
	days: Day[],
	createdCategories: Category[],
	rewards: Reward[]
}

export interface Reward {
	rewardId: number,
	name: string,
	cost: number,
	user: User
}

export interface Category {
	categoryId: number,
	name: string,
	value: number,
	user: User,
	tasks: Task[]
}

export interface Day {
	dayId: number,
	date: Date,
	doublePoints: boolean,
	user: User,
	tasks: Task[],
}

export interface Task {
	taskId: number,
	name: string,
	day: Day,
	category: Category
}