package studio2;
import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("How much money to begin with?");
		double startAmount = in.nextDouble();
		double money = startAmount;
		System.out.println("What's your winChance?");
		double winChance = in.nextDouble();
		System.out.println("What's your winLimit?");
		double winLimit = in.nextDouble();
		System.out.println("How many days you'll be visiting us?");
		int totalSimulation = in.nextInt();
		int currentTime = 0;
		int playTime = 0;
		String status;
		int lose = 0;
		int win = 0;
		
		while (currentTime < totalSimulation) {
			money = startAmount;
			playTime = 0;
			while (money > 0 && money < winLimit) {
				double play = Math.random()*100.0;
				if (play <= winChance) {
					money++;
				}
				else {
					money--;
				}
				playTime++;
			}
			if (money <= 0) {
				status = "LOSE";
				lose++;
				//System.out.println("Ruin!");
			}
			else {
				status = "WIN";
				win++;
				//System.out.println("Success!");
			}
			currentTime++;
			System.out.println("Simulation " + currentTime + ": " + playTime + " " + status);
		}
		System.out.println("Losses: " + lose + " Simulations: " + totalSimulation);
		double alpha = (1-winChance/100.0)/(winChance/100.0);
		double eRuin;
		if (winChance == 50) {
			eRuin = 1 - (startAmount)/winLimit;
		}
		else {
			eRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit))/(1-Math.pow(alpha, winLimit));
		}
		System.out.println("Ruin Rate from Simulation: " + lose/totalSimulation + " Expected Ruin Rate: " + eRuin);
	}

}
