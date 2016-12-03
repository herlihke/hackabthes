import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
Name: Kevin Herlihy
Date: Dec 3, 2016
Program Name: GrapherTester.java
Description:
*/

public class GrapherTester 
{
	private static String equation = "";
	
	public static void main(String[] args) 
	{
		
		JButton showDialogButton = new JButton("Get Started"); //makes the Button
		
		Frame framer = new Frame(); //makes new JFrame
		
		framer.getContentPane().setLayout(new FlowLayout()); //put button on frame
	   framer.add(showDialogButton);
		framer.setSize(900, 600);
		framer.setDefaultCloseOperation(framer.EXIT_ON_CLOSE);
		//framer.pack();
		framer.setLocationRelativeTo(null);
		framer.repaint();
		framer.setVisible(true);
		
		showDialogButton.addActionListener(new ActionListener() //implements the actionListenr for the button 
		{
	      public void actionPerformed(ActionEvent e)
	      {
	        // display/center the jdialog when the button is pressed
	        //JDialog d = new JDialog(framer, "Get Started", true);
	        //d.setLocation(400, 400);
	        //d.setLocationRelativeTo(framer);
	        //d.setVisible(true);
	        
	        framer.removeAll();
	        framer.repaint();
	        framer.remove(showDialogButton);
	        
	      }
	    });
		
		
		//Not used for anything
		JFrame tyler = new JFrame();
		tyler.setSize(800, 600);
		
		//makes the icon that says "y=" in the popup
		ImageIcon yEquals = new ImageIcon("/Users/herlihke/Documents/workspace/HackathonGraph/src/Hackathon y= .png");
		
		//pops up a window for the user to input an equation, then saves it to an instance field
		equation = (String)JOptionPane.showInputDialog(null, "Please input your equation:", "title", 
				JOptionPane.INFORMATION_MESSAGE,yEquals,null, null); 
		
		
		
		
		
			}
}
