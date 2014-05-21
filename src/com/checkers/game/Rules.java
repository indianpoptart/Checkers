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
 * @author Brian Maguire
 * @author Jordan Ghidossi
 * @author Michael Search
 * @author Adam Zukowski
 */

/**
 * This class will display the rules to the players each time the game is started, this will be a GUI
 */
public class Rules {
	final ImageIcon icon = new ImageIcon("icon.png");
	public Rules(){
		
	}
	public void getRules(){
		String rulesOfTheGame = "A LAN Checkers game!.\n"
				+ "- To move your player, press the token, then press the square you would like to move to\n"
				+ "- An invalid turn will display a box saying that the move was invalid\n"
				+ "To quit, press 'Q'.";
		JOptionPane.showMessageDialog(null, rulesOfTheGame, "Rules",JOptionPane.INFORMATION_MESSAGE, icon);
	}
}
