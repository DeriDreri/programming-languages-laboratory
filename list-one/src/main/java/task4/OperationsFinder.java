package task4;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class OperationsFinder {

	public static void main(String[] args) {

		int goal = collectGoalFromUser();

		var answers = findAllCalculations(1, 2, "", goal);

		if (answers.size() == 0)
			System.out.println("Brak rozwiązań");

		for (String calculations : answers) {
			System.out.println("((((1 " + calculations.charAt(0) + " 2) " + calculations.charAt(1) + " 3) "
					+ calculations.charAt(2) + " 4) " + calculations.charAt(3) + " 5) " + calculations.charAt(4)
					+ " 6 = " + goal);
		}

	}

	public static int collectGoalFromUser() {
		int toReturn = 0;
		var userInput = new Scanner(System.in);
		try {
			System.out.println("Please input a natural number bigget than -1000 and smaler than 1000:");
			toReturn = userInput.nextInt();
			if (toReturn <= -1000 || toReturn >= 1000)
				throw new InputMismatchException();

		} catch (InputMismatchException e) {
			System.out.println("Wrong input");
			toReturn = collectGoalFromUser();
		} finally {
			userInput.close();
		}
		return toReturn;
	}

	public static LinkedList<String> findAllCalculations(double num1, int num2, String previousOperations, int goal) {
		var toReturn = new LinkedList<String>();

		if (num2 == 7) {
			if (num1 == goal)
				toReturn.add(previousOperations);
			return toReturn;
		}
		toReturn.addAll(findAllCalculations(num1 + num2, num2 + 1, previousOperations + "+", goal));
		toReturn.addAll(findAllCalculations(num1 - num2, num2 + 1, previousOperations + "-", goal));
		toReturn.addAll(findAllCalculations(num1 * num2, num2 + 1, previousOperations + "*", goal));
		toReturn.addAll(findAllCalculations(num1 / num2, num2 + 1, previousOperations + "/", goal));

		return toReturn;
	}

}
