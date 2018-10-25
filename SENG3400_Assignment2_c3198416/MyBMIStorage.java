/** 
File name: MyBMIStorage.java
Author: Nguyen Quang Trung
Student number: c3198416
Course: SENG3400 Network & Distributed Computing | Assignment 2
Date Created: September 25, 2016
Last Changed: October 06, 2016
Description: This file contains the MYBMIStorage class which stores BMI ranges and users calls count.
*/ 

import java.lang.*;
import java.io.*;
import java.util.*;

public class MyBMIStorage
{
	//Declare variables
	private static int callCount = 0;   //store users calls count
	private static double rangeMin,     //min value of all range lowers
	                      rangeMax;     //max value of all range uppers
	private static String normalName = "";  //name of desirable (normal) range
		
	private static ArrayList rangeName = new ArrayList();    //ArrayList to store range names
	private static ArrayList<Double> rangeLower = new ArrayList<Double>(),      //range lowers
	                                 rangeUpper = new ArrayList<Double>();      //range uppers				
	
	//void method to add name, range lowers and uppers to pre-defined arrayLists
	public void addRange(String lower, String upper, String name, boolean normal)
	{	
	    double doubleLower = -1,
		       doubleUpper = -1;
	    //unlimited lower range = 0
		if(lower.equals("*"))
		{
			doubleLower = 0;
			doubleUpper = Double.parseDouble(upper);
		}	
		//unlimited upper range = + infinity
		else if(upper.equals("*"))
		{
			doubleLower = Double.parseDouble(lower);
			doubleUpper = Double.POSITIVE_INFINITY;
		}		
		else
		{
			doubleLower = Double.parseDouble(lower);
			doubleUpper = Double.parseDouble(upper);
		}
		rangeName.add(name);
		rangeLower.add(doubleLower);
		rangeUpper.add(doubleUpper);
		//After a new range is added, find the min and max values
		findRangeLimits();	
		//Get the normal range name if applicable
		if(normal)
			normalName = name;
	}
	
	//void method to find min and max values of all range lowers, uppers
	public void findRangeLimits()
	{		
		if(rangeLower.size() > 0)
		{
			rangeMin = rangeLower.get(0);
		    rangeMax = rangeUpper.get(0);
		    for(int i = 0; i < rangeLower.size(); i++) 
		    {
			    if(rangeLower.get(i) < rangeMin) 
				    rangeMin = rangeLower.get(i);
			    if(rangeUpper.get(i) > rangeMax) 
				    rangeMax = rangeUpper.get(i);
            }
		}
	}
	
	//void method to delete existing range
	public void deleteRange(String name)
	{
		int index = rangeName.indexOf(name);
		rangeName.remove(name);
		rangeLower.remove(index);
		rangeUpper.remove(index);
		//If normal range is deleted, normal name is reset
		if(normalName.equals(name))
		{
			normalName = "";
		}
	}
	
	//void method to change a range name
	public void updateName(String oldName, String newName)
	{
		int index = rangeName.indexOf(oldName);
		rangeName.set(index,newName);
		//If it's normal range name, get the new name
		if(normalName.equals(oldName))
		{
			normalName = newName;
		}
	}
	
	//void method to update users calls count
	public void updateCallCount()
	{
		callCount++;
	}
	
	//void method to access users calls count
	public int getcallCount()
	{
		return callCount;
	}
	
	//boolean method to check if normal range exists by searching for normal name
	public boolean normalExist()
	{
		if(rangeName.contains(normalName))
			return true;
		else
			return false;
	}
	
	//boolean method to check if name exists
	public boolean nameExist(String name)
	{
		if(rangeName.contains(name))
			return true;
		else
			return false;
	}
	
