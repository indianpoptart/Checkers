package com.checkers.gui;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
 * @author Brian Maguire
 * @author Michael Search
 */
public class Board extends MouseAdapter
{
	private ArrayList<JComponent> spaces = new ArrayList<JComponent>();
	public Board()
	{
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
				if (row % 2 == 0){
					panel.setBackground(Color.BLACK);

					panel.addMouseListener(new MouseAdapter() {


						@Override
						public void mousePressed(MouseEvent e) {
							int x = e.getComponent().getHeight();
							System.out.println("Clicked a space" + x);
							
						}

						@Override
						public void mouseReleased(MouseEvent e) {
							System.out.println(e);
							int x = e.getXOnScreen();
							int y = e.getYOnScreen();
							System.out.println("Loc: " + x + ", " + y);
						}
					});
				}

				else
				{
					panel.setBackground(new Color(255, 105, 0));
					if ((row >= 0) && (row < 3))
						panel.add((new Piece("res/red.png").getComp()));
					else if (row > 4)
						panel.add((new Piece("res/black.png").getComp()));

					panel.addMouseListener(new MouseAdapter() {


						@Override
						public void mousePressed(MouseEvent e) {
							System.out.println("Clicked a piece");
						}

						@Override
						public void mouseReleased(MouseEvent e) {

						}
					});
				}

			}
			else
			{
				if (row % 2 == 0)
				{
					panel.setBackground(new Color(255, 105, 0));
					if ((row >= 0) && (row < 3))
						panel.add((new Piece("res/red.png").getComp()));
					else if (row > 4)
						panel.add((new Piece("res/black.png").getComp()));

					panel.addMouseListener(new MouseAdapter() {


						@Override
						public void mousePressed(MouseEvent e) {
							System.out.println("Clicked a piece");
						}

						@Override
						public void mouseReleased(MouseEvent e) {

						}
					});
				}
				else{
					panel.setBackground(Color.BLACK);

					panel.addMouseListener(new MouseAdapter() {


						@Override
						public void mousePressed(MouseEvent e) {
							System.out.println("Clicked a space");
						}

						@Override
						public void mouseReleased(MouseEvent e) {

						}
					});
				}
			}

			if (i % 8 == 7)
				row++;
			spaces.add(panel);
		}
	}
	public ArrayList<JComponent> getPane()
	{
		return spaces;
	}
}