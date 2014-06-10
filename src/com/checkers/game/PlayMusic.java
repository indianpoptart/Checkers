package com.checkers.game;

import java.net.*;
import java.applet.*;


public class PlayMusic {
	public static void startMusic(){
		try {
			AudioClip clip = Applet.newAudioClip(new URL("file://Users/nikhilparanjape/Documents/Checkers/res/Tada.wav"));
			clip.play();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	public void endMusic(){
		
	}
}