	//boolean method to check if new range is overlapped with existing ranges
	public boolean rangeOverLap(String lower, String upper)
	{
		boolean overLap = false;
		findRangeLimits();
		//unlimited lower overlap
		if(lower.equals("*"))
		{
			if(rangeLower.size() > 0 && Double.parseDouble(upper) > rangeMin)
			overLap = true;
		}
		//unlimited upper overlap
		else if(upper.equals("*"))
		{
			if(rangeUpper.size() > 0 && Double.parseDouble(lower) < rangeMax)
			overLap = true;
		}
		//other overlaps
        else if(rangeLower.size() > 0 && !lower.equals("*") && !upper.equals("*"))
		{
			for(int i = 0; i < rangeLower.size(); i++) 
		    {
				if(rangeLower.get(i) <= Double.parseDouble(lower) && Double.parseDouble(lower) < rangeUpper.get(i) 
		        || rangeLower.get(i) < Double.parseDouble(upper) && Double.parseDouble(upper) <= rangeUpper.get(i))  
				    overLap = true;
		    }
		}					
		return overLap;	
	}
	
	//void method to sort ranges by values in ascending order
	public void sortRange()
	{
		double tempLower,
		       tempUpper;
		String tempName;
		for(int i = 0; i < rangeLower.size()-1; i++)
		{
			for(int j = 0; j < rangeLower.size()-1; j++)
			{
				if(rangeLower.get(i) > rangeLower.get(j+1))
				{
					//Re-arrange range lowers
					tempLower = rangeLower.get(j+1);
					rangeLower.set(j+1,rangeLower.get(i));
					rangeLower.set(i,tempLower);
					//Re-arrange range uppers
					tempUpper = rangeUpper.get(j+1);
					rangeUpper.set(j+1,rangeUpper.get(i));
					rangeUpper.set(i,tempUpper);
					//Re-arrange range name
					tempName = rangeName.get(j+1).toString();
					rangeName.set(j+1,rangeName.get(i));
					rangeName.set(i,tempName);
				}
			}
		}		
	}
	
	//String method to display all ranges
	public String showRange()
	{
		if(rangeLower.size() > 1)
			sortRange();
		String lowerLimit = "",
		       upperLimit = "",
			   middleRange = "";
		//if no range found
		if(rangeLower.size() == 0)
		{
			return "UNDEFINED";
		}
		else 
		{
			for(int i = 0; i < rangeLower.size(); i++)
			{
				//get String of lowest unlimited lower range
				if(rangeLower.get(i) == 0)
					lowerLimit = rangeName.get(i).toString().toUpperCase() + " " + "(<" + String.format("%.2f", rangeUpper.get(i)) + ")" + "\n";
				//get String of highest unlimited upper range
				else if(rangeUpper.get(i) == Double.POSITIVE_INFINITY)
					upperLimit = rangeName.get(i).toString().toUpperCase() + " " + "(>" + String.format("%.2f", rangeLower.get(i)) + ")";
				//get String of all other ranges
				else
					middleRange = middleRange + rangeName.get(i).toString().toUpperCase() + " " + "(" 
				  + String.format("%.2f", rangeLower.get(i)) + " - " + String.format("%.2f", rangeUpper.get(i)) + ")" + "\n";
			}
		}
		return lowerLimit + middleRange + upperLimit;
	}
	
	//boolean method to get lower and upper values of normal range
	public double[] getNormalRange()
	{
		double[] normalNo = {0},
		         normalYes = {0,0};
		//if no normal range found
		if(!rangeName.contains(normalName))
			return normalNo;
		else
		{
			for(int i = 0; i < rangeLower.size(); i++)
		    {
			    if(rangeName.get(i).toString().equals(normalName))
			    {
					//Get lower and upper values
				    normalYes[0] = rangeLower.get(i);
				    normalYes[1] = rangeUpper.get(i);
			    }			
		    }
			return normalYes;
		}
	}
	
	//String method to get range name for a BMI value
	public String findRangeName(double BMI)
	{
		if(rangeLower.size() == 0)
			return "UNDEFINED";
		else
		{
			int index = -1;
			for(int i = 0; i < rangeLower.size(); i++)
			{
				if(rangeLower.get(i) <= BMI && BMI <= rangeUpper.get(i))
					index = i;
			}
			if(index == -1)
				return "UNDEFINED";
			else 
				return rangeName.get(index).toString();
		}			
	}
}