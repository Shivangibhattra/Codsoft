import java.util.Scanner;

public class NumberGame {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
// Generate random number between 1 and 100
    int numberToGuess = (int) (Math.random() * 100) + 1; 
// Number of guesses allowed
    int numGuesses = 5; 

    System.out.println("Welcome to the Number Game!");

    while (numGuesses > 0) {
      System.out.printf("Guess a number between 1 and 100 (You have %d guesses remaining): ", numGuesses);
      int guess = scanner.nextInt();

      if (guess == numberToGuess) {
        System.out.println("Congratulations! You guessed the number!");
        break;
      } else if (guess < numberToGuess) {
        System.out.println("Your guess is too low.");
      } else {
        System.out.println("Your guess is too high.");
      }

      numGuesses--;
    }

    if (numGuesses == 0) {
      System.out.println("You are out of guesses. The number was: " + numberToGuess);
    }
// Close the Scanner object
    scanner.close(); 
  }
}