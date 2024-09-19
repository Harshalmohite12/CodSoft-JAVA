import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playAgain;

        do {
            System.out.println("Choose difficulty: 1 for Easy, 2 for Medium, 3 for Hard");
            int difficulty = sc.nextInt();
            int numberToGuess = 0;
            int maxAttempts = 0;
            int hintAttempt = 0;

            if (difficulty == 1) {
                maxAttempts = 10;
                numberToGuess = (int)(Math.random() * 50) + 1;
                hintAttempt = 5; // Giving hint after 5 attempts for Easy
            } else if (difficulty == 2) {
                maxAttempts = 7;
                numberToGuess = (int)(Math.random() * 100) + 1;
                hintAttempt = 4; // Giving hint after 4 attempts for Medium
            } else if (difficulty == 3) {
                maxAttempts = 5;
                numberToGuess = (int)(Math.random() * 200) + 1;
                hintAttempt = 3; // Giving hint after 3 attempts for Hard
            } else {
                System.out.println("Invalid difficulty level selected. Defaulting to Medium.");
                maxAttempts = 7;
                numberToGuess = (int)(Math.random() * 100) + 1;
                hintAttempt = 4;
            }

            int userGuess = 0;
            int attempts = 0;
            int score = 100;

            while (userGuess != numberToGuess && attempts < maxAttempts) {
                System.out.print("Guess the number (between 1 and " + (difficulty == 1 ? 50 : difficulty == 2 ? 100 : 200) + "): ");
                userGuess = sc.nextInt();
                attempts++;
                score = 100 - (attempts - 1) * 10;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + numberToGuess);
                    System.out.println("Your score: " + score);
                    break;
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));

                // Provide hint after a certain number of wrong guesses based on difficulty
                if (attempts == hintAttempt) {
                    if (numberToGuess % 2 == 0) {
                        System.out.println("Hint: The number is even.");
                    } else {
                        System.out.println("Hint: The number is odd.");
                    }
                }
            }

            if (userGuess != numberToGuess && attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + numberToGuess);
                System.out.println("Game Over");
                System.out.println("Your score: 0");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        sc.close();
        System.out.println("Thank you for playing!");
    }
}