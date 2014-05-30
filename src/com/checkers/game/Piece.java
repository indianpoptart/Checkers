package com.checkers.game;

import java.io.*;
import java.awt.Color;
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
 */
public class Piece 
{
	private boolean king;
	private JComponent piece;
	private BufferedImage pic;
	private Color color;
	public Piece(Color color)
	{
		king = false;
		if (color == Color.WHITE)
		{
			try 
			{
				pic = ImageIO.read(new File("res/red.png"));
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else if (color == Color.BLACK)
		{
			try 
			{
				pic = ImageIO.read(new File("res/black.png"));
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		piece = new JLabel(new ImageIcon(pic));
	}
	public void makeKing()
	{
		king = true;
		if (color == Color.WHITE)
		{
			try 
			{
				pic = ImageIO.read(new File("src/whiteKingPiece.png"));
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else if (color == Color.BLACK)
		{
			try 
			{
				pic = ImageIO.read(new File("src/blackKingPiece.png"));
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		piece = new JLabel(new ImageIcon(pic));
	}
	public JComponent getPiece()
	{
		return piece;
	}
//	public ArrayList<Point> getEmptyMoveLocations(Point current)
//	{
//		ArrayList<Integer> locs = getMoveLocations(current);
//		ArrayList<Integer> occ = getOccupiedMoveLocations(current);
//		for (int i = 0; i < locs.size(); i++)
//		{
//			boolean rem = false;
//			for (int j = 0; j < occ.size(); j++)
//			{
//				if (locs.get(i) == occ.get(j))
//				{
//					rem = true;
//				}
//			}
//			if (rem)
//			{
//				locs.remove(i);
//				i--;
//			}
//		}
//		return locs;
//	}
//	private ArrayList<Point> getOccupiedMoveLocations(Point current)
//	{
//		ArrayList<Integer> locs = getMoveLocations(current);
//		return locs;
//	}
//	private ArrayList<Point> getMoveLocations(Point current) //throws IOException 
//	{
//		ArrayList<Point> locs = new ArrayList<Point>();
//		int x = 0;
//		int y = 0;
//		for (int i = 0; i < 8; i++)
//		{
//			if (CheckerBoard.getPoints()[0][i] == current.getX())
//			{
//				x = i;
//			}
//			for (int j = 0; j < 8; j++)
//			{
//				if (CheckerBoard.getPoints()[1][j] == current.getY())
//				{
//					y = j;
//				}
//			}
//		}
//		try
//		{
//			locs.add(new Point(CheckerBoard.getPoints()[0][x - 1], CheckerBoard.getPoints()[1][y - 1]));
//			locs.add(new Point(CheckerBoard.getPoints()[0][x + 1], CheckerBoard.getPoints()[1][y + 1]));
//			locs.add(new Point(CheckerBoard.getPoints()[0][x - 1], CheckerBoard.getPoints()[1][y + 1]));
//			locs.add(new Point(CheckerBoard.getPoints()[0][x + 1], CheckerBoard.getPoints()[1][y - 1]));
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}

		
		
		
		
		
		//		if (current < 8)
		//		{
		//			for (int i = 0; i < locs.size(); i++)
		//				if ((locs.get(1) == current - 7) || (locs.get(i) == current - 9))
		//					locs.remove(i);
		//		}
		//		else if (current > 55)
		//		{
		//			for (int j = 0; j < locs.size(); j++)
		//				if ((locs.get(j) == current + 7) || (locs.get(j) == current + 9))
		//					locs.remove(j);
		//		}
		//		if ((current == 8) || (current == 24) || (current == 40) || (current == 56))
		//		{
		//			for (int i = 0; i < locs.size(); i++)
		//				if ((locs.get(i) == current - 7) || (locs.get(i) == current + 7))
		//					locs.remove(i);
		//		}
		//		else if ((current == 7) || (current == 23) || (current == 39) || (current == 55))
		//		{
		//			for (int i = 0; i < locs.size(); i++)
		//				if ((locs.get(i) == current - 9) || (locs.get(i) == current + 9))
		//					locs.remove(i);
		//		}
//		return locs;
//	}
}