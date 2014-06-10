package com.checkers.game;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/* 
 * Checkers Game:
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
 * @author Nikhil Paranjape
 */

/**
 * This class will display the rules to the players each time the game is started, this will be a GUI
 */
public class Rules {
	final ImageIcon icon = new ImageIcon("icon.png");
	public Rules(){
		
	}
	public static void getRules(){
		String rulesOfTheGame = "A LAN Checkers game!.\n"
				+ "Object: Be first to remove all of your opponent’s Checkers from the Game Board.\n"
				+ "\n"
				+ "Set Up: Each player place 12 red or 12 black Checkers on the first three rows of black squares on your end of the Game Board.\n"
				+ "\n"
				+ "Play: Decide who goes first. Players alternate turns. \n"
				+ "\n"
				+ "On your turn, move your Checker diagonally forward to a vacant black square, then your turn is over. \n"
				+ "You may jump an opponent’s Checker if the black square diagonally beyond that Checker is vacant. \n"
				+ "If possible, you can double or triple jump on a turn.\n"
				+ "After you jump over one of your opponent’s Checkers, remove it from the Game Board and place it nearby. \n"
				+ "Reach the back row of your opponent’s side of the Game Board with one of your Checkers and it becomes a King.\n"
				+ "Your opponent must place a Checker of the same color on top.\n"
				+ "It’s an advantage to have Kings because these two-level Checkers can move diagonally forward and backward!\n"
				+ "Winning: If you’re first to remove all of your opponent’s Checkers from the Game Board, you win! \n"
				+ "Now go play again!\n";
		JOptionPane.showMessageDialog(null, rulesOfTheGame, "Rules",JOptionPane.INFORMATION_MESSAGE);
	}
}
