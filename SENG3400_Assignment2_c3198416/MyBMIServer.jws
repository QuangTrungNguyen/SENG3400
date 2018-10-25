/** 
File name: MyBMIServer.java
Author: Nguyen Quang Trung
Student number: c3198416
Course: SENG3400 Network & Distributed Computing | Assignment 2
Date Created: September 25, 2016
Last Changed: October 06, 2016
Description: This file contains MyBMIServer class for the 1st Web Service that presents API for service's users.
*/ 

import java.lang.*;

public class MyBMIServer
{
	//Creat an instance of class MyBMIStorage for accessing BMI ranges
	private MyBMIStorage Storage = new MyBMIStorage();
	
	//String method to calculate BMI based on weight and height
	public String calcBMI(String weight, String height)
	{
		String result;
		double BMI = Double.parseDouble(weight) / Math.pow((Double.parseDouble(height)/100),2);
		result = "Your BMI is " + String.format("%.2f", BMI) + " " + Storage.findRangeName(BMI); //
		return result;
	}
	
	//String method to list all ranges
	public String listRanges()
	{
		return Storage.showRange();
	}
	
	//String method to list ideal weights range for normal BMI range
	public String listWeights(String height)
	{
		double weightMax, 
		       weightMin;
		if(Storage.getNormalRange().length == 1)
			return "UNDEFINED";
		else
		{
			double[] range = Storage.getNormalRange(); //get lower and upper values of normal range
			//Calculate minimum and maximum weights
			weightMax = range[1] * Math.pow((Double.parseDouble(height)/100),2);  
			weightMin = range[0] * Math.pow((Double.parseDouble(height)/100),2);
			return "Ideal weight is " + String.format("%.2f", weightMin) + " - " + String.format("%.2f", weightMax) + " kg.";
		}
	}

}