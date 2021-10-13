
/**
 * Write a description of class Snakes here.
 * 
 * @author (Ruan Small 27027228) 
 * @version (Snakes)
 */

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.Timer;

import java.util.Random;

public class Snakes implements  KeyListener
{
    JPanel[][] panels;
    JFrame frame = new JFrame("SnakeGame");
    JPanel playAreaPanel;

    //String direction;
    int ROWS = 10;
    int COLS = 10;

    SinglyLinkedList snake;

    //SnakeElement one;
    Apple food;

    int snakeSize = 0;
    int score = 1;

    private int TIME_DELAY = 250;
    private Timer timer;

    String direction = null;

    public Snakes()
    {
        playAreaPanel = new JPanel();
        playAreaPanel.setSize (ROWS*25,COLS*25);
        GridLayout playLayout = new GridLayout(ROWS,COLS,1,1);
        playAreaPanel.setLayout(playLayout);
        playAreaPanel.addKeyListener(this);

        snake = new SinglyLinkedList();

        panels = new JPanel[ROWS][COLS];
        //initialise array of panels.Place panels on frame and set color to gray. 
        for(int i=0;i<ROWS;i++)
        {
            for(int x=0;x<COLS;x++)
            {
                panels[i][x]=new JPanel();
                playAreaPanel.add(panels[i][x]);
                panels[i][x].setBackground(Color.gray);
            }
        }

        //one = new SnakeElement(4, 4);
        panels[4][4].setBackground(Color.green); //make the selected panel white
        playAreaPanel.setFocusable(true);
        playAreaPanel.requestFocusInWindow();
        frame.add(playAreaPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize (ROWS*25,COLS*25);

        timer = new Timer(TIME_DELAY, new TimerListener());
        timer.start();

        placeFood();
        growSnake(4, 4);
        growSnake(4, 3);
        growSnake(4, 2);
        snakeSize = 0;

    }

    public static void main(String[] args)
    {
        new Snakes();
    }

    public void keyReleased(KeyEvent evt)
    {

    }

    public void keyTyped(KeyEvent e) 
    {
    }

    public void keyPressed(KeyEvent evt)
    {
        //Check the key that was pressed and set the direction
        switch (evt.getKeyCode())
        { 
            case KeyEvent.VK_UP:
            if (direction == "south")
                break;
            else
                direction = "north";
            break;
            case KeyEvent.VK_RIGHT:
            if (direction == "west")
                break;
            else
                direction = "east";        
            break;
            case KeyEvent.VK_LEFT:
            if (direction == "east")
                break;
            else
                direction = "west";
            break;
            case KeyEvent.VK_DOWN:
            if (direction == "north")
                break;
            else
                direction = "south";
            break;
        }
    }

    public void growSnake(int row, int col)
    {
        snake.append(new SnakeElement(row, col));

        snakeSize = snakeSize + 1;

        if (((snakeSize % 5) == 0) && TIME_DELAY >= 10)
        {
            TIME_DELAY = TIME_DELAY - 30;
        }

        if (snakeSize == (ROWS * COLS))
        {
            JOptionPane.showMessageDialog(null, "You won the game!");
            System.exit(0);
        }

        panels[row][col].setBackground(Color.green);

    }

    public void placeFood()
    {
        Random randPos = new Random();

        int appleX = randPos.nextInt(ROWS - 1) + 1;
        int appleY = randPos.nextInt(COLS - 1) + 1;
        while(snake.checkAppleCollision(appleX, appleY) == true)
        {
            appleX = randPos.nextInt(ROWS - 1) + 1;
            appleY = randPos.nextInt(COLS - 1) + 1;
        }

        food = new Apple(appleX, appleY);
        panels[food.getRow()][food.getCol()].setBackground(Color.red);
    }

    private class TimerListener implements ActionListener 
    {        
        public void actionPerformed(ActionEvent e) 
        {
            frame.setTitle("Score : " + snakeSize);

            SnakeElement head = snake.getHead().getData();
            SnakeElement newPoint = head;
            SnakeElement tail = snake.getTail().getData();

            if (direction == "north")
            {

                if ((head.getRow() - 1) >= 0)
                {
                    newPoint = new SnakeElement(head.getRow() - 1, head.getCol());

                    panels[tail.getRow()][tail.getCol()].setBackground(Color.gray);
                    snake.remove(tail);

                    panels[newPoint.getRow()][newPoint.getCol()].setBackground(Color.green);
                    snake.prepend(newPoint);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Game Over\nYour score: " + snakeSize);
                    System.exit(0);
                }

            }
            if (direction == "east")
            {

                if ((head.getCol() + 1) < COLS)
                {
                    newPoint = new SnakeElement(head.getRow(), head.getCol() + 1);

                    panels[tail.getRow()][tail.getCol()].setBackground(Color.gray);
                    snake.remove(tail);

                    panels[newPoint.getRow()][newPoint.getCol()].setBackground(Color.green);
                    snake.prepend(newPoint);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Game Over\nYour score: " + snakeSize);
                    System.exit(0);
                }

            }
            if (direction == "south")
            {

                if ((head.getRow() + 1) < ROWS)
                {
                    newPoint = new SnakeElement(head.getRow() + 1, head.getCol());

                    panels[tail.getRow()][tail.getCol()].setBackground(Color.gray);
                    snake.remove(tail);

                    panels[newPoint.getRow()][newPoint.getCol()].setBackground(Color.green);
                    snake.prepend(newPoint);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Game Over\nYour score: " + snakeSize);
                    System.exit(0);
                }

            }
            if (direction == "west")
            {

                if ((head.getCol() - 1) >= 0)
                {
                    newPoint = new SnakeElement(head.getRow(), head.getCol() - 1);

                    panels[tail.getRow()][tail.getCol()].setBackground(Color.gray);
                    snake.remove(tail);

                    panels[newPoint.getRow()][newPoint.getCol()].setBackground(Color.green);
                    snake.prepend(newPoint);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Game Over\nYour score: " + snakeSize);
                    System.exit(0);
                }

            }

            if (snake.checkRowCol(newPoint.getRow(), newPoint.getCol()) == true)
            {
                JOptionPane.showMessageDialog(null, "Game Over\nYour score: " + snakeSize);
                System.exit(0);
            }

            if (newPoint.getRow() == food.getRow() && newPoint.getCol() == food.getCol())
            {
                placeFood();
                growSnake(tail.getRow(), tail.getCol());
            } 

        }

    }
}
