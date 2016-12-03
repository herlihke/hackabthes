import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JComponent;


public class Grid extends JComponent{
	//INSTANCE FIELDS
	private int frameMinX, frameMaxX, frameMinY, frameMaxY;
	private int smallestX, smallestY, largestX, largestY; 
	
	private Rectangle xAxis, yAxis;
	
	private Line2D[] xGridLines, yGridLines;
	private int numOfGridLinesX, numOfGridLinesY;
	
	private boolean showGridLines; //if the x and y grid lines should appear

	//CONSTRUCTORS
	//default constructors
	public Grid()
	{
		frameMinX = 0;
		frameMaxX = 800; //GOING TO BE GET WIDTH
		frameMinY = 22; //HEIGHT OF TOP BAR
		frameMaxY = 600; //GOING TO BE GET HEIGHT
		smallestX = -10; //KEEP HARDCODED THIS IS IF FUNCTION IS NOT INPUTTED
		largestX = 10;//KEEP HARDCODED THIS IS IF FUNCTION IS NOT INPUTTED
		smallestY = -10;//KEEP HARDCODED THIS IS IF FUNCTION IS NOT INPUTTED
		largestY = 10;//KEEP HARDCODED THIS IS IF FUNCTION IS NOT INPUTTED
		
		//sets number of grid lines of each coord
		numOfGridLinesX = 10; //HARDCODED MAY WANT TO CHANGE
		numOfGridLinesY = 10;//HARDCODED MAY WANT TO CHANGE
		
		//initializes array of the number of lines we want 
		xGridLines = new Line2D[numOfGridLinesX];
		yGridLines = new Line2D[numOfGridLinesY];
		createXGridLines();
		createYGridLines();
		
		showGridLines = true; //HARDCODED
	}
	
	//constructor with inputs
	public Grid(int miX, int maX, int miY, int maY, int smX, int laX, int smY, int laY)
	{
		frameMinX = miX;
		frameMaxX = maX;
		frameMinY = miY;
		frameMaxY = maY;
		smallestX = smX;
		largestX = laX;
		smallestY = smY;
		largestY = laY;
		
		//sets number of grid lines of each coord
		numOfGridLinesX = 10; //HARDCODED MAY WANT TO CHANGE
		numOfGridLinesY = 10;//HARDCODED MAY WANT TO CHANGE
		
		//initializes array of the number of lines we want 
		xGridLines = new Line2D[numOfGridLinesX];
		yGridLines = new Line2D[numOfGridLinesY];
		createXGridLines();
		createYGridLines();
		
		showGridLines = true; //HARDCODED
	}
	
	//METHODS
	//chnages the coordinates of the point to a point on the jframe
	public int changePointXToJframeX(double pointX)
	{
		//gets the spread between the max and the min of both frame and function
		int frameSpreadX = frameMaxX-frameMinX;
		int functionSpreadX = largestX - smallestX;
		
		//gets what each unit of the grid should be
		int unitX = frameSpreadX / functionSpreadX;
		
		int xCoord = (int) ((pointX - smallestX) * unitX);
		
		return xCoord;
	}
	
	public int changePointYToJframeY(double pointY)
	{
		//gets the spread between the max and the min of both frame and function
		int frameSpreadY = frameMaxY-frameMinY;
		int functionSpreadY = largestY - smallestY;
		
		//gets what each unit of the grid should be
		int unitY = frameSpreadY / functionSpreadY;
		
		int YCoord = (int) ((pointY - smallestY) * unitY);
		
		return YCoord;
	}
	
	//method fills array with lines that are the coordinate plane
	private void createXGridLines()
	{
		//gets the spread between the max and the min of both frame and function
		int frameSpreadX = frameMaxX-frameMinX;
		
		//gets how far apart the grid lines are apart in units
		int lineSpreadX = frameSpreadX / numOfGridLinesX;
		
		for(int i=0; i<numOfGridLinesX; i++)
		{
			//creates a new line, adds it to array, witht the coordinates of each of the grid lines
			int xCoord = lineSpreadX*(i+1);
			//x coords same, y spans the min to the max of the grid
			xGridLines[i] = new Line2D.Double(xCoord, frameMinY, xCoord, frameMaxY);
		}
	}
	
	//method fills array with lines that are the coordinate plane
	private void createYGridLines()
	{
		//gets the spread between the max and the min of both frame and function
		int frameSpreadY = frameMaxY-frameMinY;
		
		//gets how far apart the grid lines are apart in units
		int lineSpreadY = frameSpreadY / numOfGridLinesY;
		
		for(int i=0; i<numOfGridLinesY; i++)
		{
			//creates a new line, adds it to array, witht the coordinates of each of the grid lines
			int yCoord = lineSpreadY*(i+1);
			//y coords same, x spans the min to the max of the grid
			yGridLines[i] = new Line2D.Double(frameMinX, yCoord, frameMaxX, yCoord);
		}
	}
	
	public void render(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		//if the user wants to show grid lines render them
		if(showGridLines)
		{
			//go through all x and y grid lines and print them
			for(Line2D lx :xGridLines)
			{
				g2.draw(lx);
			}
			
			//go through all x and y grid lines and print them
			for(Line2D ly :yGridLines)
			{
				g2.draw(ly);
			}
		}
		
	}
}
