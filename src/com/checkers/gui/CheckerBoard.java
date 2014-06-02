package com.checkers.gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import com.checkers.game.Checkers;
import com.checkers.game.Piece;

/* 
 * Checkers Game:
 * 
 * Board Class
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
 * @author Jordan Ghidossi
 * @author Nikhil Paranjape
 */
public class CheckerBoard 
{
	public static ArrayList<JComponent> spaces = new ArrayList<JComponent>();
	public static int initialPoint, finalPoint, clickCount;
	private boolean isPrimary = false, isOccupied = false;
	public CheckerBoard()
	{
		int row = 0;
		for (int i = 0; i < 64; i++)
		{
			JPanel panel = new JPanel();
			JLabel label = new JLabel();
			label.setHorizontalAlignment(JLabel.CENTER);
			if (i % 2 == 0)
			{
				if (row % 2 == 0)
					panel.setBackground(Checkers.secondary);
				else
				{
					panel.setBackground(Checkers.primary);
					if ((row >= 0) && (row < 3))
						label = (JLabel)new Piece(Color.WHITE).getPiece();
					else if (row > 4)
						label = (JLabel)new Piece(Color.BLACK).getPiece();
					isPrimary = true;
					isOccupied = true;
				}
			}
			else
			{
				if (row % 2 == 0)
				{
					panel.setBackground(Checkers.primary);
					if ((row >= 0) && (row < 3))
						label = (JLabel)new Piece(Color.WHITE).getPiece();
					else if (row > 4)
						label = (JLabel)new Piece(Color.BLACK).getPiece();
					isPrimary = true;
					isOccupied = true;
				}
				else
					panel.setBackground(Checkers.secondary);
			}
			if (i % 8 == 7)
				row++;
			panel.add(label);
			spaces.add(panel);
		}
	}
	public boolean getIsOccupied(int index)
	{
		return isOccupied;
	}
	public boolean getIsPrimary()
	{
		return isPrimary;
	}
	public static void setColor(int index, Color color)
	{
		spaces.get(index).setBackground(color);
	}
}