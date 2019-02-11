package com.vinod.analytical;

import java.util.Scanner;

/**
 * Java program to calculate and print Fibonacci number using both recursion and Iteration.
 * Fibonacci number is sum of previous two Fibonacci numbers fn= fn-1+ fn-2
 * first 10 Fibonacci numbers are 0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 * @author
 */
public class FibonacciCalculator {
 
    //first 10 Fibonacci numbers are 0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    public static int fibonacciNthPosition(int pos){
        if(pos == 1 )
            return 0;
        else if( pos == 2)
        	return 1;
        
        int fibo1=0, fibo2=1, fibonacci=0;
        int i=1;
        
        while(i < pos)
        {
        	fibonacci = fibo1 + fibo2; //Fibonacci number is sum of previous two Fibonacci number
            fibo1 = fibo2;
            fibo2 = fibonacci;
            i++;
        }	
        return fibo1; //Fibonacci number
    }  

    public static void fibonacciUptoGivenNumber(int num){

    	int fibo1=0, fibo2=1, fibonacci=0;
        while(fibo1 <= num)
        {
        	System.out.print(fibo1+" ");

            fibonacci = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibonacci;
        }
    }  

    /*
     * Java program for Fibonacci number using recursion.
     * This program uses tail recursion to calculate Fibonacci number for a given number
     * @return Fibonacci number
     */
    public static int fibonacci(int number){
        if(number == 1 || number == 2){
            return 1;
        }
        return fibonacci(number-1) + fibonacci(number -2); //tail recursion
    }

    
    public static void main(String args[]) {
    	 
    	System.out.println(fibonacciNthPosition(6));
    	fibonacciUptoGivenNumber(10);
     }
}

