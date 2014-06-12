package com.checkers.game;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class PlayMusic extends Thread 
{ 
	private SourceDataLine auline;
	private String filename;
	private Position curPosition;
	private final int EXTERNAL_BUFFER_SIZE = 524288;
	enum Position {LEFT, RIGHT, NORMAL};
	public PlayMusic(String wavfile) 
	{ 
		filename = wavfile;
		curPosition = Position.NORMAL;
	} 
	public void run() 
	{ 
		File soundFile = new File(filename);
		AudioInputStream audioInputStream = null;
		try
		{ 
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} 
		catch (UnsupportedAudioFileException e)
		{ 
			e.printStackTrace();
			return;
		}
		catch (IOException e1)
		{ 
			e1.printStackTrace();
			return;
		}
		AudioFormat format = audioInputStream.getFormat();
		auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		try 
		{ 
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} 
		catch (LineUnavailableException e) 
		{ 
			e.printStackTrace();
			return;
		}
		catch (Exception e) 
		{ 
			e.printStackTrace();
			return;
		} 
		if (auline.isControlSupported(FloatControl.Type.PAN)) 
		{ 
			FloatControl pan = (FloatControl)auline.getControl(FloatControl.Type.PAN);
			if (curPosition == Position.RIGHT) 
				pan.setValue(1.0f);
			else if (curPosition == Position.LEFT) 
				pan.setValue(-1.0f);
		} 
		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
		try
		{ 
			while (nBytesRead != -1) 
			{ 
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0) 
					auline.write(abData, 0, nBytesRead);
			} 
		} 
		catch (IOException e) 
		{ 
			e.printStackTrace();
			return;
		} 
		finally 
		{ 
			auline.drain();
			auline.close();
		} 
	}
	public void endSong()
	{
		auline.drain();
		auline.close();
	}
} 