package com.company;

import java.awt.*;

public class Gameover extends SnakePanel{

    public void render(Graphics graphics){

    Graphics2D graphics2D = (Graphics2D) graphics;

    graphics.setColor(Color.black);
    graphics.setFont(new Font("Purisa",Font.BOLD,30));
    FontMetrics metric = getFontMetrics(graphics.getFont());
    graphics.drawString("Wynik: "+pointsEaten,(width - metric.stringWidth("Wynik: "+pointsEaten))/2, graphics.getFont().getSize());

    graphics.setColor(Color.red);
    graphics.setFont(new Font("Purisa",Font.BOLD, 90));
    FontMetrics metric2 = getFontMetrics(graphics.getFont());
    graphics.drawString("Przegrałeś!",(width - metric2.stringWidth("Przegrałeś!"))/2, height/2);

    graphics.setColor(Color.black);
    graphics.setFont(new Font("Purisa",Font.BOLD, 40));
    graphics2D.draw(buttonBack);
    graphics2D.drawString("Back", buttonBack.x + 100, buttonBack.y + 60);

}
}
