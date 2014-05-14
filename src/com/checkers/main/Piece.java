package com.checkers.main;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Piece
{
	private JComponent piece;
	private Location loc;
	public Piece(ImageIcon img, Location loc)
	{
		piece = new JButton();
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
				locs.add();
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