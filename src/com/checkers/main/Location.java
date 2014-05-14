package com.checkers.main;

public class Location
{
	private int x, y;
	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getRow()
	{
		return this.x;
	}
	public int getCol()
	{
		return this.y;
	}
	public void setRow(int x)
	{
		this.x = x;
	}
	public void setCol(int y)
	{
		this.y = y;
	}
}