package com.checkers.gui;

import java.awt.Graphics;

import com.checkers.main.Pieces;

public class Space {
	private Pieces p;

    public Space() { p = null; }
    public Space(Pieces checker) { p = checker; }

    // Methods here to clear piece or set piece

    public void paintComponent(Graphics g) {
         if (p != null) {
             //Pull in checker image here
         }
    }
}
