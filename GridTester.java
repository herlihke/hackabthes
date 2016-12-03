
import java.awt.Graphics;

import javax.swing.JFrame;


public class GridTester extends JFrame{
	Grid myGrid = new Grid();
	
	public void paint(Graphics g)
	{

		this.add(myGrid);
		myGrid.render(g);
	}
}
