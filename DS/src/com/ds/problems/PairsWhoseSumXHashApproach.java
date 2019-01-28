package com.ds.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vpaliwal on 9/1/17.
 */
public class PairsWhoseSumXHashApproach {

      static void printPairsUsingSet(int[] numbers, int sum){
        if(numbers.length < 2){
            return;
        }
        Set<Integer> set = new HashSet<Integer>(numbers.length);

        for(int value : numbers){
            int target = sum - value;

            // if target number is not in set then add
            if(set.contains(target)){
            	System.out.printf("(%d, %d) %n", value, target);
            }else {
            	set.add(value);
            }
        }
    }

    public static void main(String[] args) {

       // int []arr = {3,5,8,3,4,9,7,8,6};
        int arr[] = {11, 15, 6, 8, 9, 10};
        int sum = 16;

        printPairsUsingSet(arr,sum);

    }


}
