package cscd211Methods;

import java.util.Scanner;

public class LinkedListMethods {

	public static int menu(Scanner scanner) {

		
		System.out.println("1) Print the List ");
		System.out.println("2) Create a BoxCar and addFirst ");
		System.out.println("3) Create a BoxCar and addLast ");
		System.out.println("4) Create a BoxCar, read and index and add -- at the index ");
		System.out.println("5) Create a BoxCar, check the list to see if the list contains the BoxCar ");
		System.out.println("6) Create a BoxCar, find the indexOf that BoxCar ");
		System.out.println("7) removeFirst");
		System.out.println("8) removeLast ");
		System.out.println("9) Read index remove Node at that index ");
		System.out.println("10) Create a BoxCar and removeFirstOccurrence of that BoxCar ");
		System.out.println("11) Create a BoxCar and removeLastOccurrence of that BoxCar ");
		System.out.println("12) clear the list ");
		System.out.println("13) Print the size of the list ");
		System.out.println("14) Quit ");
		
		System.out.println();
		System.out.println();
		System.out.println("Please choose from  1 from to 14");
		
	 
		 int index = Integer.parseInt(scanner.nextLine());
		 return index;
			 

	}

	public static String buildAString(Scanner scanner) {

		System.out.println("Please enter some text");
		String line = scanner.nextLine();

		return line;
	}

	public static int readIndex(Scanner scanner) {
		System.out.println("Please type index here");
		int index = Integer.parseInt(scanner.nextLine());
		return index;
	}
}
