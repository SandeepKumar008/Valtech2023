package com.valtech.training.day2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import com.valtech.training.day1.Point;


public class UtilsTest {
	
	
//stack can have duplicates coz it is part of list
	public static void testStack(Stack<Point> points) {
		points.push(new Point(2,3));
		points.push(new Point(2,4));
		points.push(new Point(2,5));
		points.push(new Point(2,3));
		points.push(new Point(2,3));
		points.push(new Point(2,3));
		points.push(new Point(2,1));
		points.push(new Point(2,2));
		System.out.println("Size ="+points.size());
		System.out.println(points.pop());
		System.out.println("Size ="+points.size());
		System.out.println(points.peek());
		System.out.println("Size ="+points.size());
		
	}
	
//	public static void testMap(Map<String,Point> points) {
//		
//		points.put("2,3", new Point(2,3));
//		points.put("2,3", new Point(2,3));
//		points.put("3,2", new Point(3,2));
//		points.put("2,4", new Point(2,4));
//		points.put("2,4", new Point(8,4));
//		points.put("2,4", new Point(5,4));
//		System.out.println(points.size());
//		System.out.println(points);
//		System.out.println(((Stack<Point>) points).pop());
//		System.out.println();
//		
		
//	}
//	
//	public static void testList(List<Point> points) {
//		Point p = new Point(2,3);
//		Point p1 = new Point(2,3);
//	//	Set<Point> points = new HashSet<>();
//		points.add(p);
//		points.add(p1);
//		points.add(p);
//		points.add(new Point(3,2));
//		System.out.println("Size = "+points.size());
//		System.out.println(points);
//	}
	
//	public static void testSet(Set<Point> points){//change the signature of offset) {         //method within a class to be named as this
//		Point p = new Point(2,3);
//		Point p1 = new Point(2,3);
//	//	Set<Point> points = new HashSet<>();
//		points.add(p);
//		points.add(p1);
//		points.add(p);
//		points.add(new Point(3,2));
//		System.out.println("Size = "+points.size());
//		System.out.println(points);
//	}
//	
	

	public static void main(String[] args) {
//		testSet(new HashSet<>());
//		testSet(new TreeSet<>());
//		testList(new ArrayList<>());
//		testList(new LinkedList<>());
	//	testMap(new HashMap<>());
	//	testMap(new TreeMap<>());
		testStack(new Stack<>());
	}

}
