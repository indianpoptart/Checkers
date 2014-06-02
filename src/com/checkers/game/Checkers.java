package com.checkers.game;

import com.checkers.gui.CheckerBoard;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * This panel lets two users play checkers against each other.
 * Red always starts the game.  If a player can jump an opponent's
 * piece, then the player must jump.  When a player can make no more
 * moves, the game ends.
 * 
 * The class has a main() routine that lets it be run as a stand-alone
 * application.  The application just opens a window that uses an object
 * of type Checkers as its content pane.
 * 
 * There is also a nested class, Checker.Applet, that can be used
 * as an applet version of the program.  The applet size should be 
 * 350-by-250 (or very close to that).
 * 
 */
public class Checkers
{
	private static JFrame GUI = new JFrame();
	private static Container pane = new Container();
	private static JButton b1, b2, b3;
	private static BufferedImage pic;
	public static CheckerBoard board;
	public static Color primary, secondary, tertiary;
	final public static int[][] points = {{1, 62, 68, 129, 135, 196, 202, 264, 269, 331, 336, 397, 403, 465, 470, 532}, {2, 61, 66, 124, 130, 189, 194, 252, 258, 316, 322, 381, 386, 445, 450, 508}};
	public static void main(String[] args)
	{
		new Checkers();
		mainMenu();
		b1.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				showBoard();
				pane.addMouseListener(new MouseListener()
				{
					@Override public void mousePressed(MouseEvent me)
					{
						move(me);
					}
					@Override public void mouseClicked(MouseEvent arg0) 
					{
					}
					@Override public void mouseEntered(MouseEvent arg0) 
					{
						if (pane.getMouseListeners().length > 1)
						{
							pane.removeMouseListener(pane.getMouseListeners()[0]);
						}
					}
					@Override public void mouseExited(MouseEvent arg0) 
					{
					}
					@Override public void mouseReleased(MouseEvent arg0)
					{
					}
				});
			}
		});
		b2.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event) 
			{
				showBoard();
				pane.addMouseListener(new MouseListener()
				{
					@Override public void mousePressed(MouseEvent me) 
					{
						move(me);
					}
					@Override public void mouseClicked(MouseEvent me) 
					{
					}
					@Override public void mouseEntered(MouseEvent me)
					{
						if (pane.getMouseListeners().length > 1)
						{
							pane.removeMouseListener(pane.getMouseListeners()[0]);
						}
					}
					@Override public void mouseExited(MouseEvent me) 
					{
					}
					@Override public void mouseReleased(MouseEvent me) 
					{	
					}
				});
			}
		});
		b3.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				showBoard();
				pane.addMouseListener(new MouseListener()
				{
					@Override public void mousePressed(MouseEvent me)
					{
						move(me);
					}
					@Override public void mouseClicked(MouseEvent arg0)
					{
					}
					@Override public void mouseEntered(MouseEvent arg0) 
					{
						if (pane.getMouseListeners().length > 1)
						{
							pane.removeMouseListener(pane.getMouseListeners()[0]);
						}
					}
					@Override public void mouseExited(MouseEvent arg0)
					{
					}
					@Override public void mouseReleased(MouseEvent arg0) 
					{
					}
				});
			}
		});
	}
	public Checkers()
	{
		GUI.setTitle("RHS Checkers");
		GUI.setPreferredSize(new Dimension(550, 570));
		try 
		{
			pic = ImageIO.read(new File("res/icon.png"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		GUI.setIconImage(pic);
		GUI.setBackground(tertiary);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FileReader fileReader = null;
		try
		{
			fileReader = new FileReader("res/settings.txt");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(fileReader);
		try 
		{
			Scanner pri = new Scanner(reader.readLine());
			pri.useDelimiter("\\D+");
			primary = new Color(pri.nextInt(), pri.nextInt(), pri.nextInt());
			pri.close();
			Scanner sec = new Scanner(reader.readLine());
			sec.useDelimiter("\\D+");
			secondary = new Color(sec.nextInt(), sec.nextInt(), sec.nextInt());
			sec.close();
			Scanner ter = new Scanner(reader.readLine());
			ter.useDelimiter("\\D+");
			tertiary = new Color(ter.nextInt(), ter.nextInt(), ter.nextInt());
			ter.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		b1 = new JButton("One Player");
		b1.setBackground(primary);
		b1.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
		b2 = new JButton("Two Player");
		b2.setBackground(primary);
		b2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
		b3 = new JButton("Extra");
		b3.setBackground(primary);
		b3.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
	}
	public static void mainMenu()
	{
		while (CheckerBoard.spaces.size() > 0)
			CheckerBoard.spaces.remove(0);
		pane.removeAll();
		pane.setLayout(new GridLayout(9, 3, 5, 5));
		for (int i = 0; i < 27; i++)
		{
			JComponent panel = new JPanel();
			if (i == 1)
			{
				panel = new JPanel();
				panel.setBackground(primary);
				JLabel label = new JLabel("Play Checkers!");
				label.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 25));
				panel.add(label); 
			}
			else if (i == 7)
			{
				panel = b1;
			}
			else if (i == 13)
			{
				panel = b2;
			}
			else if(i == 19)
			{
				panel = b3;
			}
			else if ((i == 3) || (i == 5) || (i == 9) || (i == 11) || (i == 15) || (i == 17) || (i == 21) || (i == 23) || (i == 25))
			{
				panel = new JPanel();
				panel.setBackground(primary);
			}
			else
			{
				panel = new JPanel();
				panel.setBackground(secondary);
			}
			CheckerBoard.spaces.add(panel);
		}
		while (CheckerBoard.spaces.size() > 0)
			pane.add(CheckerBoard.spaces.remove(0));
		GUI.setContentPane(pane);
		GUI.pack();
		GUI.setVisible(true);
	}
	public static void showBoard()
	{
		board = new CheckerBoard();
		pane.removeAll();
		GUI.setLayout(new GridLayout(8, 8, 5, 5));
		for (int i = 0; i < 64; i++)
		{
			pane.add(CheckerBoard.spaces.get(i));
		}
		pane.setPreferredSize(new Dimension(550, 550));
		GUI.setContentPane(pane);

		JMenuBar toolbar = new JMenuBar();
		toolbar.setPreferredSize(new Dimension(550, 20));
		toolbar.setBackground(tertiary);
		JMenu file = new JMenu("File");
		file.setBackground(tertiary);
		file.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		JButton newGame = new JButton("New Game");
		newGame.setBackground(tertiary);
		newGame.setBorderPainted(false);
		newGame.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		file.add(newGame);
		file.addSeparator();
		JButton quit = new JButton("     Quit     ");
		quit.setBackground(tertiary);
		quit.setBorderPainted(false);
		quit.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		file.add(quit);
		JMenu edit = new JMenu("Edit");
		edit.setBackground(tertiary);
		edit.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		JButton colorScheme = new JButton("Color Scheme");
		colorScheme.setBackground(tertiary);
		colorScheme.setBorderPainted(false);
		colorScheme.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		edit.add(colorScheme);
		toolbar.add(file);
		toolbar.add(edit);
		GUI.setJMenuBar(toolbar);

		newGame.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				Object[] options = {"Yes", "No"};
				UIManager.put("OptionPane.background", tertiary);
				UIManager.put("Panel.background", tertiary);
				UIManager.put("Button.background", primary);
				UIManager.put("Button.font", new Font("Times New Roman", Font.CENTER_BASELINE, 12));
				ImageIcon logo = new ImageIcon("src/tigerArt.png");
				int choice = JOptionPane.showOptionDialog(null, "Are you sure you want to restart?", "RHS Checkers", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, logo, options, options[1]);
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
					mainMenu();
					showBoard();
				}
			}
		});
		quit.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				Object[] options = {"Yes", "No"};
				UIManager.put("OptionPane.background", tertiary);
				UIManager.put("Panel.background", tertiary);
				UIManager.put("Button.background", primary);
				UIManager.put("Button.font", new Font("Times New Roman", Font.CENTER_BASELINE, 12));
				ImageIcon logo = new ImageIcon("src/tigerArt.png");
				int choice = JOptionPane.showOptionDialog(null, "Are you sure you want to quit?", "RHS Checkers", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, logo, options, options[1]);
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
					GUI.setJMenuBar(null);
					mainMenu();
				}
			}
		});
		colorScheme.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				Object[] choices = {"Orange and Black", "Classic", "Wood", "America", "Italy", "Violet", "Ocean", "Black and White", "Black and Yellow"};
				UIManager.put("OptionPane.background", tertiary);
				UIManager.put("Panel.background", tertiary);
				UIManager.put("Button.background", primary);
				ImageIcon logo = new ImageIcon("src/tigerArt.png");
				String opt = (String)JOptionPane.showInputDialog(null, "Please choose a color scheme", "RHS Checkers", JOptionPane.QUESTION_MESSAGE, logo,  choices,  choices[0]);
				int choice = Arrays.asList(choices).indexOf(opt);
				if (choice == 0)
				{
					primary = new Color(255, 105, 0);
					secondary = Color.black;
				}
				else if (choice == 1)
				{
					primary = Color.red;
					secondary = Color.black;
				}
				else if (choice == 2)
				{
					primary = new Color(198, 150, 73);
					secondary = new Color(78, 46, 40);
				}
				else if (choice == 3)
				{
					primary = new Color(0, 82, 165);
					secondary = new Color(224, 22, 43);
				}
				else if (choice == 4)
				{
					primary = new Color(234, 0, 0);
					secondary = new Color(12, 120, 13);
				}
				else if (choice == 5)
				{
					primary = new Color(160, 0, 255);
					secondary = new Color(50, 0, 50);
				}
				else if (choice == 6)
				{
					primary = new Color(109, 211, 170);
					secondary = new Color(198, 150, 73);
				}
				else if (choice == 7)
				{
					primary = Color.white;
					secondary = Color.black;
				}
				else if (choice == 8)
				{
					primary = new Color(255, 200, 0);
					secondary = Color.black;
				}
				int row = 0;
				for (int i = 0; i < 64; i++)
				{
					if (i % 2 == 0)
					{
						if (row % 2 == 0)
							CheckerBoard.setColor(i, secondary);
						else
							CheckerBoard.setColor(i, primary);
					}
					else
					{
						if (row % 2 == 0)
							CheckerBoard.setColor(i, primary);
						else
							CheckerBoard.setColor(i, secondary);
					}
					if (i % 8 == 7)
						row++;
				}
				b1.setBackground(primary);
				b2.setBackground(primary);
				b3.setBackground(primary);
				String settings = primary.toString() +  "\n" + secondary.toString() + "\n" + tertiary.toString();
				BufferedWriter writer;
				try
				{
					writer = new BufferedWriter(new FileWriter("src/settings.txt"));
					writer.write(settings);
					writer.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		});
		GUI.setVisible(true);
	}
	public static void move(MouseEvent me)
	{
		if (CheckerBoard.clickCount % 2 == 0)
		{
			Point initialPoint = me.getPoint();
			for (int i = 0; i < 16; i = i + 2)
				for (int j = 0; j < 16; j = j + 2)
					if ((initialPoint.getX() >= points[0][i]) && (points[0][i + 1] >= initialPoint.getX()) && (initialPoint.getY() >= points[1][j]) && (points[1][j + 1] >= initialPoint.getY()))
						CheckerBoard.initialPoint = j * 4 + i / 2;
			CheckerBoard.setColor(CheckerBoard.initialPoint, tertiary);
			pane.removeAll();
			for (int a = 0; a < 64; a++)
				pane.add(CheckerBoard.spaces.get(a));
			GUI.setContentPane(pane);
		}
		else
		{
			Point finalPoint = me.getPoint();
			for (int i = 0; i < 16; i = i + 2)
				for (int j = 0; j < 16; j = j + 2)
					if ((finalPoint.getX() >= points[0][i]) && (points[0][i + 1] >= finalPoint.getX()) && (finalPoint.getY() >= points[1][j]) && (points[1][j + 1] >= finalPoint.getY()))
						CheckerBoard.finalPoint = j * 4 + i / 2;
			JPanel initial = (JPanel)CheckerBoard.spaces.get(CheckerBoard.initialPoint);
			JPanel end = (JPanel)CheckerBoard.spaces.get(CheckerBoard.finalPoint);
			CheckerBoard.spaces.set(CheckerBoard.finalPoint, initial);
			CheckerBoard.spaces.set(CheckerBoard.initialPoint, end);
			pane.removeAll();
			for (int i = 0; i < 64; i++)
				pane.add(CheckerBoard.spaces.get(i));
			GUI.setContentPane(pane);
			CheckerBoard.setColor(CheckerBoard.finalPoint, primary);
		}
		CheckerBoard.clickCount++;
	}
}