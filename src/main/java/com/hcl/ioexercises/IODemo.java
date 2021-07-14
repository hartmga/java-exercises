package com.hcl.ioexercises;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class IODemo implements Serializable {

	private int anInteger;
	private String aString;
	@EqualsAndHashCode.Exclude
	private LocalDateTime timeCreated = LocalDateTime.now();

	// DateTimeFormatter does not implement Serializable
	private transient DateTimeFormatter formatter = DateTimeFormatter.ofPattern("kk:mm:ss");

	public static int staticInt = 2;

	public IODemo(int n, String s) {
		anInteger = n;
		aString = s;

		// this static field is set in the constructor and given a default value above
		// to see how the value is set when an ObjectInputStream reads in an instance of
		// the class, depending on whether or not the class is already loaded
		staticInt = 1;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		in.defaultReadObject();

		// this transient field must be set here
		formatter = DateTimeFormatter.ofPattern("kk:mm:ss");
	}

	public String formattedTimeCreated() {
		return timeCreated.format(formatter);
	}

}
