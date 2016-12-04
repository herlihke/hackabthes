/* Nathan Mullaney
Date: Dec 3, 2016
Program Name: Line.java
Description: 
*/

import java.awt.Graphics;
import java.util.ArrayList;

public class Line
{
	//INSTANCE FIELDS
	String equation;
	private ArrayList<Point> allPoints;

	private int size;

	//CONSTRUCTORS
	public Line(String inputLine)
	{
		equation = inputLine; //HARDCODED CHANGE LATER
		allPoints = new ArrayList<Point>();
      
		//calls private method to remove all spaces
		trimEquation();
		
		//creates all points for graph
		createPoints();
	}
   
	//METHODS
	//RECURSION TO GET THE ANSWER
	private String findAnswer(String myEquation, double x)
	{
		
		//if there is operation, figure it out 
		if(myEquation.indexOf("x") != -1)
		{
			int positionOfX = myEquation.indexOf("x");
			String part1 = myEquation.substring(0, positionOfX);
			String part2 = myEquation.substring(positionOfX + 1);
			myEquation = part1 + x + part2;
			findAnswer(myEquation, x);
		}
		
		if(myEquation.indexOf("+") != -1)
		{
			int positionOfAdd = myEquation.indexOf("+");
			String part1 = myEquation.substring(0, positionOfAdd);
			String part2 = myEquation.substring(positionOfAdd + 1);
			myEquation = add(findAnswer(part1, x), findAnswer(part2, x));
		}
		//if there is operation, figure it out 
		else if(myEquation.indexOf("-") != -1)
		{
			int positionOfSubtract = myEquation.indexOf("-");
			String part1 = myEquation.substring(0, positionOfSubtract);
			String part2 = myEquation.substring(positionOfSubtract + 1);
			myEquation = subtract(findAnswer(part1, x), findAnswer(part2, x));
		}
		else if(myEquation.indexOf("*") != -1)
		{
			int positionOfMultiply = myEquation.indexOf("*");
		
			String part1 = myEquation.substring(0, positionOfMultiply);
			String part2 = myEquation.substring(positionOfMultiply+1);
			myEquation = multiply(findAnswer(part1, x), findAnswer(part2, x));
		}
		else if(myEquation.indexOf("/") != -1)
		{
			int positionOfDivide = myEquation.indexOf("/");
			String part1 = myEquation.substring(0, positionOfDivide);
			String part2 = myEquation.substring(positionOfDivide + 1);
			myEquation = divide(findAnswer(part1, x), findAnswer(part2, x));
		}
		else if(myEquation.indexOf("^") != -1)
		{
			int positionOfPow = myEquation.indexOf("^");
			String part1 = myEquation.substring(0, positionOfPow);
			String part2 = myEquation.substring(positionOfPow + 1);
			myEquation = power(findAnswer(part1, x), findAnswer(part2, x));
		}
		//if there are no more operations we return the answer
		return myEquation;
	}
	
	//takes the string and removes all unnecessary letts and symbols
	private void trimEquation()
	{
		String newEquation = "";
		for(int i = 0; i<equation.length(); i++)
		{
			//sees if the char is number
			if((int) (equation.charAt(i)) >=48 && equation.charAt(i)<=57)
				newEquation = newEquation + equation.charAt(i);
			//if char is +
			else if(equation.charAt(i) ==43)
				newEquation = newEquation + equation.charAt(i);
			//else if char is -
			else if(equation.charAt(i) ==45)
				newEquation = newEquation + equation.charAt(i);
			//else if char is *
			else if(equation.charAt(i) ==42)
				newEquation = newEquation + equation.charAt(i);
			//else if char is /
			else if(equation.charAt(i) ==47)
				newEquation = newEquation + equation.charAt(i);
			//else if char is ^
			else if(equation.charAt(i) ==94)
				newEquation = newEquation + equation.charAt(i);
			//else if char is .
			else if(equation.charAt(i) ==46)
				newEquation = newEquation + equation.charAt(i);
			//else if char is x or X
			else if(equation.charAt(i) == 120 || equation.charAt(i) == 88)
				newEquation = newEquation + "x";
		}
		
		equation = newEquation;
	}
	
