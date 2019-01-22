package com.ds.arrays;

// Need to be understand and complete it.


//https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
//https://ide.geeksforgeeks.org/qf1vxdkv70
public class LargestSubarrayWithEqual01 {

	private static void printFromAndToIndex(int[] a) {

		// maximum length of subarray
		int max_length = -1;
		// indices indicating start and and end of subarray
		int i_result = 0 , j_result = -1 ;

		// length of given array
		int n = a.length;
		
		// convert all 0s to -1s
		for(int i=0 ; i< n ;i++)
			a[i] = (a[i] == 0) ? -1 : 1;
		
// Calculate the sum till each index and store in sum and keep track of maximum length subarray which starting from index 0.
        int[] sum = new int[n];
        sum[0] = a[0];
        
        for(int i=1 ; i< n ;i++)
        {
        	sum[i] = sum[i -1] + a[i];
        	if(sum[i] == 0)
        	{
        		max_length = i+1;
        		j_result =i;
        	}
        }
		
		
	}

	public static void main(String[] args) {

		int arr[] = { 0, 1, 0, 1, 0, 0, 0, 1, 1, 0 };
		printFromAndToIndex(arr);
	}

}
