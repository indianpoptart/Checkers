package com.checkers.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.checkers.game.*;

public class CheckerBoard
{
	private static ArrayList<JComponent> spaces = new ArrayList<JComponent>();
	private static int initialPoint, finalPoint, clickCount;
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
					panel.setBackground(Checkers.getSecondary());
				else
				{
					panel.setBackground(Checkers.getPrimary());
					if ((row >= 0) && (row < 3))
					{
						label = (JLabel)new Piece(Color.WHITE).getPiece();
						label.setOpaque(false);
						panel.add(label);
					}
					else if (row > 4)
					{
						label = (JLabel)new Piece(Color.BLACK).getPiece();
						panel.add(label);
					}
					panel.addMouseListener(new MouseListener()
					{
						@Override public void mousePressed(MouseEvent me)
						{
							Piece.move(me);
						}
						@Override public void mouseClicked(MouseEvent arg0) 
						{

						}
						@Override public void mouseEntered(MouseEvent arg0) 
						{

						}
						@Override public void mouseExited(MouseEvent arg0) 
						{

						}
						@Override public void mouseReleased(MouseEvent arg0) 
						{

						}
					});
				}
			}
			else
			{
				if (row % 2 == 0)
				{
					panel.setBackground(Checkers.getPrimary());
					if ((row >= 0) && (row < 3))
					{
						label = (JLabel)new Piece(Color.WHITE).getPiece();
						panel.add(label);
					}
					else if (row > 4)
					{
						label = (JLabel)new Piece(Color.BLACK).getPiece();
						panel.add(label);
					}
					panel.addMouseListener(new MouseListener()
					{
						@Override public void mousePressed(MouseEvent me)
						{
							Piece.move(me);
						}
						@Override public void mouseClicked(MouseEvent arg0) 
						{

						}
						@Override public void mouseEntered(MouseEvent arg0) 
						{

						}
						@Override public void mouseExited(MouseEvent arg0) 
						{

						}
						@Override public void mouseReleased(MouseEvent arg0) 
						{

						}
					});
				}
				else
					panel.setBackground(Checkers.getSecondary());
			}
			if (i % 8 == 7)
				row++;
			spaces.add(panel);
		}
	}
	public static void showBoard()
	{
		new CheckerBoard();
		Checkers.getPane().removeAll();
		Checkers.getGUI().setLayout(new GridLayout(8, 8, 5, 5));
		for (int i = 0; i < 64; i++)
		{
			Checkers.getPane().add(CheckerBoard.spaces.get(i));
		}
		Checkers.getPane().setPreferredSize(new Dimension(550, 550));
		Checkers.getGUI().setContentPane(Checkers.getPane());

		JMenuBar toolbar = new JMenuBar();
		toolbar.setPreferredSize(new Dimension(550, 20));
		toolbar.setBackground(Checkers.getTertiary());
		JMenu file = new JMenu("File");
		file.setBackground(Checkers.getTertiary());
		file.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		JButton newGame = new JButton("New Game");
		newGame.setBackground(Checkers.getTertiary());
		newGame.setBorderPainted(false);
		newGame.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		file.add(newGame);
		file.addSeparator();
		JButton quit = new JButton("Quit          ");
		quit.setBackground(Checkers.getTertiary());
		quit.setBorderPainted(false);
		quit.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		file.add(quit);
		JMenu edit = new JMenu("Edit");
		edit.setBackground(Checkers.getTertiary());
		edit.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		JButton colorScheme = new JButton("Color Scheme");
		colorScheme.setBackground(Checkers.getTertiary());
		colorScheme.setBorderPainted(false);
		colorScheme.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		edit.add(colorScheme);
		toolbar.add(file);
		toolbar.add(edit);
		for (int i = 0; i < 140; i++)
		{
			JLabel space = new JLabel(" ");
			toolbar.add(space);
		}
		JLabel player = new JLabel("Player " + ((CheckerBoard.clickCount % 2) + 1));
		player.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		toolbar.add(player);
		Checkers.getGUI().setJMenuBar(toolbar);

		newGame.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				Object[] options = {"Yes", "No"};
				UIManager.put("OptionPane.background", Checkers.getTertiary());
				UIManager.put("Panel.background", Checkers.getTertiary());
				UIManager.put("Button.background", Checkers.getPrimary());
				UIManager.put("Button.font", new Font("Times New Roman", Font.CENTER_BASELINE, 12));
				ImageIcon logo = new ImageIcon("src/tigerArt.png");
				int choice = JOptionPane.showOptionDialog(null, "Are you sure you want to restart?", "Checkers", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, logo, options, options[1]);
				if (choice == 0)
				{
					try 
					{
						Thread.sleep(125);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					CheckerBoard.setClickCount(0);
					new MainMenu();
					showBoard();
				}
			}
		});
		quit.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				Object[] options = {"Yes", "No"};
				UIManager.put("OptionPane.background", Checkers.getTertiary());
				UIManager.put("Panel.background", Checkers.getTertiary());
				UIManager.put("Button.background", Checkers.getPrimary());
				UIManager.put("Button.font", new Font("Times New Roman", Font.CENTER_BASELINE, 12));
				ImageIcon logo = new ImageIcon("src/tigerArt.png");
				int choice = JOptionPane.showOptionDialog(null, "Are you sure you want to quit?", "Checkers", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, logo, options, options[1]);
				if (choice == 0)
				{
					try 
					{
						Thread.sleep(125);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					CheckerBoard.setClickCount(0);
					Checkers.getGUI().setJMenuBar(null);
					new MainMenu();
				}
			}
		});
		colorScheme.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				Object[] choices = {"Orange and Black", "Classic", "Wood", "America", "Italy", "Violet", "Ocean", "Black and White"};
				UIManager.put("OptionPane.background", Checkers.getTertiary());
				UIManager.put("Panel.background", Checkers.getTertiary());
				UIManager.put("Button.background", Checkers.getPrimary());
				ImageIcon logo = new ImageIcon("src/americanFlagArt.png");
				String opt = (String)JOptionPane.showInputDialog(null, "Please choose a color scheme", "Checkers", JOptionPane.QUESTION_MESSAGE, logo,  choices,  choices[0]);
				int choice = Arrays.asList(choices).indexOf(opt);
				if (choice == 0)
				{
					Checkers.setPrimary(new Color(255, 105, 0));
					Checkers.setSecondary(Color.black);
				}
				else if (choice == 1)
				{
					Checkers.setPrimary(Color.black);
					Checkers.setSecondary(Color.red);
				}
				else if (choice == 2)
				{
					Checkers.setPrimary(new Color(198, 150, 73));
					Checkers.setSecondary(new Color(78, 46, 40));
				}
				else if (choice == 3)
				{
					Checkers.setPrimary(new Color(0, 82, 165));
					Checkers.setSecondary(new Color(224, 22, 43));
				}
				else if (choice == 4)
				{
					Checkers.setPrimary(new Color(234, 0, 0));
					Checkers.setSecondary(new Color(12, 120, 13));
				}
				else if (choice == 5)
				{
					Checkers.setPrimary(new Color(160, 0, 255));
					Checkers.setSecondary(new Color(50, 0, 50));
				}
				else if (choice == 6)
				{
					Checkers.setPrimary(new Color(109, 211, 170));
					Checkers.setSecondary(new Color(198, 150, 73));
				}
				else if (choice == 7)
				{
					Checkers.setPrimary(Color.white);
					Checkers.setSecondary(Color.black);
				}
				int row = 0;
				for (int i = 0; i < 64; i++)
				{
					if (i % 2 == 0)
					{
						if (row % 2 == 0)
							CheckerBoard.setColor(i, Checkers.getSecondary());
						else
							CheckerBoard.setColor(i, Checkers.getPrimary());
					}
					else
					{
						if (row % 2 == 0)
							CheckerBoard.setColor(i, Checkers.getPrimary());
						else
							CheckerBoard.setColor(i, Checkers.getSecondary());
					}
					if (i % 8 == 7)
						row++;
				}
				Checkers.getB1().setBackground(Checkers.getPrimary());
				Checkers.getB2().setBackground(Checkers.getPrimary());
				Checkers.getB3().setBackground(Checkers.getPrimary());
				new ExportSettings();
			}
		});
		Checkers.getGUI().setVisible(true);
	}
	public static boolean getIsOccupied(int index)
	{
		if (((JPanel)(spaces.get(index))).getComponentCount() > 0)
			return true;
		return false;
	}
	public static ArrayList<JComponent> getSpaces()
	{
		return spaces;
	}
	public static int getInitialPoint()
	{
		return initialPoint;
	}
	public static int getFinalPoint()
	{
		return finalPoint;
	}
	public static int getClickCount()
	{
		return clickCount;
	}
	public void setSpaces(ArrayList<JComponent> list)
	{
		spaces = list;
	}
	public static void setInitialPoint(int point)
	{
		initialPoint = point;
	}
	public static void setFinalPoint(int point)
	{
		finalPoint = point;
	}
	public static void setClickCount(int count)
	{
		clickCount = count;
	}
	public static void setColor(int index, Color color)
	{
		spaces.get(index).setBackground(color);
	}
	public static void removePiece(int index)
	{
		((JPanel)spaces.get(index)).removeAll();
	}
}