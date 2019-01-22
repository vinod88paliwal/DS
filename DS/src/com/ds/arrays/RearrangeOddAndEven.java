package com.ds.arrays;

//https://www.geeksforgeeks.org/even-numbers-even-index-odd-numbers-odd-index/
public class RearrangeOddAndEven {

	public static void arrangeOddAndEven(int arr[], int n) {
		int oddInd = 1;
		int evenInd = 0;
		while (true) {
			while (evenInd < n && arr[evenInd] % 2 == 0)
				evenInd += 2;

			while (oddInd < n && arr[oddInd] % 2 == 1)
				oddInd += 2;

			if (evenInd < n && oddInd < n) {
				int temp = arr[evenInd];
				arr[evenInd] = arr[oddInd];
				arr[oddInd] = temp;
			} else
				break;
		}
	}

	public static void printArray(int arr[]) {
		for (int i : arr)
			System.out.print(i + " ");
	}

/*
Need to keep the relative ordering within odd numbers and even numbers.
Example:
Input : 31, 51, 41, 61, 32, 42, 52, 72
Output: 32, 31, 42, 51, 52, 41, 72, 61	

https://ide.geeksforgeeks.org/5DtKn9XUvh
*/
	public static void arrangeOddAndEven1(int arr[], int n) {

		for (int i = 0; i < n - 1; i++) {
			int current = i;
			int prev = 0;
			int temp = 0;
			prev = arr[i];
			if (isEven(arr[i]) && isOdd(i)) {

				for (int j = i + 1; j < n; j++) {
					if (isOdd(arr[j])) {
						arr[current] = arr[j];
						arr[j] = prev;
						break;
					}
					temp = arr[j];
					arr[j] = prev;
					prev = temp;
				}
			} else if (isOdd(arr[i]) && isEven(i)) {
				for (int j = i + 1; j < n; j++) {
					if (isEven(arr[j])) {
						arr[current] = arr[j];
						arr[j] = prev;
						break;
					}
					temp = arr[j];
					arr[j] = prev;
					prev = temp;
				}
			}
		}
	}

	public static boolean isEven(int num) {
		return num % 2 == 0;
	}

	public static boolean isOdd(int num) {
		return num % 2 == 1;
	}

	public static void main(String[] args) {

		int arr[] = { 3, 6, 12, 1, 5, 8 };
		int size = arr.length;

		System.out.print("Original Array: ");
		printArray(arr);

		arrangeOddAndEven(arr, size);

		System.out.print("\nModified Array: ");
		printArray(arr);
	}
}

//Time Complexity: O(n).
//Auxiliary Space: O(1).