/** 
File name: MyBMIAdmin.java
Author: Nguyen Quang Trung
Student number: c3198416
Course: SENG3400 Network & Distributed Computing | Assignment 2
Date Created: September 25, 2016
Last Changed: October 06, 2016
Description: This file contains the MyBMIAdmin class for the 2nd Web Service that presents API for service admin.
*/ 

public class MyBMIAdmin
{
	//Hard code admin id and password
	private static String userName = "admin",
	                      password = "bodymass";
						  
	//Creat an instance of class MyBMIStorage for accessing ranges and calls count					  
	private MyBMIStorage Storage = new MyBMIStorage();
						  
	//boolean method to add new range					  
	public boolean addRange(String user, String pwd, String lower, 
	                        String upper, String name, boolean normal)
	{
		//Validate user credentials, range overlaps, lower and upper values, normal range exists
		if(!user.equals(userName) || !pwd.equals(password) || Storage.nameExist(name) 
			|| lower.equals("*") && upper.equals("*") || Storage.rangeOverLap(lower,upper)
		    || normal && Storage.normalExist())
			return false;
		else
		{
			//If valid, add new range
			Storage.addRange(lower,upper,name,normal);
			return true;
		}
			
	}
	
	//boolean method to delete existing range
	public boolean deleteRange(String user, String pwd, String name)
	{
		//Validate user credentials, if range exists
		if(!user.equals(userName) || !pwd.equals(password) || !Storage.nameExist(name))
			return false;
		else
		{
			Storage.deleteRange(name);
			return true;
		}
			
	}
	
	//boolean method to change range name
	public boolean setName(String user, String pwd, 
	                       String oldName, String newName)
	{
		//Validate users credentials and if range exists
		if(!user.equals(userName) || !pwd.equals(password) || !Storage.nameExist(oldName))
			return false;
		else
		{
			Storage.updateName(oldName,newName);
			return true;
		}
			
	}
	
	//int method to return users calls count
	public int callCount(String user, String pwd)
	{
		//Validate user credentials
		if(!user.equals(userName) || !pwd.equals(password))
			return -1;
		else
			return Storage.getcallCount();
	}
	
	//void method to update users calls count
	public void addCallCount()
	{
		Storage.updateCallCount();
	}
}






