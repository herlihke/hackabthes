import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JComponent;


public class Grid extends JComponent{
	//INSTANCE FIELDS
	private int frameMinX, frameMaxX, frameMinY, frameMaxY; //coordinates of the frame
	
	private int smallestX, smallestY, largestX, largestY; //function maxs and mins
	
	private final int lineThickness = 3;
	

	private Rectangle xAxis, yAxis;
	private ArrayList <Line2D> horizantalGridLines, verticalGridLines;
	private final int gridLineSpacingX = 40, gridLineSpacingY = 40;//how much space is in between each grid line
	private double xSpacing, ySpacing;
	private boolean showGridLines; //if the x and y grid lines should appear
	
	private ArrayList<GridLabels> xAxisLabels, yAxisLabels;
	
	private Line line;

	//CONSTRUCTORS
	//default constructors
	public Grid(String inputEquation)
	{
		frameMinX = 0;
		frameMaxX = 800; //GOING TO BE GET WIDTH
		frameMinY = 0; //HEIGHT OF TOP BAR
		frameMaxY = 600; //GOING TO BE GET HEIGHT
		
		smallestX = 0; //KEEP HARDCODED THIS IS IF FUNCTION IS NOT INPUTTED
		largestX = 10;//KEEP HARDCODED THIS IS IF FUNCTION IS NOT INPUTTED
		smallestY = -10;//KEEP HARDCODED THIS IS IF FUNCTION IS NOT INPUTTED
		largestY = 10;//KEEP HARDCODED THIS IS IF FUNCTION IS NOT INPUTTED
		
		xSpacing = gridLineSpacingX/(largestX-smallestX);
		ySpacing = gridLineSpacingY/(largestY-smallestY);
		
		//sets spacing between each grid line in pixels
		horizantalGridLines = new ArrayList<Line2D>();
		verticalGridLines = new ArrayList<Line2D>();
		xAxisLabels = new ArrayList<GridLabels>();
		yAxisLabels = new ArrayList<GridLabels>();
		createHorizantalGridLines();
		createVerticalGridLines();
		createAxes();
		
		showGridLines = true; //HARDCODED
		
		line = new Line(inputEquation);
		
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
		
		xSpacing = gridLineSpacingX/(largestX-smallestX);
		ySpacing = gridLineSpacingY/(largestY-smallestY);
		
		//sets spacing between each grid line in pixels
		horizantalGridLines = new ArrayList<Line2D>();
		verticalGridLines = new ArrayList<Line2D>();
		xAxisLabels = new ArrayList<GridLabels>();
		yAxisLabels = new ArrayList<GridLabels>();
		createHorizantalGridLines();
		createVerticalGridLines();
		createAxes();
		
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
		
		//you need to flip y coordinates so subtract framemaxy from it
		int YCoord = (int) (frameMaxY-(pointY - smallestY) * unitY);
		
		return YCoord;
	}
	
	private void createAxes()
	{
		//find coordinate on graph that equals 0 for x and 0 for y
		//calls method on itself
		int xInt = changePointYToJframeY(0);
		int yInt = changePointXToJframeX(0);
		
		xAxis = new Rectangle(frameMinX, xInt, frameMaxX-frameMinX, lineThickness);
		yAxis = new Rectangle(yInt, frameMinY, lineThickness, frameMaxY-frameMinX);
		System.out.println(xInt + " " + yInt);
	}
	
	//method fills array with lines that are the coordinate plane
	private void createHorizantalGridLines()
	{
		//gets x axis aka y=0
		int yZero = changePointYToJframeY(0);
		
		//this part gets the lines below the axis
		int i = -1;
		//while the line of the soon to be made grid is still on jframe
		while(yZero-(i*gridLineSpacingY) < frameMaxY)
		{
			
			//creates grid line
			Line2D nextLine = new Line2D.Double(frameMinX, yZero-(i*gridLineSpacingY), frameMaxX, yZero-(i*gridLineSpacingY));
			horizantalGridLines.add(nextLine);
			
			//creates labels
			yAxisLabels.add(
					new GridLabels(xSpacing*i +"", 
							changePointXToJframeX(0), yZero-(i*gridLineSpacingY)));
			
			//increment
			i--;
		}
		
		//this part gets the lines above the axis
		i = 1;
		while(yZero-(i*gridLineSpacingY) > frameMinY)
		{
			//creates grid line
			Line2D nextLine = new Line2D.Double(frameMinX, yZero-(i*gridLineSpacingY), frameMaxX, yZero-(i*gridLineSpacingY));
			horizantalGridLines.add(nextLine);
			
			//create labels
			yAxisLabels.add(
					new GridLabels(xSpacing*i +"",
							changePointXToJframeX(0), yZero-(i*gridLineSpacingY)));
			
			//increment
			i++;
		}
	}
	
	//method fills array with lines that are the coordinate plane
	private void createVerticalGridLines()
	{
		//get y axis aka x= 0
		int xZero = changePointXToJframeX(0);
		
		//this part gets the lines left the axis
		int i = 1;
		//while the line of the soon to be made grid is still on jframe
		while(xZero-(i*gridLineSpacingX) > frameMinX)
		{
			//creates the grid line
			Line2D nextLine = new Line2D.Double(xZero-(i*gridLineSpacingX), frameMinY, xZero-(i*gridLineSpacingX), frameMaxY);
			horizantalGridLines.add(nextLine);
			
			//create labels
			xAxisLabels.add(
					new GridLabels(ySpacing*-i +"", 
							xZero-(i*gridLineSpacingY), changePointYToJframeY(0)));
			
			//increment
			i++;
		}
		
		//this part gets the lines right the axis
		i = -1;
		//while the line of the soon to be made grid is still on jframe
		while(xZero-(i*gridLineSpacingX) < frameMaxX)
		{
			
			//creates grid line
			Line2D nextLine = new Line2D.Double(xZero-(i*gridLineSpacingX), frameMinY, xZero-(i*gridLineSpacingX), frameMaxY);
			horizantalGridLines.add(nextLine);
			
			//create labels
			xAxisLabels.add(
					new GridLabels(ySpacing*-i +"", 
							xZero-(i*gridLineSpacingY), changePointYToJframeY(0)));
			
			//increment
			i--;
		}
	}
	
	public void render(Graphics g)
	{
		//graphics object
		Graphics2D g2 = (Graphics2D) g;
		
		//if the user wants to show grid lines render them
		if(showGridLines)
		{
			//go through all x and y grid lines and print them
			for(Line2D lx :horizantalGridLines)
			{
				g2.draw(lx);
			}
			
			//go through all x and y grid lines and print them
			for(Line2D ly :verticalGridLines)
			{
				g2.draw(ly);
			}
		}
		
		//fill axes
		g2.fill(xAxis);
		g2.fill(yAxis);
		
		//show all axis labels
		for(GridLabels l: xAxisLabels)
		{
			l.render(g2);
		}
		
		for(GridLabels l: yAxisLabels)
		{
			l.render(g2);
		}
		
		for(int i = 0; i<line.getSize(); i++)
		{
			Point p = line.getPointAt(i);
			p.renderPoint(g2, this.changePointXToJframeX(p.getPointX()), this.changePointYToJframeY(p.getPointY()));
		}
		
	}
}

