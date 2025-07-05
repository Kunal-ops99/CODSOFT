import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int score = 0;
        boolean playAgain = true;

        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("You have to guess a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You will get " + maxAttempts + " attempts per round.\n");

        while (playAgain) {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            while (attemptsLeft > 0) {
                System.out.print("🔢 Enter your guess (" + attemptsLeft + " attempts left): ");

                // Validate input
                if (!scanner.hasNextInt()) {
                    System.out.println("❗ Invalid input. Please enter a number.");
                    scanner.next();
                    continue;
                }

                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("✅ Correct! You guessed the number!");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("📉 Too low. Try a higher number.");
                } else {
                    System.out.println("📈 Too high. Try a lower number.");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've run out of attempts! The number was: " + numberToGuess);
            }

            System.out.println("🏆 Current Score: " + score);


            System.out.print("\n🔁 Do you want to play again? (yes/no): ");
            scanner.nextLine(); // consume newline
            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
            }

            System.out.println("--------------------------------------------\n");
        }

        System.out.println("🎉 Game Over! Your final score: " + score);
        System.out.println("Thank you for playing! 👋");
        scanner.close();
    }
}

 
    

