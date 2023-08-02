import java.util.Random;
import java.util.Scanner;

public class Number_Guessing_game {
    public static void main(String[] args) {
        int minNum = 1; 
        int maxNum = 1000;
        int targetNum;
        int guess;
        int attempts = 0;
        int maxAttempts = 15;
        int score = 0;
        boolean gameOver = false;

        Random random = new Random();
        targetNum = random.nextInt(maxNum - minNum + 1) + minNum;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            System.out.println("Round " + (score + 1));
            System.out.println("I'm thinking of a number between " + minNum + " and " + maxNum);

            while (!gameOver && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < targetNum) {
                    System.out.println("Too low!");
                } else if (guess > targetNum) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You have guessed the correct number in " + attempts + " attempts!");
                    score++;
                    gameOver = true;
                }
            }

            if (!gameOver) {
                System.out.println("Game over! You couldn't guess the number. The correct number was: " + targetNum);
            } else {
                System.out.println("Your current score: " + score);
                System.out.print("Do you want to play another round? (y/n): ");
                String playAgain = scanner.next();
                if (playAgain.equalsIgnoreCase("y")) {
                    targetNum = random.nextInt(maxNum - minNum + 1) + minNum;
                    attempts = 0;
                    gameOver = false;
                } else {
                    System.out.println("Thank you for playing the Number Guessing Game!");
                }
            }
        } while (!gameOver);

        scanner.close();
    }
}