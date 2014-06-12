package com.checkers.game;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.checkers.gui.*;

public class Piece extends JLabel
{
	private static final long serialVersionUID = 1L;
	private boolean king;
	private Color color;
	private Icon pic;
	public Piece()
	{
		super();
	}
	public Piece(Color color)
	{
		new Piece();
		king = false;
		if (color == Color.WHITE)
		{
			pic = new ImageIcon("src/whitePiece.png");
		}
		else if (color == Color.BLACK)
		{
			pic = new ImageIcon("src/blackPiece.png");
		}
		this.color = color;
		super.setIcon(pic);
	}
	public static Piece getPiece(int index)
	{
		return (Piece)CheckerBoard.getSpaces().get(index).getComponent(Piece.CENTER);
	}
	public static void removePiece(int index)
	{
		CheckerBoard.getSpaces().get(index).removeAll();
	}
	public static boolean containsPiece(int index)
	{
		if (CheckerBoard.getSpaces().get(index).getComponentCount() == 0)
			return false;
		return true;
	}
	public static boolean canCapture(int index)
	{
		if (getCaptureLocations(index).size() == 0)
			return false;
		return true;
	}
	public Color getColor()
	{
		return color;
	}
	public void makeKing()
	{
		king = true;
		if (color == Color.white)
		{
			pic = new ImageIcon("src/whiteKingPiece.png");
		}
		else if (color == Color.black)
		{
			pic = new ImageIcon("src/blackKingPiece.png");
		}
		super.setIcon(pic);
	}
	public boolean isKing()
	{
		return king;
	}
	public static void move(MouseEvent me)
	{
		try
		{
			if (CheckerBoard.getClickCount() % 2 == 0)
			{
				if (CheckerBoard.getPlayerCount() == 1)
				{
					Point initialPoint = me.getComponent().getLocationOnScreen();
					for (int i = 0; i < 8; i++)
					{
						for (int j = 0; j < 8; j++)
						{
							if ((initialPoint.getX() == Checkers.getPoints()[0][i]) && (initialPoint.getY() == Checkers.getPoints()[1][j]))
							{
								boolean canJump = false;
								boolean willJump = false;
								for (int y = 0; y < 64; y++)
								{
									try
									{
										if ((canCapture(y)) && (getPiece(y).getColor().equals(Color.white)))
											canJump = true;
									}
									catch (IndexOutOfBoundsException e){}
								}
								if (getCaptureLocations((j * 8) + i).size() > 0)
									willJump = true;
								if (((i + j) % 2 == 0) || (getEmptyMoveLocations((j * 8) + i).size() == 0) || (getPiece((j * 8) + i).getColor().equals(Color.black)) || (canJump && !willJump))
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
					}
				}
				else if (CheckerBoard.getPlayerCount() == 2)
				{
					Point initialPoint = me.getComponent().getLocationOnScreen();
					for (int i = 0; i < 8; i++)
					{
						for (int j = 0; j < 8; j++)
						{
							if ((initialPoint.getX() == Checkers.getPoints()[0][i]) && (initialPoint.getY() == Checkers.getPoints()[1][j]))
							{
								boolean canJump = false;
								boolean willJump = false;
								for (int y = 0; y < 64; y++)
								{
									try
									{
										if ((canCapture(y)) && (getPiece(y).getColor().equals(Color.black)))
											canJump = true;
									}
									catch (IndexOutOfBoundsException e){}
								}
								if (getCaptureLocations((j * 8) + i).size() > 0)
									willJump = true;
								if (((i + j) % 2 == 0) || (getEmptyMoveLocations((j * 8) + i).size() == 0) || (getPiece((j * 8) + i).getColor().equals(Color.white)) || (canJump && !willJump))
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
					}
				}
			}
			else
			{
				Point finalPoint = me.getComponent().getLocationOnScreen();
				for (int i = 0; i < 8; i++)
				{
					for (int j = 0; j < 8; j++)
					{
						if ((finalPoint.getX() == Checkers.getPoints()[0][i]) && (finalPoint.getY() == Checkers.getPoints()[1][j]))
						{
							CheckerBoard.setFinalPoint((j * 8) + i);
							for (int x = 0; x < getEmptyMoveLocations(CheckerBoard.getInitialPoint()).size(); x++)
							{
								if (getEmptyMoveLocations(CheckerBoard.getInitialPoint()).get(x) == CheckerBoard.getFinalPoint())
								{
									boolean captured = false;
									if (canCapture(CheckerBoard.getInitialPoint()))
									{
										int[] capture = {-18, -14, 14, 18};
										for (int z = 0; z < 4; z++)
										{
											if (CheckerBoard.getInitialPoint() + capture[z] == CheckerBoard.getFinalPoint())
											{
												captured = true;
												removePiece(CheckerBoard.getInitialPoint() + (capture[z] / 2));
											}
										}
									}
									JPanel initial = (JPanel)CheckerBoard.getSpaces().get(CheckerBoard.getInitialPoint());
									JPanel end = (JPanel)CheckerBoard.getSpaces().get(CheckerBoard.getFinalPoint());
									CheckerBoard.getSpaces().set(CheckerBoard.getFinalPoint(), initial);
									CheckerBoard.getSpaces().set(CheckerBoard.getInitialPoint(), end);
									if ((CheckerBoard.getFinalPoint() > 55) && (((Piece)initial.getComponent(Piece.CENTER)).getColor().equals(Color.white)))
										getPiece(CheckerBoard.getFinalPoint()).makeKing();
									else if ((CheckerBoard.getFinalPoint() < 8) && (((Piece)initial.getComponent(Piece.CENTER)).getColor().equals(Color.black)))
										getPiece(CheckerBoard.getFinalPoint()).makeKing();
									if (!((canCapture(CheckerBoard.getFinalPoint())) && (captured)))
									{
										CheckerBoard.setPlayerCount((CheckerBoard.getPlayerCount() % 2) + 1);
										CheckerBoard.setToolBar();
									}
									Checkers.getPane().removeAll();
									for (int l = 0; l < 64; l++)
										Checkers.getPane().add(CheckerBoard.getSpaces().get(l));
									Checkers.getGUI().setContentPane(Checkers.getPane());
									break;
								}
							}
							int row = 0;
							for (int z = 0; z < 64; z++)
							{
								if (z % 2 == 0)
								{
									if (row % 2 == 0)
										CheckerBoard.setColor(z, Checkers.getSecondary());
									else
										CheckerBoard.setColor(z, Checkers.getPrimary());
								}
								else
								{
									if (row % 2 == 0)
										CheckerBoard.setColor(z, Checkers.getPrimary());
									else
										CheckerBoard.setColor(z, Checkers.getSecondary());
								}
								if (z % 8 == 7)
									row++;
							}
						}
					}
				}
				boolean whiteP = false, blackP = false;
				int whiteM = 0, blackM = 0;
				for (int z = 0; z < 63; z++)
					if (containsPiece(z))
					{
						if (getPiece(z).getColor().equals(Color.white))
						{
							whiteP = true;
							if (getEmptyMoveLocations(z).size() > 0)
								whiteM++;
						}
						else if (getPiece(z).getColor().equals(Color.black))
						{
							blackP = true;
							if (getEmptyMoveLocations(z).size() > 0)
								blackM++;
						}
					}
				if ((!whiteP) || (whiteM == 0))
					CheckerBoard.setToolBar("Player 2 Wins!");
				else if ((!blackP) || (blackM == 0))
					CheckerBoard.setToolBar("Player 1 Wins!");
			}
		}
		catch (IndexOutOfBoundsException e){}
		CheckerBoard.setClickCount(CheckerBoard.getClickCount() + 1);
	}
	public static ArrayList<Integer> getCaptureLocations(int current)
	{
		ArrayList<Integer> locs = getMoveLocations(current);
		for (int i = 0; i < locs.size(); i++)
		{
			try
			{
				if ((locs.get(i) == current - 9) && (containsPiece(locs.get(i))) && (!getPiece(current).getColor().equals(getPiece(locs.get(i)).getColor())))
				{
					if (!containsPiece(locs.get(i) - 9))
						locs.set(i, locs.get(i) - 9);
					else
					{
						locs.remove(i);
						i--;
					}
				}
				else if ((locs.get(i) == current - 9) && (!containsPiece(locs.get(i))))
				{
					locs.remove(i);
					i--;
				}
				else if ((locs.get(i) == current - 7) && (containsPiece(locs.get(i))) && (!getPiece(current).getColor().equals(getPiece(locs.get(i)).getColor())))
				{
					if (!containsPiece(locs.get(i) - 7))
						locs.set(i, locs.get(i) - 7);
					else
					{
						locs.remove(i);
						i--;
					}
				}
				else if ((locs.get(i) == current - 7) && (!containsPiece(locs.get(i))))
				{
					locs.remove(i);
					i--;
				}
				else if ((locs.get(i) == current + 7) && (containsPiece(locs.get(i))) && (!getPiece(current).getColor().equals(getPiece(locs.get(i)).getColor())))
				{
					if (!containsPiece(locs.get(i) + 7))
						locs.set(i, locs.get(i) + 7);
					else
					{
						locs.remove(i);
						i--;
					}
				}
				else if ((locs.get(i) == current + 7) && (!containsPiece(locs.get(i))))
				{
					locs.remove(i);
					i--;
				}
				else if ((locs.get(i) == current + 9) && (containsPiece(locs.get(i))) && (!getPiece(current).getColor().equals(getPiece(locs.get(i)).getColor())))
				{
					if (!containsPiece(locs.get(i) + 9))
						locs.set(i, locs.get(i) + 9);
					else
					{
						locs.remove(i);
						i--;
					}
				}
				else if ((locs.get(i) == current + 9) && (!containsPiece(locs.get(i))))
				{
					locs.remove(i);
					i--;
				}
			}
			catch (IndexOutOfBoundsException e){}
		}
		for (int j = 0; j < locs.size(); j++)
		{
			if (containsPiece(locs.get(j)))
			{
				locs.remove(j);
				j--;
			}
		}
		for (int k = 0; k < locs.size(); k++)
		{
			int y = locs.get(k) / 8; 
			int x = locs.get(k) % 8;
			if ((x + y) % 2 == 0)
			{
				locs.remove(k);
				k--;
			}
		}
		return locs;
	}
	public static ArrayList<Integer> getEmptyMoveLocations(int current)
	{
		if (getCaptureLocations(current).size() > 0)
			return getCaptureLocations(current);
		else
		{
			ArrayList<Integer> locs = getMoveLocations(current);
			for (int i = 0; i < locs.size(); i++)
			{
				if (containsPiece(locs.get(i)))
				{
					locs.remove(i);
					i--;
				}
			}
			return locs;
		}
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
		for (int i = 0; i < locs.size(); i++)
		{
			if (getPiece(current).getColor().equals(Color.white))
			{
				if ((!getPiece(current).isKing()) && (current > locs.get(i)))
				{
					locs.remove(i);
					i--;
				}
			}
			else if (getPiece(current).getColor().equals(Color.black))
			{
				if ((!getPiece(current).isKing()) && (current < locs.get(i)))
				{
					locs.remove(i);
					i--;
				}
			}
		}
		return locs;
	}
}