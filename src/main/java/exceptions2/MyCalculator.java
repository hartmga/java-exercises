package exceptions2;

public class MyCalculator {

	static long power(int base, int exponent) throws Exception {
		long result = 1;
		if (base == 0 && exponent == 0) {
			throw new Exception("base and exponent cannot both be 0");
		}
		if (base < 0 || exponent < 0) {
			throw new Exception("neither base nor exponent can be zero");
		}
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}

}
