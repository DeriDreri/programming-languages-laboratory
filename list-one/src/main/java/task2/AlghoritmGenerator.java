package task2;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.naming.LimitExceededException;

public class AlghoritmGenerator {

	ArrayList<Integer> numbersSequence;
	ArrayList<String> oddOrEvenSequence;

	AlghoritmGenerator(int number) {
		generateSequence(number);
	}

	public void generateSequence(int number) {
		var numbersSequenceBuff = new LinkedList<Integer>();
		var oddOrEvenBuffList = new LinkedList<String>();
		numbersSequenceBuff.add(number);
		for (int i = 1; i <= 1000; i++)
			try {
				numbersSequenceBuff.add(findNextNumber(numbersSequenceBuff.get(i - 1), oddOrEvenBuffList));
				if(numbersSequenceBuff.getLast() == 1) break;
			} catch (LimitExceededException e) {
				break;
			}
		numbersSequence = new ArrayList<Integer>(numbersSequenceBuff);
		oddOrEvenSequence = new ArrayList<String>(oddOrEvenBuffList);
	}

	public static void main(String[] args) {
		var algoritm = new AlghoritmGenerator(27);
		System.out.println(algoritm.toString());
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		for (int i = 0; i < numbersSequence.size() - 1; i++) {
			toReturn += numbersSequence.get(i) + " -> " + oddOrEvenSequence.get(i) + " -> " + numbersSequence.get(i+1) + "\n"; 
		}
		return toReturn;
	}

	private int findNextNumber(int number, LinkedList<String> oddOrEven) throws LimitExceededException {
		int toReturn;

		if (number % 2 == 0) {
			toReturn = number / 2;
			oddOrEven.add("Even");
		} else {
			toReturn = number * 3 + 1;
			oddOrEven.add("Odd");
		}
		if (toReturn < 0)
			throw new LimitExceededException();
		return toReturn;
	}

}
