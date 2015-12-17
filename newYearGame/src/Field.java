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
        /** Class  Constructor */
        public Field()
        {
                /**
                 * Create a timer that will redraw the playing field
                 * 20 times a second
                 */
                 Timer timerDraw = new Timer(50, new ActionListener(){
                     @Override
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
        public void paintComponent(Graphics gr){}
    
}
