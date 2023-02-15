package madLibs;

import java.util.Scanner;

public class Interpreter {

	public static void run() {
//		find all <> store in a new array
//		ask for type with some fun text using all locations in the array
//		run scanner ^
//		put answers into the array 
//		display
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a valid MadLib: ");
		MadLib madLib = loadLib(scanner.nextLine());
		askUser(madLib, findBlanks(madLib));
		
		System.out.println("Would you like to try again? y/n");
		if(scanner.nextLine().charAt(0) == 'y') {
			run();
		}
		else {
			System.out.println("Thanks for Playing!");
		}
	}
	
	private static MadLib loadLib(String str) {
		MadLib lib = new MadLib(str);
		return lib;
	}
	
	private static int[] findBlanks(MadLib lib) {
		int[] storageArray = new int[50];
		int storageCounter = 0;
		int arrayCounter = 0;
		while(lib.getArray()[arrayCounter] != null) {
			if(lib.getArray()[arrayCounter].charAt(0) == '<') {
				storageArray[storageCounter] = arrayCounter;
				storageCounter++;
			}
			arrayCounter++;
		}
		return storageArray;
	}
	
	private static void scan(MadLib lib, int index) {
		Scanner scanner = new Scanner(System.in);
		lib.userInput(index, scanner.next());
	}
	
	private static void askUser(MadLib lib, int[] location) {
		int counter = 0;
		if(location[0] == 0) {
			System.out.println("System Shutdown, please enter a valid MadLib");
		}
		else {
			while(location[counter] != 0) {
				int i = 1;
				String ret = "";
				while(lib.getArray()[location[counter]].charAt(i) != '>') {			
					ret += String.valueOf(lib.getArray()[location[counter]].charAt(i));
					i++;
				}
				System.out.println("Quick! Give me a " + ret + "!");
				scan(lib, location[counter]);
				
				counter++;
				
			}
			
			System.out.println(lib.toString());
		}
	}
	public static void main(String[] args) {
		run();
	}
}
