package com.checkers.main;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.checkers.game.Rules;
import com.checkers.gui.CheckerBoard;


/* 
 * RunCheckers Game:
 * 
 * RunCheckers Class
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
public class Checkers
{
	private static JFrame GUI = new JFrame();
	private static Container pane = new Container();
	private static JButton b1, b2, b3;
	private static BufferedImage pic;
	public static CheckerBoard board;
	final public static int[][] points = {{1, 68, 135, 202, 269, 336, 403, 470}, {2, 66, 130, 194, 258, 322, 386, 450}};
	public static void main(String[] args)
	{
		mainMenu();
		b1.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				showBoard();
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
						if (CheckerBoard.clickCount % 2 == 0)
						{
							CheckerBoard.initialPoint = me.getLocationOnScreen();
							System.out.println("Selected Point: " + CheckerBoard.initialPoint);
						}
						else if (CheckerBoard.clickCount % 2 == 1)
						{
							CheckerBoard.finalPoint = me.getLocationOnScreen();
							move();
							
							
							//							if ((CheckerBoard.initialPoint.getX() != me.getComponent().getLocation().getX()) && (CheckerBoard.initialPoint.getY() != me.getComponent().getLocation().getY()))
							//							{
							//								CheckerBoard.finalPoint = me.getComponent().getLocation();
							//								int startLoc = 0;
							//								for (int i = 0; i < 8; i++)
							//								{
							//									for (int j = 0; j < 8; j++)
							//									{
							//										if ((Checkers.points[0][i] == CheckerBoard.initialPoint.getX()) && (Checkers.points[1][j] == CheckerBoard.initialPoint.getY()))
							//										{
							//											startLoc = (j * 8) + i;
							//										}
							//									}
							//								}
							//								int endLoc = 0;
							//								for (int x = 0; x < 8; x++)
							//								{
							//									for (int y = 0; y < 8; y++)
							//									{
							//										if ((Checkers.points[0][x] == CheckerBoard.finalPoint.getX()) && (Checkers.points[1][y] == CheckerBoard.finalPoint.getY()))
							//										{
							//											endLoc = (y * 8) + x;
							//											CheckerBoard.spaces.set(endLoc, CheckerBoard.spaces.get(startLoc));
							//											JPanel panel1 = new JPanel();
							//											panel1.setBackground(new Color(255, 105, 0));
							//											CheckerBoard.spaces.set(startLoc, panel1);
							//										}
							//									}
						}
						else 
						{
							CheckerBoard.initialPoint = null;
							CheckerBoard.finalPoint = null;
						}
						CheckerBoard.clickCount++;
					}
					@Override public void mouseClicked(MouseEvent me) 
					{
					}
					@Override public void mouseEntered(MouseEvent me)
					{
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
				Rules r = new Rules();
				r.getRules();
			}
		});
	}
	public static void mainMenu()
	{
		GUI.setTitle("RHS Checkers");
		GUI.setPreferredSize(new Dimension(550, 570));
		pane.removeAll();
		try 
		{
			pic = ImageIO.read(new File("res/icon.png"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		GUI.setIconImage(pic);
		GUI.setBackground(Color.WHITE);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane.setLayout(new GridLayout(9, 3, 5, 5));
		for (int i = 0; i < 27; i++)
		{
			JComponent panel = new JPanel();
			if (i == 1)
			{
				panel = new JPanel();
				panel.setBackground(new Color(255, 105, 0));
				JLabel label = new JLabel("Play Checkers!");
				label.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 25));
				panel.add(label); 
			}
			else if (i == 7)
			{
				panel = new JButton("One Player");
				panel.setBackground(new Color(255, 105, 0));
				panel.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
				b1 = (JButton)panel;
			}
			else if (i == 13)
			{
				panel = new JButton("Two Player");
				panel.setBackground(new Color(255, 105, 0));
				panel.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
				b2 = (JButton)panel;
			}
			else if(i == 19)
			{
				Rules r = new Rules();
				panel = new JButton("Rules");
				panel.setBackground(new Color(255, 105, 0));
				panel.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
				b3 = (JButton)panel;
			}
			else if ((i == 3) || (i == 5) || (i == 9) || (i == 11) || (i == 15) || (i == 17) || (i == 21) || (i == 23) || (i == 25))
			{
				panel = new JPanel();
				panel.setBackground(new Color(255, 105, 0));
			}
			else
			{
				panel = new JPanel();
				panel.setBackground(Color.BLACK);
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
		ArrayList<JComponent> tempList = CheckerBoard.spaces;
		while (CheckerBoard.spaces.size() > 0)
			pane.add(CheckerBoard.spaces.remove(0));
		CheckerBoard.spaces = tempList;
		pane.setPreferredSize(new Dimension(550, 550));
		GUI.setContentPane(pane);

		JMenuBar toolbar = new JMenuBar();
		toolbar.setPreferredSize(new Dimension(550, 20));
		toolbar.setBackground(Color.WHITE);
		JMenu file = new JMenu("File");
		file.setBackground(Color.WHITE);
		file.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		JButton quit = new JButton("Quit");
		quit.setBackground(Color.WHITE);
		quit.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		file.add(quit);
		JMenu edit = new JMenu("Edit");
		edit.setBackground(Color.WHITE);
		edit.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		JButton colorScheme = new JButton("Color Scheme");
		colorScheme.setBackground(Color.WHITE);
		colorScheme.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 12));
		edit.add(colorScheme);
		toolbar.add(file);
		toolbar.add(edit);
		GUI.setJMenuBar(toolbar);

		quit.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				Object[] options = {"Yes", "No"};
				UIManager.put("OptionPane.background", Color.WHITE);
				UIManager.put("Panel.background", Color.WHITE);
				UIManager.put("Button.background", new Color(255, 105, 0));
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
					main(new String[0]);
				}
			}
		});
		colorScheme.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				Object[] choices = {"Orange and Black", "Red, White, and Blue"};
				UIManager.put("OptionPane.background", Color.WHITE);
				UIManager.put("Panel.background", Color.WHITE);
				UIManager.put("Button.background", new Color(255, 105, 0));
				ImageIcon logo = new ImageIcon("src/tigerArt.png");
				int choice = JOptionPane.showInternalOptionDialog(null, "Choose a color scheme", "RHS Checkers", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, logo, choices, choices[0]);
				if (choice == 0)
				{

				}
			}
		});
		GUI.setVisible(true);
	}
	public static void move()
	{
		int startLoc = 0;
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if ((Checkers.points[0][i] == CheckerBoard.initialPoint.getX()) && (Checkers.points[1][j] == CheckerBoard.initialPoint.getY()))
				{
					startLoc = (j * 8) + i;
				}
			}
		}
		JComponent initial = CheckerBoard.spaces.get(startLoc);
		int endLoc = 0;
		for (int x = 0; x < 8; x++)
		{
			for (int y = 0; y < 8; y++)
			{
				if ((Checkers.points[0][x] == CheckerBoard.finalPoint.getX()) && (Checkers.points[1][y] == CheckerBoard.finalPoint.getY()))
				{
					endLoc = (y * 8) + x;
					//					CheckerBoard.spaces.set(endLoc, CheckerBoard.spaces.get(startLoc));
					//					JPanel panel1 = new JPanel();
					//					panel1.setBackground(new Color(255, 105, 0));
					//					CheckerBoard.spaces.set(startLoc, panel1);
				}
			}
		}
		JComponent end = CheckerBoard.spaces.get(endLoc);
		CheckerBoard.spaces.set(endLoc, initial);
		CheckerBoard.spaces.set(startLoc, end);
		pane.removeAll();
		GUI.setLayout(new GridLayout(8, 8, 5, 5));
		while (CheckerBoard.spaces.size() > 0)
			pane.add(CheckerBoard.spaces.remove(0));
		pane.setPreferredSize(new Dimension(550, 550));
		GUI.setContentPane(pane);
		//		for (int i = 0; i < 8; i++)
		//		{
		//			JPanel panel = new JPanel();
		//			if (i % 2 == 0)
		//			{
		//				panel.setBackground(Color.BLACK);
		//			}
		//			else
		//			{
		//				panel.setBackground(new Color(255, 105, 0));
		//			}
		//			panel.addMouseListener(new MouseAdapter()
		//			{
		//				@Override public void mousePressed(MouseEvent me)
		//				{
		//					if (CheckerBoard.clickCount % 2 == 0)
		//					{
		//						CheckerBoard.initialPanel = (JPanel)me.getComponent();
		//						CheckerBoard.initialPoint = CheckerBoard.initialPanel.getLocation();
		//						System.out.println("Selected Point: " + CheckerBoard.initialPoint);
		//					}
		//					else
		//					{
		//						if ((CheckerBoard.initialPoint.getX() != me.getComponent().getLocation().getX()) && (CheckerBoard.initialPoint.getY() != me.getComponent().getLocation().getY()))
		//						{
		//							CheckerBoard.finalPoint = me.getComponent().getLocation();
		//							int startLoc = 0;
		//							for (int i = 0; i < 8; i++)
		//							{
		//								for (int j = 0; j < 8; j++)
		//								{
		//									if ((points[0][i] == CheckerBoard.initialPoint.getX()) && (points[1][j] == CheckerBoard.initialPoint.getY()))
		//									{
		//										startLoc = (j * 8) + i;
		//									}
		//								}
		//							}
		//							int endLoc = 0;
		//							for (int x = 0; x < 8; x++)
		//							{
		//								for (int y = 0; y < 8; y++)
		//								{
		//									if ((points[0][x] == CheckerBoard.finalPoint.getX()) && (points[1][y] == CheckerBoard.finalPoint.getY()))
		//									{
		//										endLoc = (y * 8) + x;
		//										CheckerBoard.spaces.set(endLoc, CheckerBoard.spaces.get(startLoc));
		//										CheckerBoard.spaces.set(startLoc, null);
		//									}
		//								}
		//							}
		//							Checkers.showBoard();
		//						}
		//						else
		//						{
		//							System.out.println("Point Deselected: " + CheckerBoard.initialPoint);
		//						}
		//					}
		//					CheckerBoard.clickCount++;
		//				}
		//			});
		//			CheckerBoard.spaces.add(panel);
		//		}
		//		for (int i = 8; i < 64; i++)
		//		{
		//			CheckerBoard.spaces.add((JComponent)pane.getComponent(i));
		//		}
	}
}