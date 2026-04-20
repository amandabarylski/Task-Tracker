import { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import { User, Reward, Category, Day, Task } from './types';

function App() {
	
	//I made a general purpose loading state to use later.
	const[loading, setLoading] = useState<boolean>(false);
	
	//I wanted both a "logged out" screen and a "logged in" one, which required the currentUser to be nullable.
	//This is the primary piece of state used in this component, with other ones dependant on the user.
	const[currentUser, setCurrentUser] = useState<User | null>();
	
	//It seems unneccessary to have a separate login function that simply calls the fetch function,
	//so I commented it out and left the more traditionally named fetch function in place.
/*	const login = (userId: number) => {
		fetchUserById(userId);
	}*/
	
	const logout = () => {
		setCurrentUser(null);
	}
	
	const fetchUserById = async (userId: number) => {
		setLoading(true);
		try {
			const response = await fetch(`/task-tracker/user/${userId}`);
			if (!response.ok) {
				throw new Error(`Could not find user with id of ${userId}`);
			}
			const data = await response.json();
			setCurrentUser(data);
		} catch (error) {
			console.log('Error: ', error);
		}
		setLoading(false)
	}
	
  return (
    <>
      {loading ? (
		<div class="loading-wheel"></div>
	  ) : (
		<>
			{currentUser == null ? (
				<></>
			) : (
				<></>
			)}
		</>)}
    </>
  );
}

export default App;
