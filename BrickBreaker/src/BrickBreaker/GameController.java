package BrickBreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController extends JPanel implements KeyListener, ActionListener {
    private boolean isPlaying = false;
    private int score = 0;

    private Timer timer;
    private int delay = 8;

    private int totalBricks = 12;

    private int playerX = 310;

    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;

    private BrickGenerator grid;

    public GameController() {
        //the listener object created from the class is registered with the component
        //using the addListenerMethod -- i interpret this as the GameController which is the component
        // because it extends JPanel is registered with the listener by passing it with the
        //'this' keyword to the addKeyListener method.

        grid = new BrickGenerator(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        //setBorder(BorderFactory.createLineBorder(Color.green));

        timer = new Timer(delay, this);
        timer.start();
    }


    public void paintComponent(Graphics g) {
        //create background
        g.setColor(Color.black);
        g.fillRect(1, 1, 700, 600);

        //borders
        g.setColor(Color.yellow);
        g.fillRect(0,0,3,600);
        g.fillRect(0,0,700,3);
        g.fillRect(697,0,3,600);

        //paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);

        //ball
        g.setColor(Color.yellow);
        g.fillOval(ballPosX, ballPosY, 20, 20);

        //grid
        grid.draw((Graphics2D) g);

        g.dispose();


    }

    @Override
    public void keyReleased(KeyEvent e) {
        //TODO
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();

        if(isPlaying) {
            if(new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
                ballYdir = -ballYdir;
            }

            A: for(int i=0; i<grid.grid.length; i++) {
                for(int j=0; j<grid.grid[0].length; j++) {
                    if(grid.grid[i][j] > 0) {
                        int brickX = (j*grid.brickWidth+80);
                        int brickY = (i*grid.brickHeight+40);
                        int brickWidth = grid.brickWidth;
                        int brickHeight = grid.brickHeight;

                        Rectangle brick = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
                        Rectangle brickRect = brick;

                        if(ballRect.intersects(brickRect)) {
                            System.out.println("ballrect: " + ballRect.x + " " + ballRect.y + " " + ballRect.width + " " + ballRect.height);
                            System.out.println("brickReckt: " + brickRect.x + " " + brickRect.y + " " + brickRect.width + " " + brickRect.height);

                            grid.setBrickValue(0, i, j);
                            totalBricks--;
                            score+=5;

                            //make ball bounce back
                            if(ballPosX <= brickRect.x || ballPosX >= brickRect.x + brickRect.width) {
                                ballXdir = -ballXdir;
                            } else {
                                ballYdir = -ballYdir;
                            }

                            break A;
                        }
                    }
                }
            }

            ballPosX += ballXdir;
            ballPosY += ballYdir;

            if(ballPosX <= 0) {
                ballXdir = -ballXdir;
            }
            if(ballPosX >= 680) {
                ballXdir = -ballXdir;
            }
            if(ballPosY <= 0) {
                ballYdir = -ballYdir;
            }
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //TODO
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(playerX <= 10) {
                playerX = 10;
            } else {
               moveLeft();
            }
        }
       if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(playerX >= 590) {
                playerX = 590;
            } else {
                moveRight();
            }
       }

    }
    public void moveLeft() {
        isPlaying = true;
        playerX -= 20;
    }


    public void moveRight() {
        isPlaying = true;
        playerX += 20;
    }
}
