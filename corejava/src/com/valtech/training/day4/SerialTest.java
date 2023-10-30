package com.valtech.training.day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.valtech.training.day1.Point;
import com.valtech.training.day1.Point3D;

public class SerialTest {
	
	public static void main(String[] args) throws Exception{
		
		Point p = new Point(2,3);
		System.out.println(p);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("objects")));
		oos.writeObject(p);
		oos.flush(); //anything that is in cache shld be returned to underlined file
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("objects")));
		Point p1 = (Point) ois.readObject();
		System.out.println(p1);
		System.out.println(p1 ==p);
		
		Point3D p2 = new Point3D(2,3,4);
		System.out.println(p2);
		ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(new File("objects1")));
		oos1.writeObject(p2);
		oos1.flush(); //anything that is in cache shld be returned to underlined file
		oos1.close();
		ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(new File("objects1")));
		Point p3 = (Point) ois1.readObject();
		System.out.println(p3);
		System.out.println(p3 ==p2);
		System.out.println(p2.distance());
		System.out.println(p3.distance());
	}

}
