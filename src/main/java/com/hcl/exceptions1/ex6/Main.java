package com.hcl.exceptions1.ex6;

import java.io.FileNotFoundException;

/*
6.	 (Constructor Failure) Write a program that shows a constructor passing information about constructor
failure to an exception handler. Define class SomeClass, which throws an Exception in the constructor.
Your program should try to create an object of type SomeClass and catch the exception that’s thrown from the constructor.
*/
public class Main {

	public static void main(String[] args) {
		SomeClass newObj = null;
		try {
			newObj = new SomeClass("C:\\Temp\\nonexistentFile.txt", new int[] { 1, 2, 3 }, 0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("SomeClass object: " + newObj);
		}
		System.out.println();

		try {
			newObj = new SomeClass("C:\\Temp\\file.txt", new int[] { 1, 2, 3 }, 97);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("SomeClass object: " + newObj);
		}
		System.out.println();

		try {
			newObj = new SomeClass("C:\\Temp\\file.txt", new int[] { 1, 2, 3 }, 0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("SomeClass object: " + newObj);
		}
	}

}
