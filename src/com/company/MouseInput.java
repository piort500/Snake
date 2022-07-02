package com.company;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.company.SnakePanel.width;

public class MouseInput implements MouseListener {
    SnakePanel snakePanel;

    public MouseInput(SnakePanel snakePanel) {
        this.snakePanel = snakePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {




        int mx = e.getX();
        int my = e.getY();

        /*
        public Rectangle buttonPlay = new Rectangle(width / 4 + 100, 250 , 300, 100);
        public Rectangle buttonScore = new Rectangle(width / 4 + 100, 450 , 300, 100);
        public Rectangle buttonQuit = new Rectangle(width / 4 + 100, 650 , 300, 100);
        */

        if (SnakePanel.state == SnakePanel.STATE.MENU) {


            //Play
            if (mx >= width / 4 + 100 && mx <= width / 4 + 400) {
                if (my >= 250 && my <= 350) {
                    snakePanel.gameStart();
                }
            }

            //Highscores
            if (mx >= width / 4 + 100 && mx <= width / 4 + 400) {
                if (my >= 450 && my <= 550) {
                    SnakePanel.state = SnakePanel.STATE.HIGHSCORES;
                    snakePanel.draw(snakePanel.getGraphics());
                }
            }

            //Quit
            if (mx >= width / 4 + 100 && mx <= width / 4 + 400) {
                if (my >= 650 && my <= 750) {
                    System.exit(1);
                }
            }
        }

        //public Rectangle buttonBack = new Rectangle(width / 4 + 100, 800 , 300, 100);

        //back in game over

        if(SnakePanel.state == SnakePanel.STATE.GAMEOVER){
            if(mx >= width/4 + 100 && mx <= width/4 + 400){
                if(my >= 800 && my <= 900){
                    SnakePanel.state = SnakePanel.STATE.MENU;
                }
            }

        }

        //public Rectangle buttonBack = new Rectangle(width / 4 + 100, 800 , 300, 100);

        //back in highscore

        if(SnakePanel.state == SnakePanel.STATE.HIGHSCORES){
            if(mx >= width/4 + 100 && mx <= width/4 + 400){
                if(my >= 800 && my <= 900){
                    SnakePanel.state = SnakePanel.STATE.MENU;
                    snakePanel.draw(snakePanel.getGraphics());
                }
            }

        }


    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
