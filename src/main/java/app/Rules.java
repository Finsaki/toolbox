package app;

/**
 * Rules for Lotterytool
 * 
 * ---Usable in other tools? If not rename to LotteryToolRules
 * 
 * @author akiko
 * @version 1.0 10.01.2022
 *
 */
public class Rules {
	
	private int size;
	private int amount;
	private static final String EXCEPTIONTEXT = "Parameters are not valid!";
	
	public Rules(int poolSize, int numberAmount) {
		if (checkRules(poolSize, numberAmount)) {
			throw new IllegalArgumentException(EXCEPTIONTEXT);
		}
		this.size = poolSize;
		this.amount = numberAmount;
	}
	
	private boolean checkRules(int size, int amount) {
		return (size < amount || size < 1 || amount < 1);
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		if (checkRules(size, this.amount)) {
			throw new IllegalArgumentException(EXCEPTIONTEXT);
		}
		this.size = size;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		if (checkRules(this.size, amount)) {
			throw new IllegalArgumentException(EXCEPTIONTEXT);
		}
		this.amount = amount;
	}

}
