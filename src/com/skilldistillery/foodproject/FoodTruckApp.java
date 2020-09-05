package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		// create a Scanner for user input
		Scanner userInput = new Scanner(System.in);
		FoodTruckApp foodTruck = new FoodTruckApp();

		foodTruck.run(userInput);
	}

	public void run(Scanner userInput) {
		FoodTruck[] fTruckArr = new FoodTruck[5];
		createTruck(userInput, fTruckArr);

	}

	public void createTruck(Scanner userInput, FoodTruck[] fTruckArr) {
		// create local variables to hold userInput and evaluate truck name
		String tName = "";
		String foodType;
		int rating = 0;
		// prompt user to input up to 5 trucks(name, food type, and rating)
		// allow the user to type quit prior to entering five trucks
		for (int i = 0; i < 5; i++) {
			System.out.println("Please enter a truck name: ");
			tName = userInput.nextLine();
			// evaluate truck name for quit
			// if quit, break and show menu
			if (tName.equalsIgnoreCase("quit")) {
				break;
			} // otherwise, get remaining truck information
			else {
				System.out.println("Please enter the type of food served by this food truck: ");
				foodType = userInput.nextLine();
				System.out.println("Please enter a rating for this food truck: ");
				rating = userInput.nextInt();
				userInput.nextLine();
				// create Truck from user input
				FoodTruck foodTruck = new FoodTruck(tName, foodType, rating);
				for (int j = 0; j < 5; j++) {
					fTruckArr[i] = foodTruck;
				}
			}
		}
		showMenu(userInput, fTruckArr);

	}

	// show menu: list all trucks, average rating, highest-rated, and quit
	// keep showing menu until quit
	private void showMenu(Scanner userInput, FoodTruck[] fTruckArr) {
		System.out.println();
		System.out.println("==================== MENU ====================");
		System.out.println("|                                            |");
		System.out.println("|  1. List all existing food trucks.         |");
		System.out.println("|  2. See the average rating of food trucks. |");
		System.out.println("|  3. Display the highest-rated food truck   |");
		System.out.println("|  4. Quit the program.                      |");
		System.out.println("|                                            |");
		System.out.println("==============================================");
		System.out.println();
		menuAction(userInput, fTruckArr);
	}

	// menu selection action
	private void menuAction(Scanner userInput, FoodTruck[] fTruckArr) {
		String menuSelection = userInput.next();
		boolean keepGoing = true;
		while (keepGoing) {
			switch (menuSelection) {
			case "1":
				// get all trucks
				userInput.nextLine();
				showAllTrucks(userInput, fTruckArr);
				// display each truck
				break;
			case "2":
				userInput.nextLine();
				getAverageTruckRating(userInput, fTruckArr);
				break;
			case "3":
				userInput.nextLine();
				getHighestRatedTruck(userInput, fTruckArr);
				break;
			case "4":
				userInput.nextLine();
				System.out.println("You opted to quit. Have a nice day! Goodbye!");
				keepGoing = false;
				System.exit(0);
				break;
			default:
				System.out.println("Invalid selection. Please enter a number 1 - 4.");
				break;
			}
		}
	}

	// call toString for each truck in our FoodTruck arr
	public void showAllTrucks(Scanner userInput, FoodTruck[] fTruckArr) {
		for (int i = 0; i < fTruckArr.length; i++) {
			if (fTruckArr[i] != null) {
				System.out.println(fTruckArr[i].toString());
			}
		}
		showMenu(userInput, fTruckArr);
	}

	private void getAverageTruckRating(Scanner userInput, FoodTruck[] fTruckArr) {
		// create a local variable to hold a sum and number of not null trucks
		int sum = 0;
		int validTrucks = 0;
		// iterate the food truck arr
		// obtain the rating for each truck
		for (int i = 0; i < fTruckArr.length; i++) {
			if (fTruckArr[i] != null) {
				sum += fTruckArr[i].getTruckRating();
				validTrucks++;
			}
		}
		System.out.println("The average truck rating is " + sum / validTrucks);
		showMenu(userInput, fTruckArr);
	}

	private void getHighestRatedTruck(Scanner userInput, FoodTruck[] fTruckArr) {
		// create local variable to evaluate against
		int highestRating = 0;
		String truckName = "";
		int currentTruckRating = 0;
		FoodTruck[] ft = new FoodTruck[5];
		int countTrksWithHighestRate = 0;

		// iterate the input array
		for (int i = 0; i < fTruckArr.length; i++) {
			// check for !null
			if (fTruckArr[i] != null) {
				// set local variable to this trucks rating
				currentTruckRating = fTruckArr[i].getTruckRating();
				// evaluate local variable against highestRating
				if (currentTruckRating > highestRating) {
					// if the current truck's rating is higher, save it's rating
					highestRating = currentTruckRating;
					// get the trucks name for string output
					truckName = fTruckArr[i].getTruckName();
					// in case another truck has the same rating add current truck to local truck
					// array
					ft[countTrksWithHighestRate] = fTruckArr[i];
					// increment count
					countTrksWithHighestRate++;

				} // if more than one truck has the same highest rating
				else if (currentTruckRating == highestRating) {
					// add the current truck to the local truck array
					ft[countTrksWithHighestRate] = fTruckArr[i];
					// increment count
					countTrksWithHighestRate++;
				}
			}
		}
		// print out the local array holding all the trucks with the highest rating
		if (ft.length == 1) {
			System.out.println("The " + ft[0].getTruckName() + " truck has the highest rating of a " + highestRating);
			System.out.println(ft[0].toString());
		} else {
			System.out.println("The following trucks had the highest rating of " + highestRating + ".");
			for (int i = 0; i < ft.length; i++) {
				if (ft[i] != null) {
					if (ft[i].getTruckRating() == highestRating) {
						System.out.println(ft[i].toString());
					}
				}
			}

		}
		showMenu(userInput, fTruckArr);
	}
}