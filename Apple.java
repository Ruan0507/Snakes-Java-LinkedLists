
/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Container;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.*;

public class Apple
{
    private int rowPos;
    private int colPos;
    
    public Apple(int x,int y)
    {
        rowPos=x;
        colPos=y;
    }
    
    public int getRow()
    {
     return rowPos;
    }
    
    public int getCol()
    {
     return colPos;
    }
    
}
