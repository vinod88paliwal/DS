package com.ds.arrays;

import java.util.Arrays;

//https://www.geeksforgeeks.org/rearrange-array-such-that-even-positioned-are-greater-than-odd/
public class RearrangeEvenPositionedGreaterThanOdd {
//This question is same as RearrangeSmallestLargest2ndSmallest2ndLargest.java and
// solution of RearrangeSmallestLargest2ndSmallest2ndLargest is better and simple than this/below.

	static void evenPositionedGreaterThanOdd(int a[], int n) {
	     
	    // Sort the array
	    Arrays.sort(a);
	 
	    int ans[] = new int[n];
	    int start = 0, end = n - 1;
	    for (int i = 0; i < n; i++) {
	         
	    // Assign even indexes with maximum elements
	    if (i % 2 == 0)
	          ans[i] = a[end--]; //because of sorting ending elements are greater than starting elements.
	    	//ans[i] = a[i+1]; --> This will not work for duplicate data in Array.
	 
	    // Assign odd indexes with remaining elements
	    else if (i % 2 == 1)
	        ans[i] = a[start++];
	    }
	 
	    // Print result
	    for (int i = 0; i < n; i++)
	    System.out.print(ans[i] + " ");
	}
	 
	// Driver code
	public static void main(String args[]) {
	      //int A[] = {1, 3, 2, 2, 5};
		//int A[] = { 12, 3, 5, 7, 4, 19, 26 }; //26 3 19 4 12 5 7
		                                     //3 26 4 19 5 12 7
	    int A[] = {5, 8, 1, 4, 2, 9, 3, 7, 6};
		int n = A.length;
		evenPositionedGreaterThanOdd(A, n);
	}
	}
//Time complexity : O(Log n)