package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class SnakePanel extends JPanel implements ActionListener {

    static final int width = 1000;
    static final int height = 1000;
    static final int object = 50;
    static final int gameObjects = (width * height) / (object * object);
    static int delay = 150;
    final int x[] = new int[gameObjects];
    final int y[] = new int[gameObjects];
    public static STATE state;
    int snakeParts = 1;
    int pointsEaten;
    int pointX;
    int pointY;
    int badPointX;
    int badPointY;
    char snakeDirection = 'R';
    Timer timer;
    Random rand;
    public Rectangle buttonBack = new Rectangle(width / 4 + 100, 800 , 300, 100);
    int highscore = -1;
    public String playerName;



    public enum STATE{
        MENU,
        GAME,
        HIGHSCORES,
        GAMEOVER
    };

    SnakePanel() {
        state = STATE.MENU;
        rand = new Random();
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        this.setFocusable(true);
        this.addKeyListener(new SnakeControlls());
        this.addMouseListener(new MouseInput(this));
    }


    public void setPlayerName(){

    }

    public void startMenu(Graphics graphics){
        Menu menu = new Menu();
        menu.render(graphics);
        state = STATE.MENU;
        rand = new Random();
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.white);
        this.setFocusable(true);
        this.addKeyListener(new SnakeControlls());
        this.addMouseListener(new MouseInput(this));
        new SnakePanel();
    }

    public void startHighscore(Graphics graphics){
        Highscores highscores = new Highscores();
        highscores.render(graphics);
    }

    public void startGameover(Graphics graphics){
        Gameover gameover = new Gameover();
        gameover.render(graphics);
    }



    public void gameStart() {
        state = STATE.GAME;
        newPoint();
        newBadPoint();
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        draw(graphics);
    }

    public void newPoint(){
        pointX = rand.nextInt(width/object)*object;
        pointY = rand.nextInt(height/object)*object;
    }

    public void newBadPoint(){
        badPointX = rand.nextInt(width/object)*object;
        badPointY = rand.nextInt(height/object) *object;
    }
    public void moveSnake(){
        for(int i = snakeParts; i>0; i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch (snakeDirection) {
            case 'U' -> y[0] = y[0] - object;
            case 'D' -> y[0] = y[0] + object;
            case 'L' -> x[0] = x[0] - object;
            case 'R' -> x[0] = x[0] + object;
        }
    }

    public void pointCheck(){
        if((x[0] == pointX) && (y[0] == pointY)){
            snakeParts++;
            pointsEaten++;
            delay +=20;
            newPoint();
        }
    }

    public void badPointCheck(){
        if((x[0] == badPointX) && (y[0] == badPointY)){
            if(snakeParts==1){
            }else{
                snakeParts--;
            }
            if(pointsEaten==0){
            }else{
                pointsEaten--;
            }
            if(delay == 150){
            }else
                delay -= 25;
            newBadPoint();
        }
    }


    public void collisionCheck(){
        for(int i = snakeParts; i>0; i--){
            if((x[0] == x[i]) && (y[0] == y[i])){
                state = STATE.GAMEOVER;
            }
        }
        if(x[0] < 0) {
            state = STATE.GAMEOVER;
        }

        if(x[0] > width){
            state = STATE.GAMEOVER;
        }

        if(y[0] < 0){
            state = STATE.GAMEOVER;
        }

        if(y[0] > height){
            state = STATE.GAMEOVER;
        }

        if(state == STATE.GAMEOVER){
            timer.stop();
        }
    }

    public void draw(Graphics graphics){

        if(state == STATE.GAME){
           /* for(int i=0; i<height/object;i++){
                graphics.drawLine(i*object,0,i*object,height);
                graphics.drawLine(0,i*object,width,i*object);
            }
            */
            graphics.setColor(new Color(50,150,100));
            graphics.fillOval(pointX,pointY,object,object);
            graphics.setColor(Color.red);
            graphics.fillOval(badPointX,badPointY,object,object);

            for(int i = 0; i<snakeParts;i++){
                if(i == 0) {
                    graphics.setColor(new Color(34,100,0));
                    graphics.fillRect(x[i], y[i], object, object);
                }
                else{
                    graphics.setColor(new Color(0,255,0));
                    graphics.fillRect(x[i],y[i],object,object);
                }
            }
            graphics.setColor(Color.black);
            graphics.setFont(new Font("Purisa",Font.BOLD,30));
            FontMetrics metrics = getFontMetrics(graphics.getFont());
            graphics.drawString("Wynik: "+pointsEaten,(width - metrics.stringWidth("Wynik: "+pointsEaten))/2, graphics.getFont().getSize());
        }
        else if(state == STATE.MENU){
            startMenu(graphics);
        }
        else if(state == STATE.HIGHSCORES){
            startHighscore(graphics);

        }
        else if(state == STATE.GAMEOVER){
            startGameover(graphics);
        }
    }


    @Override
    public void actionPerformed(ActionEvent event){
        if(state == STATE.GAME){
            moveSnake();
            pointCheck();
            badPointCheck();
            collisionCheck();
        }
        repaint();
    }

    public class SnakeControlls extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(snakeDirection != 'R'){
                        snakeDirection = 'L';
                    }
                    break;

                case KeyEvent.VK_RIGHT:
                    if(snakeDirection != 'L'){
                        snakeDirection = 'R';
                    }
                    break;

                case KeyEvent.VK_UP:
                    if(snakeDirection != 'D'){
                        snakeDirection = 'U';
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if(snakeDirection != 'U'){
                        snakeDirection = 'D';
                    }
                    break;
            }
        }
    }
}