package exceptions1.ex7;

public class Main {

	public static void main(String[] args) {
		try {
			someMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void someMethod() throws Exception {
		try {
			someMethod2();
		} catch (Exception e) {
			throw new Exception("exception thrown from someMethod", e);
		}
	}

	public static void someMethod2() throws Exception {
		throw new Exception("exception thrown from someMethod2");
	}

}
