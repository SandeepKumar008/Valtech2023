package com.valtech.training.day2;

public class PointsArithmeticImpl implements PointsArithmetic {

	protected int x1,x2;
	protected int y1,y2;
	
	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		return b-a;
	}

	@Override
	public double dist(int a, int b) {
		return Math.sqrt(a*a + b*b);
	}
	
   public static void main(String[] args) {
	PointsArithmetic p1 = new PointsArithmeticImpl();


}
}
