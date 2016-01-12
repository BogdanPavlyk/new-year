
import javax.swing.*;

/**
 * Main class of the game.
 *
 * @author Pavlyk.B
 * @version 1.0
 */
public class Game {

    /**
     * Main method, that starts the game
     */
    public static void main(String[] args) {
        /**
         * Call the dialog to select game difficulty.
         */
        String result
                = JOptionPane.showInputDialog(null,
                        "Type difficulty of the game from 1 to 7:",
                        "Game difficulty",
                        1);

        /**
         * Placing the result in a variable of type integer.
         */
        int difficulty = result.charAt(0) - '0';

        if ((difficulty >= 1) && (difficulty <= 7)) {
            /**
             * Creating the window, that holds game-field
             */
            Window window = new Window(difficulty);
        }
    }
}
