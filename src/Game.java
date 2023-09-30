import java.util.Scanner;
public class Game {
    private static final int EASY = 10;
    private static final int MEDIUM= 100;
    private static final int HARD = 1000;

    public static void playGame(Scanner scanner) {
        String userInput;
        int userGuess;
        int attempts;
        boolean restart;
        boolean win;

        do {
            userGuess = 0;
            attempts = 0;
            restart = true;
            win = false;

            System.out.println("Welcome to Guess The Number!");
            System.out.println("Select your difficulty");
            System.out.println("1 = Easy (1-10)");
            System.out.println("2 = Medium (1-100)");
            System.out.println("3 = Hard (1-1000)");

            int difficultyLevel = getUserInput(scanner, 1, 3);

            int upperBound;
            int maxAttempts;

            switch (difficultyLevel) {
                case 1:
                    System.out.println("You've selected the Easy mode!");
                    upperBound = EASY;
                    maxAttempts = 10;
                    break;
                case 2:
                    System.out.println("You're going for the Medium challenge! It's not too easy, not too hard!");
                    upperBound = MEDIUM;
                    maxAttempts = 10;
                    break;
                case 3:
                    System.out.println("Brace yourself! You're going for the Hard mode!");
                    upperBound = HARD;
                    maxAttempts = 10;
                    break;
                default:
                    System.out.println("Difficulty not available.");
                    return;
            }

            int randomNumber = (int) (Math.random() * upperBound) + 1;

            do {
                userGuess = getUserInput(scanner, 1, upperBound);

                if (userGuess > randomNumber) {
                    System.out.println("The number you are looking for is lower!");
                } else if (userGuess < randomNumber) {
                    System.out.println("The number you are looking for is higher!");
                } else {
                    System.out.println("You've found the right number!");
                    win = true;
                }

                attempts++;
            } while (attempts < maxAttempts && !win);

            if (win) {
                System.out.println("Congratulations! You've won!");
            } else {
                System.out.println("Game Over! You've Lost!");
            }

            System.out.println("Would you like to play again? (1 = Yes, 0 = No)");
            restart = getUserInput(scanner, 0, 1) == 1;

        } while (restart);
    }
    public static int getUserInput(Scanner scanner, int lowerBound, int upperBound) {
        int userInput = 0;
        do {
            try {
                System.out.printf("Enter a number between %d and %d!%n", lowerBound, upperBound);
                userInput = Integer.parseInt(scanner.nextLine());

                if (userInput < lowerBound || userInput > upperBound) {
                    System.out.printf("Please enter a number between (%d and %d)%n", lowerBound, upperBound);
                }

            } catch (NumberFormatException nfe) {
                System.out.println("Input Error: " + nfe);
                System.out.printf("Please enter a valid number between (%d and %d)%n", lowerBound, upperBound);
            }
        } while (userInput < lowerBound || userInput > upperBound);
        return userInput;
    }
}


