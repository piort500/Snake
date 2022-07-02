package com.company;

import java.awt.*;

import static com.company.SnakePanel.height;
import static com.company.SnakePanel.width;

public class Highscores {

    public Rectangle buttonBack = new Rectangle(width / 4 + 100, 800 , 300, 100);

    public void render(Graphics graphics){

        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics.setColor(Color.white);
        graphics.fillRect(0,0, width, height);
        Font font1 = new Font("arial", Font.BOLD, 60);
        graphics.setFont(font1);
        graphics.setColor(Color.black);
        graphics.drawString("HIGHSCORES", 310, 100);

        Font font2 = new Font("arial", Font.BOLD, 40);
        graphics.setFont(font2);
        graphics2D.drawString("Back", buttonBack.x + 95 , buttonBack.y + 65);

        graphics2D.draw(buttonBack);
    }
}
