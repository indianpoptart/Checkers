package com.checkers.gui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.checkers.game.*;
import javax.imageio.ImageIO;

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
			Scanner pic = new Scanner(reader.readLine());
			Checkers.setPicSource(pic.nextLine());
			Checkers.setPic(ImageIO.read(new File(Checkers.getPicSource())));
			pic.close();
			Scanner icon = new Scanner(reader.readLine());
			Checkers.setIconSource(icon.nextLine());
			Checkers.setIcon(ImageIO.read(new File(Checkers.getIconSource())));
			icon.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}