package com.checkers.main;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.checkers.game.Rules;
import com.checkers.gui.Board;

public class RunCheckers
{
	private static JFrame GUI = new JFrame();
	private static Container pane = GUI.getContentPane();
	private static ArrayList<JComponent> spaces = new ArrayList<JComponent>();
	private static Board board;
	private static BufferedImage pic;
	private static JComponent piece;
	private static JButton b2;
	public static void main(String[] args)
	{
		GUI.setTitle("RHS Checkers");
		GUI.setSize(550, 550);
		try 
		{
			pic = ImageIO.read(new File("res/icon.png"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		GUI.setIconImage(pic);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane.setLayout(new GridLayout(9, 3));
		for (int i = 0; i < 27; i++)
		{
			JComponent panel = new JPanel();
			if (i == 1)
			{
				panel = new JLabel(" | | | | | | | Play Checkers! | | | | | | |");
				((JLabel)panel).setHorizontalAlignment(SwingConstants.CENTER); 
				panel.setBackground(new Color(255, 105, 0));
			}
			else if (i == 7)
			{
				panel = new JButton("One Player");
				panel.setBackground(new Color(255, 105, 0));
			}
			else if (i == 13)
			{
				panel = new JButton("Two Player");
				panel.setBackground(new Color(255, 105, 0));
				b2
				= (JButton)panel;
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
		GUI.setVisible(true);
		b2.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event) 
			{
				JButton button = (JButton)event.getSource();
				button.setText("Setting Up!");
				board = new Board();
				addBoard();
			}
		});
	}
	public static void addBoard()
	{
		Container container = board.getPane();
		pane = container;
	}
}