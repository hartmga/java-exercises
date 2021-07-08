package exceptions1.ex3;

/*
3.	 (Catching Exceptions with Superclasses) Use inheritance to create an exception superclass (called ExceptionA)
and exception subclasses ExceptionB and ExceptionC, where ExceptionB inherits from ExceptionA and ExceptionC inherits
from ExceptionB. Write a program to demonstrate that the catch block for type ExceptionA catches exceptions of types
ExceptionB and ExceptionC. These classes will be custom exceptions.
*/
public class Main {

	public static void main(String[] args) throws ExceptionA {
		try {
			foo(2); // Throws exceptionC
		} catch (ExceptionA exA) {
			System.out.println(exA); // as expected, exceptions of type ExceptionC are caught
		}
	}

	public static void foo(int n) throws ExceptionA {
		if (n > 5) {
			throw new ExceptionA("n must not be greater than 5");
		} else if (n < 0) {
			throw new ExceptionB("n must not be negative");
		} else {
			throw new ExceptionC("Function foo() always throws an exception regardless of the input");
		}
	}

}
