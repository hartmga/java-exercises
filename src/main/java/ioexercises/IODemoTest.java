package ioexercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IODemoTest {

	public static void main(String[] args) {

		File file = new File("./IODemo/obj");

		IODemo demo = new IODemo(5, "hello");
		System.out.println("Object creation time for written object: " + demo.formattedTimeCreated());
		writeObj(demo, file);
		try {
			Thread.sleep(3_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		IODemo readDemo = (IODemo) readObj(file);
		System.out.println("Object creation time for read object: " + readDemo.formattedTimeCreated());
		System.out.printf("The written object and the read object are %s the same:%n",
				demo.equals(readDemo) ? "" : "not ");
		System.out.println(demo);
		System.out.println(readDemo);

		// this static field is not set to 2 by the ObjectInputStream if the class is
		// already loaded. If the object is read in but no instance was created by the
		// constructor earlier in this program, it is set to 2.
		System.out.println(IODemo.staticInt);

	}

	public static void writeObj(Object o, File file) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
			file.createNewFile();
			oos.writeObject(o);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object readObj(File file) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {
			Object object = ois.readObject();
			return object;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
