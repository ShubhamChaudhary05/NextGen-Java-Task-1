import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            System.out.print("Enter the lower bound of the range: ");
            int lowerBound = scanner.nextInt();

            System.out.print("Enter the upper bound of the range: ");
            int upperBound = scanner.nextInt();

            if (lowerBound >= upperBound) {
                System.out.println("Invalid range. Lower bound should be less than upper bound. Please try again.");
                continue;
            }

            int numberToGuess = random.nextInt((upperBound - lowerBound) + 1) + lowerBound;
            int maxAttempts = 10;
            int attempts = 0;

            System.out.println("\nI have generated a number between " + lowerBound + " and " + upperBound + ". You have " + maxAttempts + " attempts to guess it.");

            boolean guessedCorrectly = false;
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine();  // Consume newline
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing the Number Guessing Game! Your score: " + score);
        System.out.println("Goodbye!");
        scanner.close();
    }
}