package com.hcl.exceptions1.ex6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import lombok.ToString;

@ToString
public class SomeClass {

	private FileReader reader;
	private File file;
	int x;

	public SomeClass(String filePath, int[] arr, int index) throws FileNotFoundException {
		file = new File(filePath);
		reader = new FileReader(file);
		try {
			x = arr[index];
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new RuntimeException("invalid index", ex);
		}
	}
}
