import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class of the window, that holds game-field
 * @author Pavlyk.B
 * @version 1.0
 */
public class Window extends JFrame
{
    
        /** Private variable - game-field */
        private Field gameField;
    
        /** The event handler of pressing the key */
        private class MyKey implements KeyListener
        {
                /** A method that is triggered by pressing the key */
                public void KeyPressed(KeyEvent ke)
                {
                        /** Obtain the code of the pressed key */
                        int key_= ke.getKeyCode();
                }
        
                @Override
                public void keyReleased(KeyEvent ke){}
                public void keyTyped(KeyEvent ke){}
                public void keyPressed(KeyEvent ke){}
        }
    
        /** Class Constructor */
        public Window()
        {
                /** 
                 * Connect the event handler for the keyboard to the window.
                 * Set the window to the active state.
                 */
                addKeyListener(new MyKey());
                setFocusable(true);
                
                /** Set window size and position and title */
                setBounds(0,0,800,600);
                setTitle("The Game: New Year Rush");
                
                /** 
                 * Create an object of the playing field and
                 * put panel - playing field in the window */
                gameField = new Field();
                Container container = getContentPane();
                container.add(gameField);
                
                /** Set the window to the visible state */
                setVisible(true);
        }   
}

