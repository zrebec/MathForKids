// Import necessary classes for user input, random number generation, and time management
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MathExercises {

    public static void main(String[] args) {
        // Initialize Scanner for user input and Random for generating random numbers
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Flag to control when the program should stop running
        boolean continueRunning = true;

        // Main loop to keep the program running until the user decides to stop
        do {
            int numberOfExercises = 0;
            boolean validInput = false;

            // Loop to ensure the user provides a valid input for the number of exercises
            while (!validInput) {
                System.out.println("Enter the number of exercises:");
                try {
                    numberOfExercises = scanner.nextInt();
                    validInput = true;
                    scanner.nextLine(); // Clear the invalid input from the scanner
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    System.exit(0);
                }
            }

            // Counter to keep track of completed exercises
            int completedExercises = 0;

            // Store the start time for total time calculation
            long totalStartTime = System.nanoTime();

            // Loop to generate and present exercises to the user
            while (completedExercises < numberOfExercises) {
                // Generate two random numbers between 0 and 100
                int num1 = random.nextInt(101);
                int num2 = random.nextInt(101);

                // Randomly choose between addition and subtraction
                boolean isAddition = random.nextBoolean();
                String operation = isAddition ? "+" : "-";
                int correctResult = isAddition ? num1 + num2 : num1 - num2;

                // Present the math problem to the user
                System.out.println("Solve: " + num1 + " " + operation + " " + num2);

                // Record the start time of the user's response
                long startTime = System.nanoTime();

                // Initialize userResult variable before the try block
                int userResult;
                // Get the user's answer, handling invalid input
                try {
                    userResult = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid number, Try next example");
                    scanner.nextLine(); // Clear the invalid input from the scanner
                    continue; // Move on to the next exercise
                }

                // Record the end time of the user's response
                long endTime = System.nanoTime();

                // Calculate the time taken for the user to answer
                long duration = TimeUnit.SECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS);

                // Define the maximum allowed time for one exercise
                int maxAllowedSecondsForOneExercise = 12;

                // Check the user's response and time taken
                if (userResult == correctResult && duration <= maxAllowedSecondsForOneExercise) {
                    // Increment the completed exercises counter
                    completedExercises++;
                } else if (duration > maxAllowedSecondsForOneExercise) {
                    System.out.println("Correct. You are on the good way. But this was a bit slower. Try thinking different.");
                } else {
                    System.out.println("Incorrect result. Sorry. Try another exercise");
                }
            }

            // Calculate the total time taken to complete the exercises
            long totalDuration = TimeUnit.SECONDS.convert(System.nanoTime() - totalStartTime, TimeUnit.NANOSECONDS);

            // Print the results
            System.out.printf("""
                    Done! You have completed %s exercises with total %s seconds
                    """, completedExercises, totalDuration);

            // Ask the user if they want to continue
            System.out.println("Do you want to continue? (yes/no)");
            String userInput = scanner.next();
            // Check the user's input and update the continueRunning flag accordingly
            if (!userInput.equalsIgnoreCase("yes")) {
                continueRunning = false;
            }
        } while (continueRunning); // Continue running the program as long as the user wants to
    }
}