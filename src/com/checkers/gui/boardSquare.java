package com.checkers.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.border.LineBorder;


public class boardSquare extends JComponent
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x; //x position of the rectangle measured from top left corner
    private int y; //y position of the rectangle measured from top left corner

    private boolean isBlack = false;
    private boolean isRed = false;

    public boardSquare(int p, int q, String type)
    {
    	this.setBorder(new LineBorder(Color.CYAN, 2));
        this.setPreferredSize(new Dimension(100, 100));
        x = p;
        y = q;
        if (type.equals("Black"))
        {
            isBlack = true;
            isRed = false;
        }
        else if (type.equals("Red"))
        {
            isRed = true;
            isBlack = false;
        }
        else if (type.equals("Blank"))
        {
            isBlack = false;
            isRed = false;
        }

    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle box = new Rectangle(x,y,100,100);
        g2.draw(box);
        g2.setPaint(Color.RED);
        g2.fill(box);

        if(isBlack)
        {
            g2.fillOval(x, y,100 ,100 );
            g2.setColor(Color.black);
            g2.drawOval(x, y, 100, 100);
        }

        else if(isRed)
        {
            g2.fillOval(x, y,100 ,100 );
            g2.setColor(Color.red);
            g2.drawOval(x, y, 100, 100);
        }

    }
}
