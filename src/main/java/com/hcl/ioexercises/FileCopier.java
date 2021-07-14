package com.hcl.ioexercises;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
2. Rewrite the file-copying main program using only the standard java.io classes discussed in class.
Assume that appropriate arguments will be provided and no error checking is necessary. Do not handle
the possible IOExceptions but simply declare that main may throw an IOException. 
3. Copy and modify the previous main program so that it handles all possible IOExceptions and main will
not throw any IOException. Output meaningful error message(s).
 */
public class FileCopier {

	public static void main(String[] args) {
		// for these files, character streams could be used instead, but byte streams
		// will work for any type of file
		String fromPath = "C:/Temp/file.txt";
		String toPath = "./IODemo/file.txt";
		byte[] buf = new byte[1000];
		try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(fromPath));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(toPath))) {
			int numBytes = 0;
			while ((numBytes = fis.read(buf)) != -1) {
				bos.write(buf, 0, numBytes);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
