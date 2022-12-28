package task3;

public class PartialSumsFinder {

	
	private int amountOfSums;

	public PartialSumsFinder(int number) {
		this.calculatePartialSums(number, 0);
	}

	public static void main(String[] args) {
		var operations = new PartialSumsFinder(6);
		System.out.println(operations.howManyPartialSumsCombinations());
	}
	
	public void giveNumberToAnalyse(int number) {
		this.calculatePartialSums(number, 0);
	}
	
	public int howManyPartialSumsCombinations() {
		return this.amountOfSums-1;
	}

	private void calculatePartialSums(int currentRemainingSum, int previousPartialSum) {
		int threshold = currentRemainingSum / 2;
		for (int i = previousPartialSum + 1; i <= threshold; i++) {
			calculatePartialSums(currentRemainingSum - i, i);
		}
		int i = threshold;
		while (true) {
			i++;
			if (currentRemainingSum - i == 0) {
				this.amountOfSums++;
				break;
			}
			if (currentRemainingSum - i < 0)
				break;
		}
	}
}
