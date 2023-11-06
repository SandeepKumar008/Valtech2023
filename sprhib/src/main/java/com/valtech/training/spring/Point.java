package com.valtech.training.spring;
 
public class Point {
	private int x;
	private int y;
	
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Point(int x, int y) {
		super();
		System.out.println("Parameterized ctor..");
		this.x = x;
		this.y = y;
	}
 
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
 
}