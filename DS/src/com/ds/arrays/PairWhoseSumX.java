package com.ds.arrays;

import java.util.HashSet;
import java.util.Set;

public class PairWhoseSumX {

	private static final int MAX = 100000; // Max size of binmap

	static void pairSumXBinMap(int arr[], int sum) {

		if (arr.length < 2)
			return;

		boolean[] binmap = new boolean[MAX];

		for (int i : arr) {
			int temp = sum - i;

			// checking for condition
			if (temp > 0 && binmap[temp]) {
				System.out.println("Pair with given sum " + sum + " is (" + i + ", " + temp + ")");
			}
			binmap[i] = true;
		}
	}

	static void pairSumXSet(int[] arr, int sum) {
		if (arr.length < 2)
			return;

		Set<Integer> set = new HashSet<Integer>(arr.length);

		for (int value : arr) {
			int target = sum - value;

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
		pairSumXBinMap(arr, 10);
		pairSumXSet(arr, 10);

	}
}
