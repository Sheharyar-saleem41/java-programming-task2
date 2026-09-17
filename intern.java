import java.util.Random;
import java.util.Scanner;

public class intern {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        String playAgain = "yes";

        System.out.println("------------------------");
        System.out.println("  NUMBER GUESSING GAME");
        System.out.println("------------------------");

        while (playAgain.equalsIgnoreCase("yes")) {

            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessed = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                if (!input.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    input.next();
                    continue;
                }

                int guess = input.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                if (guess == secretNumber) {
                    guessed = true;

                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("\nCongratulations!");
                    System.out.println("You guessed the correct number.");
                    System.out.println("Attempts used: " + attempts);
                    System.out.println("Round score: " + score);
                    break;
                } 
                else if (guess < secretNumber) {
                    System.out.println("Too Low! Try again.");
                } 
                else {
                    System.out.println("Too High! Try again.");
                }
            }

            if (!guessed) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = input.next();
        }

        System.out.println("\n------------------------");
        System.out.println("       THANK YOU FOR PLAYING");
        System.out.println("       Final Score: " + totalScore);
        System.out.println("------------------------");

        input.close();
    }
}