package com.ds.arrays;

import java.util.Arrays;

//https://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/
public class RotateCyclically {

	private static void rotate(int arr[]) {

		int x = arr[arr.length-1];
		
		for(int i= arr.length-1 ; i>0 ; i--)
			arr[i] = arr[i-1]; 
		
		arr[0] =x;
	}
	
	public static void main(String[] args) {
		
		int arr[] = new int[]{1, 2, 3, 4, 5}; 
		
		System.out.println("Given Array is"); 
        System.out.println(Arrays.toString(arr)); 
          
        rotate(arr); 
          
        System.out.println("Rotated Array is"); 
        System.out.println(Arrays.toString(arr)); 
	}
}

/*
Following are steps.
1) Store last element in a variable say x.
2) Shift all elements one position ahead.
3) Replace first element of array with x.
*/