package com.checkers.gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.checkers.game.*;
public class ExportSettings
{
	public ExportSettings()
	{
		String settings = Checkers.getPrimary().toString() +  "\n" + Checkers.getSecondary().toString() + "\n" + Checkers.getTertiary().toString();
		BufferedWriter writer;
		try
		{
			writer = new BufferedWriter(new FileWriter("src/settings.txt"));
			writer.write(settings);
			writer.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}