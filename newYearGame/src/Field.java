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
                private int difficulty;
                private Gift[] gameGift; //Array of gifts.
                private Image endGameImage; //The image of the game ending.
                public Timer timerUpdate, timerDraw; //Timers.
				
		/** Class  Constructor */
		public Field(int difficulty)
		{
                        this.difficulty = difficulty;  
                        
                        try
			{
				hat = 
                                ImageIO.read(new File("c:\\img\\shapka.png"));
			}
			catch(IOException ex){}
				
			try
			{
				background = 
                                ImageIO.read(new File("c:\\img\\fon.png"));
			}
			catch(IOException ex){}
			
                        try
			{
				endGameImage = 
                                ImageIO.read(new File("c:\\img\\p6.png"));
			}
			catch(IOException ex){}
                        
                        gameGift = new Gift[7];
                        for (int i = 0; i < 7; i++)
                        {
                            try
                            {
                                if(i == 7){
                                gameGift[i] = new Gift(
                                ImageIO.read(new File("c:\\img\\p6.png")));
                                }
                                        
                                gameGift[i] = new Gift(
                                ImageIO.read(new File("c:\\img\\p"+i+".png")));
                            }
                            catch(IOException ex){}
                        }
                       	
			/**
			 * Create a timer that will check and add gifts on
                         * the playing field 1 time per 3 seconds
			 */
			 Timer timerUpdate = 
                                 new Timer(3000, new ActionListener(){
				 public void actionPerformed(ActionEvent ae){
					 updateStart();
				 }
			 });				 
		
                         timerUpdate.start();
                        
			/**
			 * Create a timer that will redraw the playing field
			 * 20 times a second
			 */
			 Timer timerDraw = 
                                 new Timer(50, new ActionListener(){
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
                        
                        /** Loops that display gifts on the gaming field */
                        for (int i = 0; i < 7; i++)
                        {
                                gameGift[i].draw(gr);
                                if(gameGift[i].active == true)
                                {
                                        if((gameGift[i].y + 
                                            gameGift[i].image.getHeight(null))
                                                >= 470)
                                        {
                                                if(Math.abs(gameGift[i].x - hatCoord)
                                                > 75)
                                                {
                                                        gr.drawImage(endGameImage, 300, 300, null);
                                                        timerDraw.stop();
                                                        timerUpdate.stop();
                                                        break;
                                                }
                                                else gameGift[i].active = false;
                                        }                                       
                                }
                                
                        }
		}
                
                /** Method that checks and adds gifts on the game field */
                private void updateStart()
                {
                        int number = 0;
                        for (int i = 0; i < 7; i++)
                        {
                                if(gameGift[i].active == false)
                                {
                                        if(number < difficulty)
                                        {
                                                gameGift[i].start();
                                                break;
                                        }
                                }
                                else number++;
                        }
                }
}
