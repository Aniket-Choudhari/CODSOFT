import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        // Initialize the scanner for user input and random for generating random numbers
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Variable to control if the user wants to play again
        boolean playAgain = true;
        
        while (playAgain) {
            // Generate a random number between 1 and 100
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            final int maxAttempts = 10; // Max attempts allowed
            boolean hasGuessedCorrectly = false;

            System.out.println("I have generated a random number between 1 and 100. Can you guess it?");
            
            while (numberOfAttempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                // Compare user's guess with the generated number
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                System.out.println("Attempts left: " + (maxAttempts - numberOfAttempts));
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess);
            }

            // Prompt the user to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        // Thank the user for playing
        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}