	//self explanatory- MATH METHODS
	public String multiply(String object, String object2)
	{
		boolean notAllNumbers  = false;
		for(int i = 0; i<object.length(); i++)
		{
			if((object.charAt(i) >=48 && object.charAt(i)<=57) || object.charAt(i) == 46)
			{
				notAllNumbers = true;
			}
		}
		
		for(int i = 0; i<object2.length(); i++)
		{
			if((object2.charAt(i) >=48 && object2.charAt(i)<=57) || object2.charAt(i) == 46)
			{
				notAllNumbers = true;
			}
		}
	    
		if(notAllNumbers)
		{
			return (Double.parseDouble(object)*Double.parseDouble(object2))+"";
		
		}
		return object + object2;
	}
	
	public String divide(String object,String object2)
	{
		boolean notAllNumbers  = false;
		for(int i = 0; i<object.length(); i++)
		{
			if((object.charAt(i) >=48 && object.charAt(i)<=57) || object.charAt(i) == 46)
			{
				notAllNumbers = true;
			}
		}
		
		for(int i = 0; i<object2.length(); i++)
		{
			if((object2.charAt(i) >=48 && object2.charAt(i)<=57) || object2.charAt(i) == 46)
			{
				notAllNumbers = true;
			}
		}
	    
		if(notAllNumbers)
		{
			return (Double.parseDouble(object)/Double.parseDouble(object2))+"";
		
		}
		return object + object2;
	}
	
	public String add(String object, String object2)
	{
		boolean notAllNumbers  = false;
		for(int i = 0; i<object.length(); i++)
		{
			if((object.charAt(i) >=48 && object.charAt(i)<=57) || object.charAt(i) == 46)
			{
				notAllNumbers = true;
			}
		}
		
		for(int i = 0; i<object2.length(); i++)
		{
			if((object2.charAt(i) >=48 && object2.charAt(i)<=57) || object2.charAt(i) == 46)
			{
				notAllNumbers = true;
			}
		}
	    
		if(notAllNumbers)
		{
			
			return (Double.parseDouble(object)+Double.parseDouble(object2))+"";
		
		}
		return object + object2;
	}
	  
	public String subtract(String object, String object2)
	{
		boolean notAllNumbers  = false;
		for(int i = 0; i<object.length(); i++)
		{
			if((object.charAt(i) >=48 && object.charAt(i)<=57) || object.charAt(i) == 46)
			{
				notAllNumbers = true;
			}
		}
		
		for(int i = 0; i<object2.length(); i++)
		{
			if((object2.charAt(i) >=48 && object2.charAt(i)<=57) || object2.charAt(i) == 46)
			{
				notAllNumbers = true;
			}
		}
	    
		if(notAllNumbers)
		{
			return (Double.parseDouble(object)-Double.parseDouble(object2))+"";
		
		}
		return object + object2;
	}
	
	public String power(String object, String object2)
	{

		boolean notAllNumbers  = false;
		for(int i = 0; i<object.length(); i++)
		{
			if((object.charAt(i) >=48 && object.charAt(i)<=57) || object.charAt(i) == 46)
			{
				notAllNumbers = true;
			}
		}
		
		for(int i = 0; i<object2.length(); i++)
		{
			if((object2.charAt(i) >=48 && object2.charAt(i)<=57) || object2.charAt(i) == 46)
			{
				notAllNumbers = true;
			}
		}
	    
		if(notAllNumbers)
		{
			return (Math.pow(Double.parseDouble(object), Double.parseDouble(object2))+"");
		
		}
		return object + object2;
	}
	
	public void createPoints()
	{
		for(double i = 0.0; i<=10; i+=0.01 )
		{			
		  Point myPoint = new Point(i, Double.parseDouble(findAnswer(equation, i)));
		  allPoints.add(myPoint);
		}
	}
	
	//GRAPHICS METHODS- CREATE AND SHOW ALL POINTS
	public void renderEachPoint(Graphics g, int x, int y)
	{
	   for(Point p : allPoints)
	   {
	      p.renderPoint(g, x, y);
	   }
	}
   
   //OTHER NUMERICAL METHODS
   public double getMaxYint()
   {
      double max;
      max = allPoints.get(0).getPointY();
      //max = points.getPointY(0);
      
      for(int i = 1; i<allPoints.size(); i++)
      {
         if(allPoints.get(i).getPointY() > max)
            max = allPoints.get(i).getPointY();
      }
      return max;
      
   }
   
   public double getMinY()
   {
      double min;
      min = allPoints.get(0).getPointY();
      
      for(int i = 1; i<allPoints.size(); i++)
      {
         if(allPoints.get(i).getPointY() < min)
            min = allPoints.get(i).getPointY();
      } 
      return min;
   }
   
   public int getSize()
   {
   	return allPoints.size();
   }
   
   public Point getPointAt(int i)
   {
   	return allPoints.get(i);
   }
}
