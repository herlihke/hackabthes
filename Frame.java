import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Frame extends JFrame 
{
	//tyler's grid
	Grid myGrid = new Grid();
	
	//Title page
	ImageIcon titler = new ImageIcon("/Users/herlihke/Documents/workspace/HackathonGraph/src/FinalHackathonTitle.jpg");
	
	//counter
	int counter = 0;
	
	public void paint(Graphics g)
	{
		//necessary paint methods
		super.paintComponents(g);
      Graphics2D g2 = (Graphics2D) g;
      
      
      if(counter == 0)
      {
      	titler.paintIcon(this, g2, 0, 0);
      	
      }
      
      
      
      
      //g2.drawString("Graphr", 200, 100);
		if(counter == 2)
		{
			this.add(myGrid);
		   myGrid.render(g);
		}
		counter++;
		
	}
}