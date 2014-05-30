package com.checkers.gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

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
	public static int clickCount;
	public static Point initialPoint, finalPoint;
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
					panel.setBackground(Color.BLACK);
				else
				{
					panel.setBackground(new Color(255, 105, 0));
					if ((row >= 0) && (row < 3))
						label = (JLabel)new Piece(Color.WHITE).getPiece();
					else if (row > 4)
						label = (JLabel)new Piece(Color.BLACK).getPiece();
//					panel.addMouseListener(new MouseAdapter()
//					{
//						@Override public void mousePressed(MouseEvent me)
//						{
//							if (clickCount % 2 == 0)
//							{
//								initialPanel = (JPanel)me.getComponent();
//								initialPoint = initialPanel.getLocation();
//								System.out.println("Selected Point: " + initialPoint);
//							}
//							else
//							{
//								if ((initialPoint.getX() != me.getComponent().getLocation().getX()) && (initialPoint.getY() != me.getComponent().getLocation().getY()))
//								{
//									finalPoint = me.getComponent().getLocation();
//									int startLoc = 0;
//									for (int i = 0; i < 8; i++)
//									{
//										for (int j = 0; j < 8; j++)
//										{
//											if ((Checkers.points[0][i] == initialPoint.getX()) && (Checkers.points[1][j] == initialPoint.getY()))
//											{
//												startLoc = (j * 8) + i;
//											}
//										}
//									}
//									int endLoc = 0;
//									for (int x = 0; x < 8; x++)
//									{
//										for (int y = 0; y < 8; y++)
//										{
//											if ((Checkers.points[0][x] == finalPoint.getX()) && (Checkers.points[1][y] == finalPoint.getY()))
//											{
//												endLoc = (y * 8) + x;
//												spaces.set(endLoc, spaces.get(startLoc));
//												JPanel panel1 = new JPanel();
//												panel1.setBackground(new Color(255, 105, 0));
//												spaces.set(startLoc, panel1);
//											}
//										}
//									}
//									//Checkers.showBoard();
//								}
//							}
//							clickCount++;
//						}
//					});
				}
			}
			else
			{
				if (row % 2 == 0)
				{
					panel.setBackground(new Color(255, 105, 0));
					if ((row >= 0) && (row < 3))
						label = (JLabel)new Piece(Color.WHITE).getPiece();
					else if (row > 4)
						label = (JLabel)new Piece(Color.BLACK).getPiece();
//					panel.addMouseListener(new MouseAdapter()
//					{
//						@Override public void mousePressed(MouseEvent me)
//						{
//							if (clickCount % 2 == 0)
//							{
//								initialPanel = (JPanel)me.getComponent();
//								initialPoint = initialPanel.getLocation();
//								System.out.println("Selected Point: " + initialPoint);
//							}
//							else
//							{
//								if ((initialPoint.getX() != me.getComponent().getLocation().getX()) && (initialPoint.getY() != me.getComponent().getLocation().getY()))
//								{
//									finalPoint = me.getComponent().getLocation();
//									int startLoc = 0;
//									for (int i = 0; i < 8; i++)
//									{
//										for (int j = 0; j < 8; j++)
//										{
//											if ((Checkers.points[0][i] == initialPoint.getX()) && (Checkers.points[1][j] == initialPoint.getY()))
//											{
//												startLoc = (j * 8) + i;
//											}
//										}
//									}
//									int endLoc = 0;
//									for (int x = 0; x < 8; x++)
//									{
//										for (int y = 0; y < 8; y++)
//										{
//											if ((Checkers.points[0][x] == finalPoint.getX()) && (Checkers.points[1][y] == finalPoint.getY()))
//											{
//												endLoc = (y * 8) + x;
//												spaces.set(endLoc, spaces.get(startLoc));
//												spaces.set(startLoc, null);
//											}
//										}
//									}
//									//Checkers.showBoard();
//								}
//							}
//							clickCount++;
//						}
//					});
				}
				else
					panel.setBackground(Color.BLACK);
			}
			if (i % 8 == 7)
				row++;
			panel.add(label);
			spaces.add(panel);
		}
	}
}