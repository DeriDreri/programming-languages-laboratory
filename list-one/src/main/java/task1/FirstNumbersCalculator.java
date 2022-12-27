package task1;

import java.math.BigInteger;

public class FirstNumbersCalculator {

	private int foundPrimeNumbers;

	public FirstNumbersCalculator(String number) {
		
		try{
			foundPrimeNumbers = findNumberOfPrimeNumbers(Integer.parseInt(number));
		} catch (NumberFormatException e) {
			foundPrimeNumbers = -1;
		}
	}
	
	public int getNumberOfFoundPrimeNumbers() {
		return foundPrimeNumbers;
	}
	
	private int findNumberOfPrimeNumbers(int number) throws NumberFormatException{
		if (number <= 3) throw new NumberFormatException();
		int sumOfPrimeNumbers = -1;
		for(int i = 3; i <= number; i++) {
			if(i < 15) {
				int factorial = integerFactorial(i-2);
				sumOfPrimeNumbers += factorial - i * (factorial / i);
				continue;
			}
			if(i < 23) {
				long factorial = longFactorial(i-2);
				sumOfPrimeNumbers += factorial - i * (factorial / i);
				continue;
			}
			var factorial = BigIntegerFactorial(i-2);
			sumOfPrimeNumbers += factorial.subtract(new BigInteger(Integer.toString(i)).multiply(factorial.divide(new BigInteger(Integer.toString(i))))).intValue();
		}
		return sumOfPrimeNumbers;
	}

	private int integerFactorial(int number) {
		int toReturn = 1;
		for(int i = 2; i <= number && i < 13; i++) {
			toReturn *= i;
		}
		return toReturn;
	}
	
	private long longFactorial(int number) {
		long toReturn = integerFactorial(number);
		for(int i = 13; i <= number && i < 21; i++) {
			toReturn *= i;
		}
		return toReturn;
	}
	
	private BigInteger BigIntegerFactorial(int number) {
		var toReturn = new BigInteger(Long.toString(longFactorial(number)));
		for (int i = 21; i <= number; i++) {
			toReturn = toReturn.multiply(new BigInteger(Integer.toString(i)));
		}
		return toReturn;
	}
}
