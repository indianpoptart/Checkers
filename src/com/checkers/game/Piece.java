package com.checkers.game;

import java.io.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

/* 
 * Checkers Game:
 * 
 * Piece Class
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
public class Piece
{
	private JComponent piece;
	private BufferedImage pic;
	public Piece(String img)
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
	
	public ArrayList<Integer> getEmptyMoveLocations(int current)
	{
		ArrayList<Integer> locs = getMoveLocations(current);
		ArrayList<Integer> occ = getOccupiedMoveLocations(current);
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
	private ArrayList<Integer> getOccupiedMoveLocations(int current)
	{
		ArrayList<Integer> locs = getMoveLocations(current);
		return locs;
	}
	private ArrayList<Integer> getMoveLocations(int current) 
	{
		ArrayList<Integer> locs = new ArrayList<Integer>();
		locs.add(current - 7);
		locs.add(current - 9);
		locs.add(current + 7);
		locs.add(current + 9);
		if (current < 8)
		{
			for (int i = 0; i < locs.size(); i++)
				if ((locs.get(1) == current - 7) || (locs.get(i) == current - 9))
					locs.remove(i);
		}
		else if (current > 55)
		{
			for (int j = 0; j < locs.size(); j++)
				if ((locs.get(j) == current + 7) || (locs.get(j) == current + 9))
					locs.remove(j);
		}
		if ((current == 8) || (current == 24) || (current == 40) || (current == 56))
		{
			for (int i = 0; i < locs.size(); i++)
				if ((locs.get(i) == current - 7) || (locs.get(i) == current + 7))
					locs.remove(i);
		}
		else if ((current == 7) || (current == 23) || (current == 39) || (current == 55))
		{
			for (int i = 0; i < locs.size(); i++)
				if ((locs.get(i) == current - 9) || (locs.get(i) == current + 9))
					locs.remove(i);
		}
		return locs;
	}
}