import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    static final int MIN = 1;
    static final int MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("***** WELCOME TO NUMBER GUESSING GAME *****");

        while (true) {
            System.out.println("\nCHOOSE THE LEVEL OF DIFFICULTY:");
            System.out.println("1. SIMPLE");
            System.out.println("2. MODERATE");
            System.out.println("3. DIFFICULT");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            int totalAttempts = getAttemptsByChoice(choice);
            if (totalAttempts == 0) {
                System.out.println("Invalid Input");
                continue;
            }

            int number = random.nextInt(MAX) + MIN;
            int score = playGame(scanner, number, totalAttempts);

            System.out.println("Do you want to continue playing the game?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter your choice: ");

            int cont = scanner.nextInt();
            if (cont != 1) {
                break;
            }
        }

        System.out.println("GAME OVER");
    }

    static int getAttemptsByChoice(int choice) {
        switch (choice) {
            case 1:
                return 6;
            case 2:
                return 4;
            case 3:
                return 2;
            default:
                return 0;
        }
    }

    static int playGame(Scanner scanner, int number, int totalAttempts) {
        int attempts = 0;
        int scoreMultiplier = 40 / totalAttempts;

        while (attempts < totalAttempts) {
            System.out.println("\nGuess the number between " + MIN + " and " + MAX);
            int guess = scanner.nextInt();
            attempts++;

            if (guess == number) {
                int score = scoreMultiplier * (totalAttempts - attempts + 1);
                System.out.println("CONGRATULATIONS!!! You have guessed the number successfully.");
                System.out.println("Score = " + score);
                System.out.println("Attempts = " + attempts);
                return score;
            } else if (guess > number) {
                System.out.println("The number is less than " + guess + ". Attempts left = " + (totalAttempts - attempts + 1));
            } else {
                System.out.println("The number is greater than " + guess + ". Attempts left = " + (totalAttempts - attempts + 1));
            }
        }

        System.out.println("Better Luck Next Time. You have failed to guess the number.");
        System.out.println("The random number is " + number);
        return 0;
    }
}