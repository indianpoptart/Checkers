package com.checkers.main;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.checkers.game.Rules;
import com.checkers.gui.Board;

public class RunCheckers {
	private static JFrame GUI = new JFrame();
	private static Container pane = GUI.getContentPane();
	private static ArrayList<JComponent> spaces = new ArrayList<JComponent>();
	public static void main(String[] args)
	{
		Rules r = new Rules();
		r.getRules();
		mainMenu();
		//if (pane.getComponent(n)
		{

		}
		Board board = new Board();
		board.showGrid();
	}
	public static void mainMenu()
	{
		GUI.setTitle("Checkers");
		GUI.setSize(550, 550);
		//GUI.setIconImage("res/red.png");
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane.setLayout(new GridLayout(5, 3));
		for (int i = 0; i < 15; i++)
		{
			JComponent panel = new JPanel();
			if (i == 4)
			{
				panel = new JButton("Two Player");
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
		GUI.setVisible(true);
	}
}
