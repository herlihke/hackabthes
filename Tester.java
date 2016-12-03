import java.awt.Graphics;
import java.awt.Graphics2D;


public class Tester {

	public static void main(String[] args) {
		GridTester myGrid = new GridTester();
		
		myGrid.setSize(800, 600);
		myGrid.setDefaultCloseOperation(myGrid.EXIT_ON_CLOSE);
		myGrid.setVisible(true);
	}

}
