package com.hcl.exceptions2;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
3. You are required to compute the power of a number by implementing a calculator. Create a class MyCalculator which
consists of a single method long power(int, int). This method takes two integers, and , as parameters and finds .
If either or is negative, then the method must throw an exception which says "". Also, if both and are zero, then the
method must throw an exception which says ""
For example, -4 and -5 would result in .
Complete the function power in class MyCalculator and return the appropriate result after the power operation
or an appropriate exception as detailed above. 
*/
public class Exercise3 {

	public static void main(String[] args) {

		System.out.println("This program computes a^b for nonnegative a and b.\nEnter a and b:");
		Scanner in = new Scanner(System.in);
		try {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(MyCalculator.power(a, b));
		} catch (InputMismatchException ime) {
			System.out.println(ime);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
