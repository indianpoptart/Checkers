package com.checkers.game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

/* 
 * Checkers Game:
 * 
 * King Class
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
 * @author Adam Zukowski
 */

public class King extends Piece
{
	private JComponent piece;
	private BufferedImage pic;
	public King(String img)
	{
		try 
		{
			pic = ImageIO.read(new File(img));
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
		if (current.getY() == 0)
		{
			if (current.getX() == 1)
			{
				//locs.add();
			}
			else if (current.getX() == 7)
			{
				
			}
		}
		else if (current.getY() == 7)
		{
			
		}
		else
		{
			
		}
		return locs;
	}
}