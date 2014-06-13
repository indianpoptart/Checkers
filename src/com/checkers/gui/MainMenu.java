package com.checkers.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.checkers.gui.CheckerBoard;

import com.checkers.game.Checkers;

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
		Checkers.setB3(new JButton("Rules"));
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
				UIManager.put("OptionPane.background", Checkers.getTertiary());
				UIManager.put("Panel.background", Checkers.getTertiary());
				UIManager.put("Button.background", Checkers.getPrimary());
				ImageIcon logo = new ImageIcon(Checkers.getIconSource());
				UIManager.put("Button.font", new Font("Times New Roman", Font.CENTER_BASELINE, 12));
				JOptionPane.showMessageDialog(null, "Objective: Be the last player remaining with pieces on the game board.\n\nSet Up: Each player has 12 pieces on the first three rows of primarily colored squares on the end\nof the game board.\n\nPlay: The player on the top of the screen makes the first move of the game. Players alternate turns. On\nyour turn, move yourpiece diagonally forward to a vacant square, then your turn is over. You must jump\nover the opponent�s piece if the square diagonally beyond that piece is vacant. If possible, you must double\nor triple jump on a turn. After you jump over one of your opponent�s pieces, it is removed from the game\nboard. Reach the back row of your opponent�s side of the game board with one of your pieces and it\nbecomes a king. It is an advantage to have kings because these pieces can move diagonally forward and\nbackward!\n\nWinning: If you are the first to remove all of your opponent�s pieces from the game board, you win!\nNow go play again!", "Checkers Rules", 0, logo);
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