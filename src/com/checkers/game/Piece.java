package com.checkers.game;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.accessibility.Accessible;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.checkers.gui.CheckerBoard;


public class Piece extends JLabel implements SwingConstants, Accessible
{
	private static final long serialVersionUID = 1L;
	private boolean king;
	private JComponent piece;
	private BufferedImage pic;
	private Color color;
	public Piece(Color color)
	{
		if (color == Color.WHITE)
		{
			try 
			{
				pic = ImageIO.read(new File("src/whitePiece.png"));
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
				pic = ImageIO.read(new File("src/blackPiece.png"));
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
	public static void move(MouseEvent me)
	{
		if (CheckerBoard.getClickCount() % 2 == 0)
		{
			Point initialPoint = me.getComponent().getLocationOnScreen();
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 8; j++)
					if ((initialPoint.getX() == Checkers.getPoints()[0][i]) && (initialPoint.getY() == Checkers.getPoints()[1][j]))
					{
						if ((i + j % 2 == 0) || (getEmptyMoveLocations((j * 8) + 1).size() == 0))
							CheckerBoard.setClickCount(CheckerBoard.getClickCount() - 1);
						else
						{
							CheckerBoard.setInitialPoint((j * 8) + i);
							for (int k = 0; k < getEmptyMoveLocations(CheckerBoard.getInitialPoint()).size(); k++)
								CheckerBoard.setColor(getEmptyMoveLocations(CheckerBoard.getInitialPoint()).get(k), Checkers.getTertiary());
							Checkers.getPane().removeAll();
							for (int a = 0; a < 64; a++)
								Checkers.getPane().add(CheckerBoard.getSpaces().get(a));
							Checkers.getGUI().setContentPane(Checkers.getPane());
						}
					}
		}
		else
		{
			Point finalPoint = me.getComponent().getLocationOnScreen();
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 8; j++)
					if ((finalPoint.getX() == Checkers.getPoints()[0][i]) && (finalPoint.getY() == Checkers.getPoints()[1][j]))
					{
						CheckerBoard.setFinalPoint((j * 8) + i);
						for (int x = 0; x < getEmptyMoveLocations(CheckerBoard.getInitialPoint()).size(); x++)
							if (getEmptyMoveLocations(CheckerBoard.getInitialPoint()).get(x) == CheckerBoard.getFinalPoint())
							{
								for (int k = 0; k < getEmptyMoveLocations(CheckerBoard.getInitialPoint()).size(); k++)
									CheckerBoard.setColor(getEmptyMoveLocations(CheckerBoard.getInitialPoint()).get(k), Checkers.getPrimary());
								JPanel initial = (JPanel)CheckerBoard.getSpaces().get(CheckerBoard.getInitialPoint());
								JPanel end = (JPanel)CheckerBoard.getSpaces().get(CheckerBoard.getFinalPoint());
								CheckerBoard.getSpaces().set(CheckerBoard.getFinalPoint(), initial);
								CheckerBoard.getSpaces().set(CheckerBoard.getInitialPoint(), end);
								Checkers.getPane().removeAll();
								for (int l = 0; l < 64; l++)
									Checkers.getPane().add(CheckerBoard.getSpaces().get(l));
								Checkers.getGUI().setContentPane(Checkers.getPane());
							}		
						for (int k = 0; k < getEmptyMoveLocations(CheckerBoard.getInitialPoint()).size(); k++)
							CheckerBoard.setColor(getEmptyMoveLocations(CheckerBoard.getInitialPoint()).get(k), Checkers.getPrimary());
					}
		}
		CheckerBoard.setClickCount(CheckerBoard.getClickCount() + 1);
	}
	public void makeKing(int index)
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
	public boolean isKing()
	{
		return king;
	}
	public static ArrayList<Integer> getEmptyMoveLocations(int current)
	{
		ArrayList<Integer> locs = getMoveLocations(current);
		for (int i = 0; i < locs.size(); i++)
		{
			if (CheckerBoard.getIsOccupied(locs.get(i)))
			{
				locs.remove(i);
				i--;
			}
		}
		try 
		{
			for (int i = 0; i < locs.size(); i++)
			{
//				JLabel label = (JLabel)new Piece(Color.white).getPiece();
				//label.
			//	System.out.println((CheckerBoard.getSpaces().get(i).getComponent(0)).equals(label));
				//if ((JLabel)locs.get(i).getComponent(0). != null);
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		return locs;
	}
	public static ArrayList<Integer> getOccupiedMoveLocations(int current)
	{
		ArrayList<Integer> locs = getMoveLocations(current);
		for (int i = 0; i < locs.size(); i++)
			if (!CheckerBoard.getIsOccupied(i))
			{
				locs.remove(i);
				i--;
			}
		return locs;
	}
	private static ArrayList<Integer> getMoveLocations(int current)
	{
		ArrayList<Integer> locs = new ArrayList<Integer>();
		locs.add(current + 7);
		locs.add(current + 9);
		locs.add(current - 7);
		locs.add(current - 9);
		if (current < 8)
		{
			for (int i = 0; i < locs.size(); i++)
			{
				if ((locs.get(i) == current - 7) || (locs.get(i) == current - 9))
				{
					locs.remove(i);
					i--;
				}
			}
		}
		else if (current > 55)
		{
			for (int j = 0; j < locs.size(); j++)
			{
				if ((locs.get(j) == current + 7) || (locs.get(j) == current + 9))
				{
					locs.remove(j);
					j--;
				}
			}
		}
		if ((current == 8) || (current == 24) || (current == 40) || (current == 56))
		{
			for (int i = 0; i < locs.size(); i++)
			{
				if ((locs.get(i) == current - 9) || (locs.get(i) == current + 7))
				{
					locs.remove(i);
					i--;
				}
			}
		}
		else if ((current == 7) || (current == 23) || (current == 39) || (current == 55))
		{
			for (int j = 0; j < locs.size(); j++)
			{
				if ((locs.get(j) == current - 7) || (locs.get(j) == current + 9))
				{
					locs.remove(j);
					j--;
				}
			}
		}
		return locs;
	}
}