package com.valtech.training.day2;

public class Outer {
	
	
	private int x;
	public Inner ceateInnrt()
	{ return new Inner();
	}
	
	public static interface abcd{
		
		
	}
	
	public abstract static class StaticInner implements abcd{
		//Outer.Inner i = o.ceateInnrt();
		public void jumpBy10(Outer o) {
			o.x = o.x+10;
		}
		
		public abstract void jumpBy100(Outer o);

	}
		
	public class Inner {
		public void printx() {
			System.out.println("X="+x);
		}
		
		public void increment() {
			x++;
		}
	}
		
	public static void main(String[] args) {
			
		Outer o = new Outer();
		Outer.Inner i = o.ceateInnrt();
		Outer.Inner i1 = o.ceateInnrt();
		System.out.println(i);
		System.out.println(i1);
		i1.increment();
		i.printx();
		new Outer().ceateInnrt().printx();
		StaticInner si = new StaticInner() {
			

			@Override
			public void jumpBy100(Outer o) {
				o.x =o.x + 100	;	
			}
			
	};
	si.jumpBy10(o);
	si.jumpBy100(o);
	i.printx();
	Arithmetic a = new Arithmetic() {
		
		@Override
		public int sub(int a, int b) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public int mul(int a, int b) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public int div(int a, int b) throws DivideByZeroException {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public int add(int a, int b) {
			// TODO Auto-generated method stub
			return 0;
		}
	};
}
}
