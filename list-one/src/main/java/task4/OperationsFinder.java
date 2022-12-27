package task4;

import java.util.LinkedList;

public class OperationsFinder {

	private int goal;
	private int firstNumberInCalculation;
	private int lastNumberInCalculation;
	private LinkedList<String> foundCalculations;

	public OperationsFinder(int goal, int maximumNumber) {
		this.goal = goal;
		this.firstNumberInCalculation = 1;
		this.lastNumberInCalculation = maximumNumber;
		this.foundCalculations = findAllCalculations(1, 2, "");
	}

	public OperationsFinder(int goal, int minimumNumber, int maximumNumber) {
		this.goal = goal;
		this.firstNumberInCalculation = minimumNumber;
		this.lastNumberInCalculation = maximumNumber;
		this.foundCalculations = findAllCalculations(minimumNumber, minimumNumber + 1, "");
	}

	public int getAmountOfCalculations() {
		return this.foundCalculations.size();
	}

	public String toStringAt(int numberOfCalculation) {
		String toReturn = (numberOfCalculation + 1) + ":";
		for (int number = firstNumberInCalculation; number < lastNumberInCalculation; number++) {
			toReturn += " " + number + " "
					+ foundCalculations.get(numberOfCalculation).charAt(number - firstNumberInCalculation);
		}
		toReturn += " " + lastNumberInCalculation + " = " + goal;
		return toReturn;
	}

	private LinkedList<String> findAllCalculations(double num1, int num2, String previousOperations) {
		var toReturn = new LinkedList<String>();

		if (num2 == lastNumberInCalculation + 1) {
			if (num1 == goal)
				toReturn.add(previousOperations);
			return toReturn;
		}
		toReturn.addAll(findAllCalculations(num1 + num2, num2 + 1, previousOperations + "+"));
		toReturn.addAll(findAllCalculations(num1 - num2, num2 + 1, previousOperations + "-"));
		toReturn.addAll(findAllCalculations(num1 * num2, num2 + 1, previousOperations + "*"));
		toReturn.addAll(findAllCalculations(num1 / num2, num2 + 1, previousOperations + "/"));

		return toReturn;
	}
}
