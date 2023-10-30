package com.valtech.training.day1;

import java.io.Serializable;

public class Point implements Comparable<Point> ,Serializable{
	
	// 1.Constants
	// 2.Static Blocks
	// 3.Variables
	// 4.Constructor
	// 5.Methods
	
	public static final Point ORIGIN = new Point();
	
	static {
		ORIGIN.x = 1000;
		ORIGIN.y = 2000;
		System.out.println(ORIGIN);
	}
	
	protected int x;
	protected transient int  y;

	
	public Point() {
		System.out.println("Point Method");
	}
	
	public  Point(int x,int y) {
		System.out.println("in ctor of point");
	//	super();
		this.x = x; //object level x
		//x=x; local level x
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		return (x - o.x) == 0 ? (y-o.y) : (x -o.x);
	}
	
	@Override
	public boolean equals(Object obj) {
		Point p = (Point) obj;
//		type casting = super class reference to sub class reference 
		return p.x == x && p.y ==y;
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "X = "+x+" Y = "+y+" Distance = "+distance();
	}
	
	public double distance(Point other) {
		System.out.println("Distance with another point");
		return distance(other.x,other.y);
	}
	
	public double distance(int x,int y) {
		int diffx = this.x - x;
		int diffy = this.y-y;
		return Math.sqrt(diffx*diffx + diffy*diffy);
	}
	
	//normally methods are marked as public
	public double distance() {
		System.out.println("Distance in point");
		int diffx =  x- ORIGIN.x;
		int diffy = y- ORIGIN.y;
		return Math.sqrt(x*x + y*y);
	}
	
	
	
	public static void main(String[] args) {
		Point p = new Point();
		p.x = 10;
		p.y = 20;
		System.out.println(p);
		System.out.println(p.distance());
		ORIGIN.x = 10;
		
	}
	
}