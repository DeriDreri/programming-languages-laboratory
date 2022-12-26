package task4;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class OperationsFinder {

	private int goal;
	private int firstNumberInCalculation;
	private int lastNumberInCalculation;
	private LinkedList<String> foundCalculations;
	
	OperationsFinder(int goal, int maximumNumber){
		this.goal = goal;
		this.firstNumberInCalculation = 1; 
		this.lastNumberInCalculation = maximumNumber;
		this.foundCalculations = findAllCalculations(1, 2, "");
	}
	
	OperationsFinder(int goal, int minimumNumber, int maximumNumber){
		this.goal = goal;
		this.firstNumberInCalculation = minimumNumber;
		this.lastNumberInCalculation = maximumNumber;
		this.foundCalculations = findAllCalculations(minimumNumber, minimumNumber+1, "");
	}
	
	public int getAmountOfCalculations() {
		return this.foundCalculations.size();
	}
	
	public String toStringAt(int numberOfCalculation) {
		String toReturn = (numberOfCalculation+1) + ":";
		for(int number = firstNumberInCalculation; number < lastNumberInCalculation; number++) {
			toReturn += " " + number + " " + foundCalculations.get(numberOfCalculation).charAt(number-firstNumberInCalculation); 
		}
		toReturn += " " + lastNumberInCalculation + " = " + goal;
		return toReturn;
	}
	
	public static void main(String[] args) {
		var operations = new OperationsFinder(69, 1, 9);
		if(operations.getAmountOfCalculations() == 0) {
			System.out.println("Brak rozwiązań");
			return;
		}
		for (int i = 0; i < operations.getAmountOfCalculations(); i++) {
			System.out.println(operations.toStringAt(i));
		}
	}
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * int goal = collectGoalFromUserTerminal();
	 * 
	 * var answers = findAllCalculations(1, 2, "", goal);
	 * 
	 * if (answers.size() == 0) System.out.println("Brak rozwiązań");
	 * 
	 * 
	 * int numberOfLine = 1; for (String calculations : answers) {
	 * System.out.println(numberOfLine++ + " : ((((1 " + calculations.charAt(0) +
	 * " 2) " + calculations.charAt(1) + " 3) " + calculations.charAt(2) + " 4) " +
	 * calculations.charAt(3) + " 5) " + calculations.charAt(4) + " 6 = " + goal); }
	 * 
	 * }
	 */

	/*
	 * public static int collectGoalFromUserTerminal() { int toReturn = 0; var
	 * userInput = new Scanner(System.in); try { System.out.
	 * println("Please input a natural number bigget than -1000 and smaler than 1000:"
	 * ); toReturn = userInput.nextInt(); if (toReturn <= -1000 || toReturn >= 1000)
	 * throw new InputMismatchException();
	 * 
	 * } catch (InputMismatchException e) { System.out.println("Wrong input");
	 * toReturn = collectGoalFromUserTerminal(); } finally { userInput.close(); }
	 * return toReturn; }
	 */

	private LinkedList<String> findAllCalculations(double num1, int num2, String previousOperations) {
		var toReturn = new LinkedList<String>();

		if (num2 == lastNumberInCalculation+1) {
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
