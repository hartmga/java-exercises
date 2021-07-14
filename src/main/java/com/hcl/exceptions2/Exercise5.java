package com.hcl.exceptions2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
5. Given total runs scored and  total overs faced as the input. Write a program to calculate the run rate with the formula,
Run rate= total runs scored/total overs faced.
Use BufferedReader class to get the inputs from user.
 This program may generate Arithmetic Exception / NumberFormatException. Use exception handling mechanisms to handle this
 exception. Use a single catch block. In the catch block, print the class name of the exception thrown.

*/
public class Exercise5 {

	public static void main(String[] args) {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter the total runs scored: ");
			int runs = Integer.parseInt(in.readLine());
			System.out.println("Enter the total overs faced: ");
			int overs = Integer.parseInt(in.readLine());
			System.out.println("Current run rate: " + (double) runs / overs);
			// this actually will not throw an ArithmeticException because a double can
			// represent infinity. Only NumberFormatExceptions will be caught in the try
			// block.
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}

	}

}
