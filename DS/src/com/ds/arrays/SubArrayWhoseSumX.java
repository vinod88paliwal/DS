package com.ds.arrays;

import java.util.HashMap;

//https://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
public class SubArrayWhoseSumX {

	static void subArrayIndexes(int[] arr, int sum) {

		int size = arr.length;
		int curr_sum = arr[0], start = 0;

		int i = 1;
		for (; i < size; i++) {
			// If curr_sum exceeds the sum, then remove the starting elements
			while (curr_sum > sum && start < i - 1) {
				curr_sum -= arr[start];
				start++;
			}

			// If curr_sum becomes equal to sum, then return true
			if (curr_sum == sum) {

				int temp = i - 1;
				System.out.println("Sum " + sum + " found between indexes " + start + " and " + temp);
				break;
			}

			// Add this element to curr_sum
			// if (i < size)
			// OR
			if (curr_sum < sum)
				curr_sum += arr[i];
		}
		if (i == size)
			System.out.println("No subarray found");
	}

	/*
	 * Time complexity: O(n), Time complexity of method 2 looks more than O(n), but if we take a closer look at the program, then we can figure out the time
	 * complexity is O(n). We can prove it by counting the number of operations performed on every element of arr[] in worst case. There are at most 2
	 * operations performed on every element: (a) the element is added to the curr_sum (b) the element is subtracted from curr_sum. So the upper bound on number of operations is 2n which is O(n).
	 */
	
	// This is better solution which works for negative as well. 
		static void findSubarrays(int arr[], int sum)
		{
			int n= arr.length;
			for (int i = 0; i < n; i++)
			{
				int sum_so_far = 0;

				// consider all sub-arrays starting from i and ending at j
				for (int j = i; j < n; j++)
				{
					// sum of elements so far
					sum_so_far += arr[j];

					// if sum so far is equal to the given sum
					if (sum_so_far == sum) {
						print(arr, i, j);
					}
				}
			}
		}
		
	// Utility function to print the sub-array arr[i,j]
	static void print(int arr[], int i, int j)
	{
		System.out.printf("[%d..%d] -- { ", i, j);
		for (int k = i; k <= j; k++) {
			System.out.printf("%d ", arr[k]);
		}
		System.out.printf("}\n");
	}

	public static void subArraySum(int[] arr, int sum) {
		int n = arr.length; 
		
		// cur_sum to keep track of cumulative sum till that point
		int cur_sum = 0;
		int start = 0;
		int end = -1;
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			cur_sum = cur_sum + arr[i];
			// check whether cur_sum - sum = 0, if 0 it means
			// the sub array is starting from index 0- so stop
			if (cur_sum - sum == 0) {
				start = 0;
				end = i;
				break;
			}
			// if hashMap already has the value, means we already
			// have subarray with the sum - so stop
			if (hashMap.containsKey(cur_sum - sum)) {
				start = hashMap.get(cur_sum - sum) + 1;
				end = i;
				break;
			}
			// if value is not present then add to hashmap
			hashMap.put(cur_sum, i);

		}
		// if end is -1 : means we have reached end without the sum
		if (end == -1) {
			System.out.println("No subarray with given sum exists");
		} else {
			System.out.println("Sum found between indexes " + start + " to " + end);
		}
	} //Time complexity :  O(n)

	static int noOfSubarraysHavingSumx(int arr[], int sum)
	{
		
		
		return 1;
	}
	
	public static void main(String[] args) {

		int arr[] = { 15, 1, 4, 8, 9, 5, 10, 23 };
		int[] arr1 = { 3, 5, 8, 3, 4, 9, 7, 8, 6 };

		//subArrayIndexes(arr1, 24);
		//findSubarrays(arr,22);
		
		int[] arr2 = {10, 2, -2, -20, 10}; 
        
        int sum = -10; 
        subArraySum(arr1, 24); 
	}
}
//Time Complexity : O(n)
