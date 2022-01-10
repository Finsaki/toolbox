package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * First implemented tool
 * Uses random numbers to calculate wanted amount of numbers from given size pool of numbers
 * 
 * @author akiko
 * @version 1.0 10.01.2022
 *
 */
public class LotteryTool implements ITool {
	
	private ArrayList<Integer> numbers;
	private Random rand = new Random();

	public void startToolService(Rules rules) {
		numbers = new ArrayList<>();
		calculateRandomNumbers(rules.getSize(), rules.getAmount());
	}

	public ArrayList<String> returnResults() {
		ArrayList<String> numbersAsString = new ArrayList<>();
		Collections.sort(numbers);
		numbers.forEach(number -> numbersAsString.add(number.toString()));
		return numbersAsString;
	}
	
	private void calculateRandomNumbers(int numberPoolSize, int amountOfNumbers) {
		int i = 0;
		while (i < amountOfNumbers) {
			int randomNumber = rand.nextInt(numberPoolSize) + 1;
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
				i++;
			}
		}
	}
	
}
