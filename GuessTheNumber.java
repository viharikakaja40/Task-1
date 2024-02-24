import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        
        System.out.println("Welcome to Guess the Number!");
        
        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I've picked a number between " + minRange + " and " + maxRange + ". Guess it!");
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Attempt #" + (attempts + 1) + ": Enter your guess: ");
                int guess = scanner.nextInt();
                
                if (guess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the number!");
                    guessedCorrectly = true;
                    score++;
                } else if (guess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
                
                attempts++;
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was: " + targetNumber);
            }
            
            System.out.print("Your current score: " + score + "\n\n");
            
            System.out.print("Would you like to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thanks for playing Guess the Number!");
    }
}