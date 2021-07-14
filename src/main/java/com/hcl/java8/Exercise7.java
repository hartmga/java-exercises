package com.hcl.java8;

import java.util.Arrays;
import java.util.Scanner;

/*
7.	(Duplicate Word Removal) Write a program that inputs a sentence from the user (assume no punctuation),
then determines and displays the unique words in alphabetical order. Treat uppercase and lowercase letters the same.
*/
public class Exercise7 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a sentence with no punctuation");
		String input = in.nextLine();
		Arrays.stream(input.split("\\s")).map(String::toLowerCase).distinct().sorted().forEach(System.out::println);

	}

}
