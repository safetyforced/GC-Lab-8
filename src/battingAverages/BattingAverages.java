package battingAverages;

import java.util.Scanner;

public class BattingAverages {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean userConsent = true;
		System.out.println("Welcome to the Batting Average Calculator!\n");

		while (userConsent) {

			System.out.print("Enter number of times and bat: ");
			int onPlate = input.nextInt();
			double[] basesEarned = new double[onPlate];

			for (int i = 0; i < onPlate; i++) {
				System.out.print("Result for at-bat: ");
				basesEarned[i] = input.nextDouble();
				if (basesEarned[i] < 0 || basesEarned[i] > 4) {
					System.out.println("Dude, learn baseball.");
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
			if (cont.equalsIgnoreCase("n")) {
				userConsent = false;
			}
			
		}
		input.close();
		System.out.println("Bye.");
	}

	public static double bAvg(double[] bases) {
		double hits = 0.0;
		for (int i = 0; i < bases.length; i++) {
			if (bases[i] > 0) {
				hits++;
			}
		}
		double average = (hits / bases.length);
		return average;

	}
	public static double sAvg(double[] bases) {
		double slug = 0.0;
		for (int i = 0; i < bases.length; i++) {
			slug += bases[i];
		}
		double average = (slug / bases.length);
		return average;

	}
	
}
