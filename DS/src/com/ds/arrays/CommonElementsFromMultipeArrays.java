package com.ds.arrays;

public class CommonElementsFromMultipeArrays {

	public static void main(String[] args) {

		int arr1[] = {1, 5, 10, 20, 40, 80};
		int arr2[] = {6, 7, 20, 80, 100};
		int arr3[] = {3, 4, 15, 20, 30, 70, 80, 120};

		// Initialize starting indexes for ar1[], ar2[] and ar3[]
		int i=0, j=0, k=0;

		while (i < arr1.length && j < arr2.length && k < arr3.length)
		{

			// If x = y and y = z, print any of them and move ahead in all arrays
			if(arr1[i] == arr2[j] && arr2[j] == arr3[k])
			{
				System.out.print(arr1[i]+" ");
				i++ ; j++ ; k++;
			}
				// x < y
			else if(arr1[i] < arr2[j])
				  i++;

				// y < z
			else if(arr2[j] < arr3[k])
				  j++;

			// We reach here when x > y and z < y, i.e., z is smallest
			else
				k++;
		}
	}
}
