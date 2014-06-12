package com.checkers.game;

import java.awt.Color;
import java.awt.Container;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.checkers.gui.*;

public class Checkers 
{
	private static JFrame GUI = new JFrame();
	private static Container pane = new Container();
	private static JButton b1, b2, b3;
	private static BufferedImage pic, icon;
	private static String picSource, iconSource;
	private static Color primary, secondary, tertiary;
	final private static int[][] points = {{9, 76, 143, 210, 277, 344, 411, 478}, {51, 116, 181, 246, 311, 376, 441, 506}};
	public static void main(String[] args)
	{
		new ImportSettings();
		new MainMenu();
		new PlayMusic("src/theFinalCountdown.wav").run();
	}
	public static JFrame getGUI()
	{
		return GUI;
	}
	public static Container getPane()
	{
		return pane;
	}
	public static Color getPrimary()
	{
		return primary;
	}
	public static Color getSecondary()
	{
		return secondary;
	}
	public static Color getTertiary()
	{
		return tertiary;
	}
	public static int[][] getPoints()
	{
		return points;
	}
	public static JButton getB1()
	{
		return b1;
	}
	public static JButton getB2()
	{
		return b2;
	}
	public static JButton getB3()
	{
		return b3;
	}
	public static BufferedImage getPic()
	{
		return pic;
	}
	public static BufferedImage getIcon()
	{
		return icon;
	}
	public static String getPicSource()
	{
		return picSource;
	}
	public static String getIconSource()
	{
		return iconSource;
	}
	public static void setPrimary(Color color)
	{
		primary = color;
	}
	public static void setSecondary(Color color)
	{
		secondary = color;
	}
	public static void setTertiary(Color color)
	{
		tertiary = color;
	}
	public static void setB1(JButton button)
	{
		b1 = button;
	}
	public static void setB2(JButton button)
	{
		b2 = button;
	}
	public static void setB3(JButton button)
	{
		b3 = button;
	}
	public static void setPic(BufferedImage image)
	{
		pic = image;
	}
	public static void setIcon(BufferedImage image)
	{
		icon = image;
	}
	public static void setPicSource(String source)
	{
		picSource = source;
	}
	public static void setIconSource(String source)
	{
		iconSource = source;
	}
	public static void resetPane()
	{
		while (CheckerBoard.getSpaces().size() > 0)
			Checkers.getPane().add(CheckerBoard.getSpaces().remove(0));
		Checkers.getGUI().setContentPane(Checkers.getPane());
		Checkers.getGUI().setVisible(true);
	}
}