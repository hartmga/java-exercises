package java8;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
8.	(Sorting Letters and Removing Duplicates) Write a program that inserts 30 random letters into a List<Character>.
Perform the following operations and display your results:
*/
public class Exercise8 {

	public static void main(String[] args) {

		// generate the random list of letters
		// a random list of uppercase letters is generated, and each has a 50% chance of
		// becoming lowercase
		SecureRandom sr = new SecureRandom();
		List<Character> chars = sr.ints(30, 65, 91).boxed().map(i -> (char) (sr.nextInt(2) == 0 ? i : (i + 32)))
				.collect(Collectors.toList());

		// 1. Sort the List in ascending order.
		chars.stream().sorted().forEach(System.out::println);
		System.out.println();

		// 2. Sort the List in descending order.
		chars.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		System.out.println();

		// 3. Display the List in ascending order with duplicates removed.
		chars.stream().distinct().sorted().forEach(System.out::println);

	}

}
