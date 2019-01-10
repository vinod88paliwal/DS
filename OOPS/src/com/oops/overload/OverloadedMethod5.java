package com.oops.overload;

public class OverloadedMethod5 {
	public void test(long lng) {
        System.out.println("long");
    }
      
    public void test(Integer integer) {
        System.out.println("Integer");
    }

	public static void main(String[] args) {
		OverloadedMethod5 obj = new OverloadedMethod5();
		 obj.test(1);
	}
}

/*
 Output: long
              Because Widening wins over Boxing.
		       
*/

