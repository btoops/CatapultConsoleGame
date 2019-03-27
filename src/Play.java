/**
 * Brandon Toops, Patrick Phillips
 * btoops       , pphill10
 * Project 01
 * MW 2:00 pm - 3:15 pm
 * 
 * Sep 20, 2017
 */
import java.util.Scanner;


public class Play {


	public static void main(String[] args) {
		final double GRAVITY = 9.8;
		int distanceToWall, heightOfWall;
		double angle = 0, velocity, heightOfProjectile;
		boolean play = true;
		int score = 1;
		Scanner scanner = new Scanner(System.in);


		System.out.print("Do you want to play? (true or false) ");
		//checks for a boolean
		while(!scanner.hasNextBoolean()) {
			System.out.print("True or false numbnuts. Try again: ");
			scanner.next();
		}
		play = scanner.nextBoolean();

		while(play) {
			heightOfWall = (int) (Math.random() * 20 + 7); //wall height between 7 and 26
			distanceToWall = (int) (Math.random() * 50 + 5); //distance to the wall between 5 and 54
			System.out.println("The catapult is " + distanceToWall + " meters away from a wall which is " + heightOfWall + " meters tall");
			System.out.print("Enter the angle to fire the projectile: ");
			
			
			

			//checks to make sure the number entered is a double > 0
			do {
				while(!scanner.hasNextDouble()) {
					System.out.print("You have to enter numbers. Try again: ");
					scanner.next();
				}
				angle = scanner.nextDouble();
				if(angle < 0) {
					System.out.println("You just entered a negative angle... Are you okay?");
					System.out.print("Try again: ");
				}
				if(angle == 0)
					System.out.print("You can't enter in zero. Try again: ");
			}while(angle <= 0);


			System.out.print("Enter the velocity of the projectile: ");

			//checks to make sure the number entered is a double > 0
			do {
				while(!scanner.hasNextDouble()) {
					System.out.print("You have to enter numbers. Try again: ");
					scanner.next();
				}
				velocity = scanner.nextDouble();
				if(velocity < 0) {
					System.out.println("Are you trying to fire backwards?");
					System.out.print("Try again: ");
				}
				if(angle == 0) {
					System.out.print("You can't enter a zero. Try again: ");
				}
			}while(velocity <= 0);

			score --;
			heightOfProjectile = (distanceToWall * Math.tan(angle * Math.PI/180)) - 
					(((GRAVITY) * Math.pow(distanceToWall, 2))/
							(2 * Math.pow(velocity * Math.cos(angle * Math.PI/180), 2)));

			System.out.println("Height of projectile: " + heightOfProjectile);

			if(heightOfProjectile >= heightOfWall + 3) { //projectile is 3 meters above the wall
				String[] s = {"There was plenty of room.", "That was way too high.", "The projectile went way over." };
				System.out.println(s[(int) (Math.random() * 3)]);
				score += 2;
			}
			else if (heightOfProjectile > heightOfWall) { //projectile is between 3 meters and height of wall
				String[] s = {"You made it!", "Nice shot!", "Masterfully done."};
				System.out.println(s[(int) (Math.random() * 3)]);
				score += 5;
			}
			else if (heightOfProjectile >= heightOfWall - 3) { //projectile is three meters or less from the top of the wall
				String[] s = {"You didn't quite make it.", "Close!", "Not quite."};
				System.out.println(s[(int) (Math.random() * 3)]);
				score -= 1;
			}
			else { //projectile is more than 3 meters from the top
				String[] s = {"Not even close.", "Are you even trying?", "Did you even take physics? That wasn't close."};
				System.out.println(s[(int) (Math.random() * 3)]);
				score -= 3;
			}

			System.out.println("Your score after this round is: " + score);
			if(score < 0)
				System.out.println("You aren't very good at this, are you?");
			System.out.println();

			System.out.print("Do you want to play again? (true or false) ");
			//checks for a boolean
			while(!scanner.hasNextBoolean()) {
				System.out.print("True or false numbnuts. Try again: ");
				scanner.next();
			}
			play = scanner.nextBoolean();


		}

		scanner.close();

	}


}
