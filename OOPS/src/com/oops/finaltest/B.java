package com.oops.finaltest;

public abstract class B {

	//abstract final void show(); // Not possible

	public B()  // OR //private B()
	{
		System.out.println("private B()");
	}
	
	final void show1(){
		
	}

	public static void main(String[] args) {

		//B obj = new B(); // abstract class can`t be instantiated

	}
}
