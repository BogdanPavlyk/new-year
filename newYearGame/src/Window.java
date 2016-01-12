
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;

/**
 * Class of the window, that holds game-field
 *
 * @author Pavlyk.B
 * @version 1.0
 */
public class Window extends JFrame {

    /**
     * Private variable - game-field
     */
    private Field gameField;
    /**
     * Variable that holds game difficulty
     */
    private int difficulty;

    /**
     * The event handler of pressing the key
     */
    private class MyKey implements KeyListener {

        /**
         * A method that is triggered by pressing the key
         */
        public void keyPressed(KeyEvent ke) {
            /**
             * Obtain the code of the pressed key
             */
            int key_ = ke.getKeyCode();
            switch (key_) {
                case VK_ESCAPE:
                    System.exit(0);
                //if pressed left arrow key
                case VK_LEFT:
                    if (gameField.hatCoord - 30 > -48) {
                        gameField.hatCoord -= 30;
                    } else {
                        gameField.hatCoord = 752;
                    }
                    break;
                //if pressed right arrow key
                case VK_RIGHT:
                    if (gameField.hatCoord + 30 < 752) {
                        gameField.hatCoord += 30;
                    } else {
                        gameField.hatCoord = -48;
                    }
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
        }

        @Override
        public void keyTyped(KeyEvent ke) {
        }
    }

    /**
     * Class Constructor
     */
    public Window(int difficulty) {
        this.difficulty = difficulty;

        /**
         * Connect the event handler for the keyboard to the window. Set the
         * window to the active state.
         */
        addKeyListener(new MyKey());
        setFocusable(true);

        /**
         * Set window size and position and title
         */
        setBounds(0, 0, 800, 600);
        setTitle("The Game: New Year Rush");

        /**
         * Create an object of the playing field and put panel - playing field
         * in the window
         */
        gameField = new Field(difficulty);
        Container container = getContentPane();
        container.add(gameField);

        /**
         * Set the window to the visible state
         */
        setVisible(true);
    }
}
