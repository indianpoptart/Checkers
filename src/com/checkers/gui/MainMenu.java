package com.checkers.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.checkers.game.*;

public class MainMenu 
{
	public MainMenu()
	{
		
		Checkers.getGUI().setTitle("Checkers");
		Checkers.getGUI().setResizable(false);
		Checkers.getGUI().setBounds(5, 5, 540, 565);
		Checkers.getPane().removeAll();
		while (CheckerBoard.getSpaces().size() > 0)
			CheckerBoard.getSpaces().remove(0);
		Checkers.getPane().setLayout(new GridLayout(9, 3, 5, 5));
		try 
		{
			Checkers.setPic(ImageIO.read(new File("src/checkersLogo.png")));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		Checkers.getGUI().setIconImage(Checkers.getPic());
		Checkers.getGUI().setBackground(Checkers.getTertiary());
		Checkers.getGUI().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Checkers.setB1(new JButton("One Player"));
		Checkers.getB1().setBackground(Checkers.getPrimary());
		Checkers.getB1().setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
		Checkers.getB1().setForeground(Color.white);
		Checkers.setB2(new JButton("Two Player"));
		Checkers.getB2().setBackground(Checkers.getPrimary());
		Checkers.getB2().setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
		Checkers.getB2().setForeground(Color.white);
		Checkers.setB3(new JButton("Extra"));
		Checkers.getB3().setBackground(Checkers.getPrimary());
		Checkers.getB3().setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
		Checkers.getB3().setForeground(Color.white);
		Checkers.getB1().addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				CheckerBoard.showBoard();
			}
		});
		Checkers.getB2().addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event) 
			{
				CheckerBoard.showBoard();
			}
		});
		Checkers.getB3().addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent event)
			{
				CheckerBoard.showBoard();
			}
		});
		for (int i = 0; i < 27; i++)
		{
			JComponent panel = new JPanel();
			if (i == 1)
			{
				panel = new JPanel();
				panel.setBackground(Checkers.getPrimary());
				JLabel label = new JLabel("Play Checkers!");
				label.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 25));
				label.setForeground(Color.white);
				panel.add(label); 
			}
			else if (i == 7)
			{
				panel = Checkers.getB1();
			}
			else if (i == 13)
			{
				panel = Checkers.getB2();
			}
			else if(i == 19)
			{
				panel = Checkers.getB3();;
			}
			else if ((i == 3) || (i == 5) || (i == 9) || (i == 11) || (i == 15) || (i == 17) || (i == 21) || (i == 23) || (i == 25))
			{
				panel = new JPanel();
				panel.setBackground(Checkers.getPrimary());
			}
			else
			{
				panel = new JPanel();
				panel.setBackground(Checkers.getSecondary());
			}
			CheckerBoard.getSpaces().add(panel);
		}
		Checkers.resetPane();
	}
}