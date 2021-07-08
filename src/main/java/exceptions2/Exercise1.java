package exceptions2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
1. Handling a checked exception by opening a file
Write a  code opens a text file and writes its content to the standard output. What happens if the file doesn’t exist?
*/
public class Exercise1 {

	public static void main(String[] args) {
		File toRead = new File("C:\\Temp\\file.txt");
		try (Scanner reader = new Scanner(toRead);) {
			while (reader.hasNextLine()) {
				System.out.println(reader.nextLine());
			}
		} catch (FileNotFoundException ffe) {
			ffe.printStackTrace();
		}

	}

}
