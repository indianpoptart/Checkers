package com.checkers.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
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

import com.checkers.main.Location;
import com.checkers.main.Piece;

import javax.swing.*;

public class Board
{
	private JFrame GUI = new JFrame();
	private ArrayList<JPanel> spaces = new ArrayList<JPanel>();
	private Container pane = GUI.getContentPane();
	public Board()
	{
		GUI.setTitle("Checkers");
		GUI.setSize(600, 600);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int row = 0;
		for (int i = 0; i < 64; i++)
		{
			JPanel panel = new JPanel();
			if (i % 2 == 0)
			{
				if (row % 2 == 0)
					panel.setBackground(Color.BLACK);
				else
					panel.setBackground(new Color(255, 105, 0));
			}
			else
			{
				if (row % 2 == 0)
					panel.setBackground(new Color(255, 105, 0));
				else
					panel.setBackground(Color.BLACK);
			}
			if (i % 8 == 7)
				row++;
			spaces.add(panel);
		}
	}
	public void showGrid()
	{
		pane.setLayout(new GridLayout(8, 8, 5, 5));
		while (spaces.size() > 0)
			pane.add(spaces.remove(0));
		GUI.setVisible(true);
	}
	private void move(Component piece, Location loc)
	{
		pane.add(piece, ((loc.getRow() - 1) * 8) + loc.getCol());
		piece.getLocation().getX();
	}
	public void fillBoard()
	{
		int space = 1;
		int count = 0;
		for (int i = 0; i < 12; i++)
		{
			this.move(new Piece(new ImageIcon("/res/black.png"), new Location((count / 4), space)));
			space += 2;
			count++;
		}
		space = 0;
		count = 5;
		for (int j = 0; j < 12; j++)
		{
			this.move(new Piece(new ImageIcon("/res/red.png"), (new Location((count / 4), space))));
			space += 2;
			count++;
		}
	}
}
