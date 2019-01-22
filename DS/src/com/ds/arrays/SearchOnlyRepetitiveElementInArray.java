package com.ds.arrays;

// THESE BELOW PROGRAMS NEEDS TO BE CORRECTED AS NOT WORKING PROPERLY FOR SOME INPUTS LIKE; 
//int arr[] = { 5, 4, 3, 9, 8, 9, 1, 6, 2};




//https://www.geeksforgeeks.org/find-repetitive-element-1-n-1/
public class SearchOnlyRepetitiveElementInArray {
/*
Algo (Use XOR): The idea is based on the fact that x ^ x = 0 and x ^ y = y ^ x.
1) Compute XOR of elements from 1 to n-1.
2) Compute XOR of array elements.
3) XOR of above two (Point 1 & 2) would be our result.

Time Complexity : O(n)
Auxiliary Space : O(1)
*/
 static int findRepeatingXOR( int arr[], int n)
  {
		// res is going to store value of 1 ^ 2 ^ 3 .. ^ (n-1) ^ arr[0] ^ arr[1] ^ .... arr[n-1]
		int res =0;
		int x1= arr[0];
		int x2 = 1;
		
		 for (int i = 0; i < n-1; i++)
			 res = res ^ (i+1) ^ arr[i];
		 
		 res = res ^ arr[n-1];
		 
		return res;
		
  }
 
/* 
Algo:  Using indexing.
1. Iterate through the array.
2. For every index visit a[index], if it is positive change the sign of element at a[index] index, else print the element.

Time Complexiy : O(n)
Auxiliary Space : O(1) 
 */
 // Function to find repeated element
 static int findRepeatingIndex(int arr[], int n)
 {
     int missingElement = 0;
  
     // indexing based
     for (int i = 0; i < n; i++){
  
    	 int element = arr[Math.abs(arr[i])]; 
    	 
         if(element < 0){
             missingElement = arr[i];
             break;
         }
      
         arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
     }
      return Math.abs(missingElement);
 }
	
	public static void main(String[] args) {
		
		 // int arr[] = { 9, 8, 2, 6, 1, 8, 5, 3, 4, 7 };
		  int arr[] = { 5, 4, 3, 9, 8, 9, 1, 6, 2};
                 
	        int n = arr.length;
	        System.out.println(findRepeatingXOR(arr, n));
	        System.out.println(findRepeatingIndex(arr, n));
	        
	}

}
