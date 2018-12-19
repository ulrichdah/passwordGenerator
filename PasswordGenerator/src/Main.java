import java.util.Random;
import java.util.Scanner;


public class Main {
	
	static final int MIN_CHAR = 8;
	static final int START_UPPER = 65;
	static final int END_UPPER = 90;
	static final int START_LOWER = 97;
	static final int END_LOWER = 122;
	static final int START_NUMBERS = 48;
	static final int END_NUMBERS = 57;
	static final int MOD_VALUE_NO_SPECIAL_CHAR = 3;
	static final int USE_UPPER = 0;
	static final int USE_LOWER = 1;
	static final int USE_NUMBER = 2;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Password identifier:");
		String id = scan.nextLine();
		
		System.out.println("Use special characters ?(y/n)");
		String res = scan.nextLine();
		boolean useSpecialChar = (res == "Y" || res == "y");
		int minLimit = useSpecialChar ? 4 : 3;
		
		int limitInt;
		do {
			System.out.println("Limit for characters (must be more than " + minLimit + "):");
			String limit = scan.nextLine();
			limitInt = Integer.parseInt(limit);
		}while(limitInt < minLimit);
		
		Main generator = new Main();
		generator.addedLimitedPassword(limitInt, useSpecialChar, minLimit);
	}
	
	
	public void addedLimitedPassword(int limit, boolean useSpecialChar, int minLimit) {
		int numberOfChar = (limit <= MIN_CHAR) ? limit : this.getRandomInt(MIN_CHAR, limit);
		String newPassword = new String();
		for (int i = 0; i < numberOfChar - minLimit; i++) {
			if(!useSpecialChar) {
				int reference = this.getRandomInt(MOD_VALUE_NO_SPECIAL_CHAR, MOD_VALUE_NO_SPECIAL_CHAR * 10000);
				newPassword = this.addChar(reference % MOD_VALUE_NO_SPECIAL_CHAR, newPassword);
			}
		}
		
		this.addLower(newPassword);
		this.addUpper(newPassword);
		this.addNumber(newPassword);
		
		System.out.println(newPassword + "   BOUM");
	}
	
	
	private int getRandomInt(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}
	
	
	private String addChar(int charType, String newPassword) {
		switch (charType) {
		case USE_UPPER:
			newPassword = this.addUpper(newPassword);
			break;
		case USE_LOWER:
			newPassword = this.addLower(newPassword);
			break;
		case USE_NUMBER:
			newPassword = this.addNumber(newPassword);
			break;
		}
		return newPassword;
	}
	
	
	private String addUpper(String newPassword) {
		return newPassword + (char)this.getRandomInt(START_UPPER, END_UPPER);
	}
	
	
	private String addLower(String newPassword) {
		return newPassword + (char)this.getRandomInt(START_LOWER, END_LOWER);
	}
	
	
	private String addNumber(String newPassword) {
		return newPassword + (char)this.getRandomInt(START_NUMBERS, END_NUMBERS);
	}

}
