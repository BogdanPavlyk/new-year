/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Class of the gift, that falls down
 * @author Pavlyk.B
 * @version 1.0
 */
public class Gift {
        private Image image; // the image of the gift
        public int x, y; // x - left margin, y - top margin
        public Boolean active; // if gift is on the field or not
        private Timer timerUpdate; // timer responsible for movement of the gift

        /** Class  Constructor */
        public Gift(Image image)
        {
                /**
                 * Create a timer that is responsible for
                 * movement of the gift.
                 */
                timerUpdate = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                goDown();
                        }
                });
                
                /** transfer  gift image in the class variable. */
                this.image = image;
                
                /** at the start the gift is not active -
                 * not present on the field.
                 */
                active = false;
        }
        
        /** method that will activate gift on the game-field.
         * It prints gift image on the top.
         */
        public void start()
        {
                timerUpdate.start(); // timer starts
                y = 0;
                // left margin we gain random in the interval [0, 700]
                x = (int)(Math.random()*700); 
                active = true; // gift became in active state.
        }
        
        /** method that is responsible for gift movement down */
        public void goDown()
        {
                if(active == true) // if gift is active on the field
                {
                        y += 6;
                }
                if((y + image.getHeight(null) >= 470)) // if gift has reached bottom
                {
                        timerUpdate.stop();
                }
        }
        
        /** method that is responsible for drawing gift on the field */
        public void draw(Graphics gr)
        {
                if(active == true)
                        {
                               gr.drawImage(image, x, y, null);
                        }
        }
}