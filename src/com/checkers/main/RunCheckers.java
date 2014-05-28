package com.checkers.main;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.checkers.game.Rules;
import com.checkers.gui.Board;


/* 
 * Checkers Game:
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
 * @author Brian Maguire
 * @author Michael Search
 */
public class RunCheckers extends MouseAdapter
{
	private static JFrame GUI = new JFrame();
	private static Container pane = new Container();
	private static ArrayList<JComponent> spaces = new ArrayList<JComponent>();
	private static BufferedImage pic;
	private static JButton b1;
	private static JButton b2;
	private static JButton b3;
	private static Board board;
	private static JComponent p;
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
				//move(46, 39);
				p.addMouseListener(new MouseListener()
				{
					private Point initialLoc;
					private Point initialLocOnScreen;
					@Override public void mouseClicked(MouseEvent me)
					{
						System.out.println("Click");
					}
					@Override public void mouseEntered(MouseEvent me)
					{
						System.out.println("Enter");
					}
					@Override public void mouseExited(MouseEvent me)
					{
						System.out.println("Exit");
					}
					//					public void mouseDragged(MouseEvent me)
					//					{
					//						Component comp = (Component)me.getSource();
					//						Point locOnScreen = me.getLocationOnScreen();
					//
					//						int x = locOnScreen.x - initialLocOnScreen.x + initialLoc.x;
					//						int y = locOnScreen.y - initialLocOnScreen.y + initialLoc.y;
					//						comp.setLocation(x, y);
					//					}
					@Override public void mousePressed(MouseEvent me)
					{
						System.out.println("Press");
						Component comp = (Component)me.getSource();
						initialLoc = comp.getLocation();
						initialLocOnScreen = me.getLocationOnScreen();
					}
					@Override public void mouseReleased(MouseEvent me)
					{
						System.out.println("Release");
						Component comp = (Component)me.getSource();
						Point locOnScreen = me.getLocationOnScreen();

						int x = locOnScreen.x - initialLocOnScreen.x + initialLoc.x;
						int y = locOnScreen.y - initialLocOnScreen.y + initialLoc.y;
						comp.setLocation(x, y);
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
		pane.removeAll();
		GUI.setTitle("RHS Checkers");
		GUI.setPreferredSize(new Dimension(550, 570));
		try 
		{
			pic = ImageIO.read(new File("res/tiger.png"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		GUI.setIconImage(pic);
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
			spaces.add(panel);
		}
		ArrayList<JComponent> list = spaces;
		while (spaces.size() > 0)
			pane.add(spaces.remove(0));
		spaces = list;
		GUI.setContentPane(pane);
		GUI.pack();
		GUI.setVisible(true);
	}
	public static void showBoard()
	{
		board = new Board();
		pane.removeAll();
		GUI.setLayout(new GridLayout(8, 8, 5, 5));
		spaces = board.getPane();
		while (spaces.size() > 0)
			pane.add(spaces.remove(0));
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

			}
		});
		GUI.setVisible(true);
	}
	//	public static void move(int start, int end)
	//	{
	//		Component comp = pane.getComponent(start);
	//		pane.add(comp, end);
	//		pane.remove(end + 1);

	public static void move(int start, int end)
	{
//		ArrayList<JPanel> list = spaces;
//		JPanel panel = spaces.get((int)((start.getX() - 1) + start.getY()));
//		panel.getComponent(0);
//		spaces.set((int)((end.getX() - 1) * (end.getY())), panel);
//		pane = GUI.getContentPane();
//		pane.setLayout(new GridLayout(8, 8, 5, 5));
//		while (spaces.size() > 0)
//			pane.add(spaces.remove(0));
//		spaces = list;
		Point p = new Point();
		p.setLocation(end / 8, end % 8);
		pane.getComponent(start).setLocation(p);
		
	}
}