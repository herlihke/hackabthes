import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
/*
Name: Kevin Herlihy
Date: Dec 3, 2016
Program Name: Point.java
Description:
*/

public class Point
{
	private double x;
	private double y;
	public static final int radius = 1; //sets radius
	
	public Point(double xCoord, double yCoord) //creates point
	{
		x = xCoord;
		y = yCoord;
		
	}
	
	public double getPointX() //returns x
	{
		return x;
	}
	
	public double getPointY() //returns y
	{
		return y;
	}
	
	public int getRadius() //returns radius
	{
		return radius;
	}

	public void renderPoint(Graphics g) //draws point on the grid
	{
		//super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      
      ///***REMEMBER TO FIX X & Y***///
		g2.drawOval((int)x, (int)y, radius, radius); //convert x & y coords to ints in order to draw circle
	}
	
}
