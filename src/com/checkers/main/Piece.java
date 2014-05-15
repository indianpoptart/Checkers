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
	private JButton piece;
	private Location loc;
	public Piece(ImageIcon img, Location loc)
	{
		piece.setIcon(img);
	    
		this.loc = loc;
		BufferedImage pic = new BufferedImage(0, 0, 0);;
		try 
		{
			pic = ImageIO.read(new File("res/black.png"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		JLabel label = new JLabel(new ImageIcon(pic));
	}
	public Location getLocation()
	{
		return loc;
	}
	public ArrayList<Location> getMoveLocations() 
	{
		ArrayList<Location> locs = new ArrayList<Location>();
		Location current = getLocation();
		if (current.getRow() == 0)
		{
			if (current.getCol() == 1)
			{
				locs.add(current);
			}
			else if (current.getCol() == 7)
			{
				
			}
		}
		else if (current.getRow() == 7)
		{
			
		}
		else
		{
			
		}
		return locs;
	}
	public void setLocation(Location loc)
	{
		this.loc = loc;
	}
}