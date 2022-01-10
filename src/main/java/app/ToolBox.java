package app;

import java.util.Scanner;

/**
 * Combines all the different tools into one app
 * 
 * ---MVC, change to function as an engine MODEL later, move UI to VIEW?
 * 
 * @author akiko
 * @version 1.0 10.01.2022
 *
 */
public class ToolBox {
	
	//Switch away from static later
	private static ITool lotteryTool;
	
	public void startToolBox() {
		lotteryTool = new LotteryTool();
		Scanner scan = new Scanner(System.in);
		showTextUI(scan);
		scan.close();
	}
	
	private static void showTextUI(Scanner scan) {
		System.out.println("Welcome to toolbox!\n");
		
		String input = "";
		
		while (!input.equals("4")) {
			System.out.println("\n-----\nInput 1 to get lottery numbers\nInput 2 to -?-\nInput 3 to -?-\nInput 4 to exit program\n-----\n");
			input = scan.nextLine();
			if (input.equals("1")) {
				showLotteryUI(scan);
			}
			if (input.equals("2")) {
				System.out.println("Not implemented");
			}
			if (input.equals("3")) {
				System.out.println("Not implemented");
			}
		}
		
		System.out.println("ByeBye!");
	}
	
	private static void showLotteryUI(Scanner scan) {
		String input = "";
		int poolSize = 50;
		int amountOfNum = 7;
		while (!input.equals("3")) {
			System.out.format("\n-----\nCurrent values are: Poolsize - %d, Amount of numbers - %d \n-----\n", poolSize, amountOfNum);
			System.out.println("\n-----\nInput 1 to use current values\nInput 2 to change values\nInput 3 to exit lottery tool\n-----\n");
			input = scan.nextLine();
			if (input.equals("1")) {
				try {
					lotteryTool.startToolService(new Rules(poolSize, amountOfNum));
					System.out.println("\n-----\nLottery numbers are:\n-----\n");
					System.out.println(lotteryTool.returnResults());
				} catch (Exception e) {
					System.out.println("\n-----\nMake sure poolsize is greater than amount of numbers\n-----\n");
				}
			}
			if (input.equals("2")) {
				System.out.println("\n-----\nPlease input new poolsize:\n-----\n");
				String inputSize = scan.nextLine();
				System.out.println("\n-----\nPlease input new amount of numbers:\n-----\n");
				String inputAmount = scan.nextLine();
				try {
					poolSize = Integer.valueOf(inputSize);
					amountOfNum = Integer.valueOf(inputAmount);
				} catch (Exception e) {
					System.out.println("\n-----\nIllegal values, make sure to input integers\n-----\n");
				}
			}
		}
	}

}