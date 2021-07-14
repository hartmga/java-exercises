package com.hcl.exceptions2;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
2.Java has built-in mechanism to handle exceptions. Using the try statement we can test a block of code for errors.
The catch block contains the code that says what to do if exception occurs. 
This problem will test your knowledge on try-catch block.
You will be given two integers and as input, you have to compute . If and are not bit signed integers or if is zero,
exception will occur and you have to report it. Read sample Input/Output to know what to report in case of exceptions.

*/
public class Exercise2 {

	public static void main(String[] args) {
		System.out.println("This program computes a/b for two integers a and b.\nEnter a and b:");
		Scanner in = new Scanner(System.in);
		int[] input = new int[2];
		for (int i = 0; i < input.length; i++) {
			try {
				input[i] = in.nextInt();
			} catch (InputMismatchException ime) {
				System.out.println(ime);
				System.out.println("Invalid input. Please re-enter a valid integer:");
				in.nextLine();
				i--;
			}
		}
		try {
			System.out.println(input[0] / input[1]);
		} catch (ArithmeticException ie) {
			System.out.println(ie);
		}
	}

}
