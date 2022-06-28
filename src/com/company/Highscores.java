package com.company;

import java.awt.*;

public class Highscores {

    public void render(Graphics graphics){

        Graphics2D graphics2D = (Graphics2D) graphics;

        Font font1 = new Font("arial", Font.BOLD, 60);
        graphics.setFont(font1);
        graphics.setColor(Color.black);
        graphics.drawString("HIGHSCORES", 400, 100);

    }
}
