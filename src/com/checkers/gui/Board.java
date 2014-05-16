package com.checkers.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;





/* 
 * Checkers Game:
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Nikhil Paranjape
 * @author Jordan Ghidossi
 */
import java.awt.*;
import java.util.ArrayList;

import com.checkers.game.Piece;
import com.checkers.main.RunCheckers;

public class Board extends RunCheckers
{
	//private JFrame GUI = new JFrame();
	private ArrayList<JPanel> spaces = new ArrayList<JPanel>();
	private Container pane;// = GUI.getContentPane();
	public Board()
	{
		//GUI.setTitle("Checkers");
		//GUI.setSize(550, 550);
		//GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createBoard();
	}
	public void createBoard()
	{
		int row = 0;
		for (int i = 0; i < 64; i++)
		{
			JPanel panel = new JPanel();
			if (i % 2 == 0)
			{
				if (row % 2 == 0)
					panel.setBackground(Color.BLACK);
				else
				{
					panel.setBackground(new Color(255, 105, 0));
					if ((row >= 0) && (row < 3))
						panel.add((new Piece("res/cardinal.png").getComp()));
					else if (row > 4)
						panel.add((new Piece("res/tiger.png").getComp()));
				}
			}
			else
			{
				try{
				if (row % 2 == 0)
				{
					panel.setBackground(new Color(255, 105, 0));
					if ((row >= 0) && (row < 3))
						panel.add((new Piece("res/cardinal.png").getComp()));
					else if (row > 4)
						panel.add((new Piece("res/tiger.png").getComp()));
				}
				else
					panel.setBackground(Color.BLACK);
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e, "Error",JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
			}
			if (i % 8 == 7)
				row++;
			spaces.add(panel);
		}
		pane.setLayout(new GridLayout(8, 8, 5, 5));
		ArrayList<JPanel> list = spaces;
		while (spaces.size() > 0)
			pane.add(spaces.remove(0));
		spaces = list;
	}
	//	public void move(Point start, Point end)
	//	{
	//		ArrayList<JPanel> list = spaces;
	//		JPanel panel = spaces.get((int)((start.getX() - 1) + start.getY()));
	//		panel.getComponent(0);
	//		spaces.set((int)((end.getX() - 1) * (end.getY())), panel);
	//		pane = GUI.getContentPane();
	//		pane.setLayout(new GridLayout(8, 8, 5, 5));
	//		while (spaces.size() > 0)
	//			pane.add(spaces.remove(0));
	//		spaces = list;
	//	}
	//	public void removeBoard()
	//	{
	//		GUI.setVisible(false);
	//	}
	public Container getPane()
	{
		return pane;
	}
}