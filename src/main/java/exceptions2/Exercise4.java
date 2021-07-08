package exceptions2;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
4. Write a program to get the name and age of the player from the user and  display it. 
player name is a string 
player age is an integer value 
Note : The player is eligible to participate in IPL when their age is 19 and above 
  This program may generate   
1. InvalidAgeRange Custom Exception when the player's age is below 19 
 Use exception handling mechanisms to handle these exceptions 

 Create a class called CustomException which extends Exception and it includes constructor to initialize the message. 
 
 Use appropriate exception handling mechanisms to handle these exceptions  

*/
public class Exercise4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		try {
			System.out.println("Enter the player name:");
			String name = in.nextLine();
			System.out.println("Enter the player age:");
			int age = in.nextInt();
			if (age < 19) {
				throw new InvalidAgeRangeException("Player must be at least 19 to be eligible for IPL");
			}
			System.out.println("Player name: " + name);
			System.out.println("Player age: " + age);
		} catch (InputMismatchException ime) {
			ime.printStackTrace();
		} catch (InvalidAgeRangeException iare) {
			System.out.println(iare);
		}
	}

}
