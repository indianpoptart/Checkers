package com.checkers.gui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.checkers.game.*;

public class ImportSettings 
{
	public ImportSettings()
	{
		FileReader fileReader = null;
		try
		{
			fileReader = new FileReader("src/settings.txt");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(fileReader);
		try 
		{
			Scanner pri = new Scanner(reader.readLine());
			pri.useDelimiter("\\D+");
			Checkers.setPrimary(new Color(pri.nextInt(), pri.nextInt(), pri.nextInt()));
			pri.close();
			Scanner sec = new Scanner(reader.readLine());
			sec.useDelimiter("\\D+");
			Checkers.setSecondary(new Color(sec.nextInt(), sec.nextInt(), sec.nextInt()));
			sec.close();
			Scanner ter = new Scanner(reader.readLine());
			ter.useDelimiter("\\D+");
			Checkers.setTertiary(new Color(ter.nextInt(), ter.nextInt(), ter.nextInt()));
			ter.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}