import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author Pavlyk.B
 * @version 1.0
 */
public class Field extends JPanel
{

		private Image hat;
		private Image background;
		public int hatCoord = 380;
				
		/** Class  Constructor */
		public Field()
		{
                  
			try
			{
				hat = ImageIO.read(new File("c:\\img\\shapka.png"));
			}
			catch(IOException ex){}
				
			try
			{
				background = ImageIO.read(new File("c:\\img\\fon.png"));
			}
			catch(IOException ex){}
				
			/**
			 * Create a timer that will redraw the playing field
			 * 20 times a second
			 */
			 Timer timerDraw = new Timer(50, new ActionListener(){
				 public void actionPerformed(ActionEvent ae){
					 repaint();
				 }
			 });				 
		
                         timerDraw.start();
		}
		
		/** 
		* The method which renders graphical objects on the panel
		* @param gr 
		*/        
		@Override

		public void paintComponent(Graphics gr)
		{
			super.paintComponent(gr);
			gr.drawImage(background, 0, 0, null);
			gr.drawImage(hat, hatCoord, 500, null);       
		}
		
}
