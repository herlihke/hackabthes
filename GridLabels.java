import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class GridLabels {
	//INSTANCE FIELDS
	int xCoord, yCoord;
	String label;
	
	//CONSTRUCTORS
	public GridLabels(String inputLabel, int x, int y)
	{
		label = inputLabel;
		xCoord = x; 
		yCoord = y;
	}
	
	//METHODS
	public void render(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(new Font(label, 9, 9));
		g2.drawString(label, xCoord+3, yCoord-2);;
	}
}
