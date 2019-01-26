package com.ds.arrays;

import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
public class PairWhoseSumXHashApproach {

	static void printPairsUsingSet(int[] numbers, int n) {
		if (numbers.length < 2)
			return;

		Set<Integer> set = new HashSet<Integer>(numbers.length);

		for (int value : numbers) {
			int target = n - value;

			// if target number is not in set then add
			if (target > 0 && set.contains(target)) {
				System.out.printf("(%d, %d) %n", value, target);
			} else {
				set.add(value);
			}
		}
	}

	public static void main(String[] args) {

		int[] arr = { 3, 5, 8, 3, 4, 9, 7, 8, 6 };

		printPairsUsingSet(arr, 10);
	}
}
//Time Complexity : O(n)

/*
 * 1) Initialize an empty hash table s. 2) Do following for each element A[i] in
 * A[] (a) If s[x - A[i]] is set then print the pair (A[i], x - A[i]) (b) Insert
 * A[i] into s.
 */