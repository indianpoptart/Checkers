package com.checkers.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.checkers.game.Checkers;
import com.checkers.game.Piece;

public class CheckerBoard
{
	private static ArrayList<JComponent> spaces = new ArrayList<JComponent>();
	private static JButton newGame, quit, theme;
	private static int initialPoint, finalPoint, clickCount, playerCount = 1;
	public CheckerBoard()
	{
		int row = 0;
		for (int i = 0; i < 64; i++)
		{
			JPanel panel = new JPanel();
			Piece piece = new Piece();
			piece.setHorizontalAlignment(Piece.CENTER);
			if (i % 2 == 0)
			{
				if (row % 2 == 0)
					panel.setBackground(Checkers.getSecondary());
				else
				{
					panel.setBackground(Checkers.getPrimary());
					if ((row >= 0) && (row < 3))
					{
						piece = new Piece(Color.white);
						piece.setOpaque(false);
						panel.add(piece);
					}
					else if (row > 4)
					{
						piece = new Piece(Color.black);
						panel.add(piece);
					}
					panel.addMouseListener(new MouseListener()
					{
						@Override public void mousePressed(MouseEvent me){Piece.move(me);}
						@Override public void mouseClicked(MouseEvent me){}
						@Override public void mouseEntered(MouseEvent me){}
						@Override public void mouseExited(MouseEvent me){}
						@Override public void mouseReleased(MouseEvent me){}
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
						piece = new Piece(Color.white);
						panel.add(piece);
					}
					else if (row > 4)
					{
						piece = new Piece(Color.black);
						panel.add(piece);
					}
					panel.addMouseListener(new MouseListener()
					{
						@Override public void mousePressed(MouseEvent me){Piece.move(me);}
						@Override public void mouseClicked(MouseEvent me){}
						@Override public void mouseEntered(MouseEvent me){}
						@Override public void mouseExited(MouseEvent me){}
						@Override public void mouseReleased(MouseEvent me){}
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
	public static void setToolBar()
	{
		JMenuBar toolbar = new JMenuBar();
		toolbar.setPreferredSize(new Dimension(550, 20));
		toolbar.setBackground(Checkers.getTertiary());
		JMenu file = new JMenu("File");
		file.setBackground(Checkers.getTertiary());
		file.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		newGame = new JButton("New Game");
		newGame.setBackground(Checkers.getTertiary());
		newGame.setBorderPainted(false);
		newGame.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		file.add(newGame);
		file.addSeparator();
		quit = new JButton("Quit          ");
		quit.setBackground(Checkers.getTertiary());
		quit.setBorderPainted(false);
		quit.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		file.add(quit);
		JMenu edit = new JMenu("Edit");
		edit.setBackground(Checkers.getTertiary());
		edit.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		theme = new JButton("Theme");
		theme.setBackground(Checkers.getTertiary());
		theme.setBorderPainted(false);
		theme.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		edit.add(theme);
		toolbar.add(file);
		toolbar.add(edit);
		for (int i = 0; i < 140; i++)
		{
			JLabel space = new JLabel(" ");
			toolbar.add(space);
		}
		JLabel player = new JLabel("Player " + playerCount);
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
				ImageIcon logo = new ImageIcon(Checkers.getIconSource());
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
					setClickCount(0);
					setPlayerCount(1);
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
				ImageIcon logo = new ImageIcon(Checkers.getIconSource());
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
					setClickCount(0);
					setPlayerCount(1);
					Checkers.getGUI().setJMenuBar(null);
					new MainMenu();
				}
			}
		});
		theme.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				Object[] choices = {"Orange and Black", "Classic", "Wood", "America", "Italy", "Violet", "Ocean", "Black and White"};
				UIManager.put("OptionPane.background", Checkers.getTertiary());
				UIManager.put("Panel.background", Checkers.getTertiary());
				UIManager.put("Button.background", Checkers.getPrimary());
				ImageIcon logo = new ImageIcon(Checkers.getIconSource());
				String opt = (String)JOptionPane.showInputDialog(null, "Please choose a theme", "Checkers", JOptionPane.QUESTION_MESSAGE, logo,  choices,  choices[0]);
				int choice = Arrays.asList(choices).indexOf(opt);
				if (choice == 0)
				{
					Checkers.setPrimary(new Color(255, 105, 0));
					Checkers.setSecondary(Color.black);
					Checkers.setPicSource("src/tigerLogo.png");
					Checkers.setIconSource("src/tigerArt.png");
				}
				else if (choice == 1)
				{
					Checkers.setPrimary(Color.black);
					Checkers.setSecondary(new Color(235, 0, 0));
					Checkers.setPicSource("src/checkersLogo.png");
					Checkers.setIconSource("src/checkersArt.png");
				}
				else if (choice == 2)
				{
					Checkers.setPrimary(new Color(198, 150, 73));
					Checkers.setSecondary(new Color(78, 46, 40));
					Checkers.setPicSource("src/checkersLogo.png");
					Checkers.setIconSource("src/checkersArt.png");
				}
				else if (choice == 3)
				{
					Checkers.setPrimary(new Color(0, 82, 165));
					Checkers.setSecondary(new Color(224, 22, 43));
					Checkers.setPicSource("src/uncleSamLogo.png");
					Checkers.setIconSource("src/americanFlagArt.png");
				}
				else if (choice == 4)
				{
					Checkers.setPrimary(new Color(234, 0, 0));
					Checkers.setSecondary(new Color(12, 120, 13));
					Checkers.setPicSource("src/italianLogo.png");
					Checkers.setIconSource("src/italianFlagArt.png");
				}
				else if (choice == 5)
				{
					Checkers.setPrimary(new Color(160, 0, 255));
					Checkers.setSecondary(new Color(50, 0, 50));
					Checkers.setPicSource("src/violetLogo.png");
					Checkers.setIconSource("src/violetArt.png");
				}
				else if (choice == 6)
				{
					Checkers.setPrimary(new Color(109, 211, 170));
					Checkers.setSecondary(new Color(198, 150, 73));
					Checkers.setPicSource("src/palmTreeLogo.png");
					Checkers.setIconSource("src/beachBallArt.png");
				}
				else if (choice == 7)
				{
					Checkers.setPrimary(Color.white);
					Checkers.setSecondary(Color.black);
					Checkers.setPicSource("src/checkersLogo.png");
					Checkers.setIconSource("src/checkersArt.png");
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
				try 
				{
					Checkers.setPic(ImageIO.read(new File(Checkers.getPicSource())));
					Checkers.setIcon(ImageIO.read(new File(Checkers.getIconSource())));
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				Checkers.getGUI().setIconImage(Checkers.getPic());
				new ExportSettings();
			}
		});
		Checkers.getGUI().setVisible(true);
	}
	public static void setToolBar(String text)
	{
		JMenuBar toolbar = new JMenuBar();
		toolbar.setPreferredSize(new Dimension(550, 20));
		toolbar.setBackground(Checkers.getTertiary());
		JMenu file = new JMenu("File");
		file.setBackground(Checkers.getTertiary());
		file.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		newGame = new JButton("New Game");
		newGame.setBackground(Checkers.getTertiary());
		newGame.setBorderPainted(false);
		newGame.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		file.add(newGame);
		file.addSeparator();
		quit = new JButton("Quit          ");
		quit.setBackground(Checkers.getTertiary());
		quit.setBorderPainted(false);
		quit.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		file.add(quit);
		JMenu edit = new JMenu("Edit");
		edit.setBackground(Checkers.getTertiary());
		edit.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		theme = new JButton("Theme");
		theme.setBackground(Checkers.getTertiary());
		theme.setBorderPainted(false);
		theme.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		edit.add(theme);
		toolbar.add(file);
		toolbar.add(edit);
		for (int i = 0; i < 129; i++)
		{
			JLabel space = new JLabel(" ");
			toolbar.add(space);
		}
		JLabel player = new JLabel(text);
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
				ImageIcon logo = new ImageIcon(Checkers.getIconSource());
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
					setClickCount(0);
					setPlayerCount(1);
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
				ImageIcon logo = new ImageIcon(Checkers.getIconSource());
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
					setClickCount(0);
					setPlayerCount(1);
					Checkers.getGUI().setJMenuBar(null);
					new MainMenu();
				}
			}
		});
		theme.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				Object[] choices = {"Orange and Black", "Classic", "Wood", "America", "Italy", "Violet", "Ocean", "Black and White"};
				UIManager.put("OptionPane.background", Checkers.getTertiary());
				UIManager.put("Panel.background", Checkers.getTertiary());
				UIManager.put("Button.background", Checkers.getPrimary());
				ImageIcon logo = new ImageIcon(Checkers.getIconSource());
				String opt = (String)JOptionPane.showInputDialog(null, "Please choose a theme", "Checkers", JOptionPane.QUESTION_MESSAGE, logo,  choices,  choices[0]);
				int choice = Arrays.asList(choices).indexOf(opt);
				if (choice == 0)
				{
					Checkers.setPrimary(new Color(255, 105, 0));
					Checkers.setSecondary(Color.black);
					Checkers.setPicSource("src/tigerLogo.png");
					Checkers.setIconSource("src/tigerArt.png");
				}
				else if (choice == 1)
				{
					Checkers.setPrimary(Color.black);
					Checkers.setSecondary(new Color(235, 0, 0));
					Checkers.setPicSource("src/checkersLogo.png");
					Checkers.setIconSource("src/checkersArt.png");
				}
				else if (choice == 2)
				{
					Checkers.setPrimary(new Color(198, 150, 73));
					Checkers.setSecondary(new Color(78, 46, 40));
					Checkers.setPicSource("src/checkersLogo.png");
					Checkers.setIconSource("src/checkersArt.png");
				}
				else if (choice == 3)
				{
					Checkers.setPrimary(new Color(0, 82, 165));
					Checkers.setSecondary(new Color(224, 22, 43));
					Checkers.setPicSource("src/uncleSamLogo.png");
					Checkers.setIconSource("src/americanFlagArt.png");
				}
				else if (choice == 4)
				{
					Checkers.setPrimary(new Color(234, 0, 0));
					Checkers.setSecondary(new Color(12, 120, 13));
					Checkers.setPicSource("src/italianLogo.png");
					Checkers.setIconSource("src/italianFlagArt.png");
				}
				else if (choice == 5)
				{
					Checkers.setPrimary(new Color(160, 0, 255));
					Checkers.setSecondary(new Color(50, 0, 50));
					Checkers.setPicSource("src/violetLogo.png");
					Checkers.setIconSource("src/violetArt.png");
				}
				else if (choice == 6)
				{
					Checkers.setPrimary(new Color(109, 211, 170));
					Checkers.setSecondary(new Color(198, 150, 73));
					Checkers.setPicSource("src/palmTreeLogo.png");
					Checkers.setIconSource("src/beachBallArt.png");
				}
				else if (choice == 7)
				{
					Checkers.setPrimary(Color.white);
					Checkers.setSecondary(Color.black);
					Checkers.setPicSource("src/checkersLogo.png");
					Checkers.setIconSource("src/checkersArt.png");
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
				try 
				{
					Checkers.setPic(ImageIO.read(new File(Checkers.getPicSource())));
					Checkers.setIcon(ImageIO.read(new File(Checkers.getIconSource())));
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				Checkers.getGUI().setIconImage(Checkers.getPic());
				new ExportSettings();
			}
		});
		Checkers.getGUI().setVisible(true);
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

		setToolBar();

		Checkers.getGUI().setVisible(true);
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
	public static int getPlayerCount()
	{
		return playerCount;
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
	public static void setPlayerCount(int count)
	{
		playerCount = count;
	}
	public static void setColor(int index, Color color)
	{
		spaces.get(index).setBackground(color);
	}
}