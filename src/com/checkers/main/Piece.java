package com.checkers.main;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
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
 * @author Jordan Ghidossi
 * @author Nikhil Paranjape
 */
public class Piece
{
	private JComponent piece;
	private BufferedImage pic;
	public Piece(String img)
	{
		try 
		{
			pic = ImageIO.read(new File(img));
			pic = (BufferedImage) pic.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		piece = new JLabel(new ImageIcon(pic));
	}
	public JComponent getComp()
	{
		return piece;
	}
	public ArrayList<Point> getEmptyMoveLocations()
	{
		ArrayList<Point> locs = getMoveLocations();
		ArrayList<Point> occ = getOccupiedMoveLocations();
		for (int i = 0; i < locs.size(); i++)
		{
			boolean rem = false;
			for (int j = 0; j < occ.size(); j++)
			{
				if (locs.get(i) == occ.get(j))
				{
					rem = true;
				}
			}
			if (rem)
			{
				locs.remove(i);
				i--;
			}
		}
		return locs;
	}
	public ArrayList<Point> getOccupiedMoveLocations()
	{
		ArrayList<Point> locs = getMoveLocations();
		return locs;
	}
	public ArrayList<Point> getMoveLocations() 
	{
		ArrayList<Point> locs = new ArrayList<Point>();
		Point current = piece.getLocation();
		if (current.getX() == 0)
		{
			if (current.getY() == 1)
			{
				//locs.add();
			}
			else if (current.getY() == 7)
			{
				
			}
		}
		else if (current.getX() == 7)
		{
			
		}
		else
		{
			
		}
		return locs;
	}
}
