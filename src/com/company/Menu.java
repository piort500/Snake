package com.company;

import java.awt.*;

import static com.company.SnakePanel.height;
import static com.company.SnakePanel.width;

public class Menu {

    public Rectangle buttonPlay = new Rectangle(width / 4 + 100, 250 , 300, 100);
    public Rectangle buttonScore = new Rectangle(width / 4 + 100, 450 , 300, 100);
    public Rectangle buttonQuit = new Rectangle(width / 4 + 100, 650 , 300, 100);


    public void render(Graphics graphics){

        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics.setColor(Color.white);
        graphics.fillRect(0,0, width, height);
        Font font1 = new Font("arial", Font.BOLD, 60);
        graphics.setFont(font1);
        graphics.setColor(new Color (0,100,0));
        graphics.drawString("SNAKE", 400, 100);

        graphics.setColor(Color.black);
        Font font2 = new Font("arial", Font.BOLD, 40);
        graphics.setFont(font2);
        graphics.drawString("Play", buttonPlay.x + 100, buttonPlay.y + 60);
        graphics.drawString("Highscores", buttonScore.x + 45, buttonScore.y + 60);
        graphics.drawString("Quit", buttonQuit.x + 105, buttonQuit.y + 60);


        graphics.setColor(Color.black);

        graphics2D.draw(buttonPlay);
        graphics2D.draw(buttonScore);
        graphics2D.draw(buttonQuit);

    }

}
