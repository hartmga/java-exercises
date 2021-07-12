package java8;

import java.util.ArrayList;
import java.util.Scanner;

/*
9.	(Mapping Integer Grades to Letter Grades) Create a program that reads integer grades and stores them
in an ArrayList, then use stream processing to display each grade’s letter equivalent (A, B, C, D or F).
*/
public class Exercise9 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter integer grade percentages (0-100) (enter 'done' to finish): ");
		String input;
		ArrayList<Integer> scores = new ArrayList<>();
		while (!"done".equals(input = in.next())) {
			try {
				int score = Integer.parseInt(input);
				scores.add(score);
			} catch (NumberFormatException e) {
				System.out.println(input + " was not recognized as an integer");
			}
		}

		scores.stream().map(s -> s + ": " + getGrade(s)).forEach(System.out::println);
	}

	// get the letter grade for a given score
	public static char getGrade(int grade) {
		if (grade >= 90) {
			return 'A';
		} else if (grade >= 80) {
			return 'B';
		} else if (grade >= 70) {
			return 'C';
		} else if (grade >= 60) {
			return 'D';
		} else {
			return 'F';
		}
	}

}
