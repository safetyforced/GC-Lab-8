package battingAverages;
/**
 * @author Alex Marks
 * Batting Average Calculator
 */

import java.util.Scanner;

public class BattingAverages {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean userConsent = true;
		boolean userStupid = false;
		System.out.println("Welcome to the Batting Average Calculator!\n");

		do {

			System.out.print("Enter number of times at bat: ");
			int onPlate = input.nextInt();
			double[] basesEarned = new double[onPlate];  //create array sized proportionally to the number of hits

			for (int i = 0; i < onPlate; i++) {  //ask user for each instance at bat. (Room for improvement here?  string split and parse?)
				System.out.print("Result for at-bat: ");
				basesEarned[i] = input.nextDouble();
				if (basesEarned[i] < 0 || basesEarned[i] > 4) {
					System.out.println("Dude, learn baseball.");  //insult user
					i--;
				}

			}

			double batAvg = bAvg(basesEarned);
			double slugAvg = sAvg(basesEarned);

			System.out.println("Batting Average: " + batAvg);
			System.out.println("Slugging Percentage: " + slugAvg);

			
			System.out.println("Another batter? (y/n:)");
			String cont = input.next();
			input.nextLine();
			do {
			if (cont.equalsIgnoreCase("n")) {
				userConsent = false;
				userStupid = false;
			} else if (cont.equalsIgnoreCase("y")){
				userStupid = false;
				continue;
			} else {
				System.out.println("Please enter \"y\" or \"n\" only!  Continue? (y/n): ");
				cont = input.nextLine();
				userStupid = true;
			}
			} while (userStupid);
		} while (userConsent);
		input.close();
		System.out.println("You're beautiful.");  //compliment user
	}

	public static double bAvg(double[] bases) {  //calculate batting average
		double hits = 0.0;
		for (int i = 0; i < bases.length; i++) {
			if (bases[i] > 0) {
				hits++;  //increment variable for each instance a hit was made
			}
		}
		double average = (hits / bases.length);
		return average;

	}

	public static double sAvg(double[] bases) {  //calculate slugging percentage
		double slug = 0.0;
		for (int i = 0; i < bases.length; i++) {
			slug += bases[i];  //add total number of bases taken
		}
		double average = (slug / bases.length);
		return average;

	}

}
