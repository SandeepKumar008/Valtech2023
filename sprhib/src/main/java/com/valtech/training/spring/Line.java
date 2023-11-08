package com.valtech.training.spring;

public class Line {
	
	private Point start;
	private Point end;
	
	
	public Line() {}
	
	
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	public Point getStart() {
		return start;
	}
	public void setStart(Point start) {
		this.start = start;
	}
	public Point getEnd() {
		return end;
	}
	public void setEnd(Point end) {
		this.end = end;
	}


	@Override
	public String toString() {
		return "Line [start=" + start + ", end=" + end + "]";
	}
	
	
	
	

}
