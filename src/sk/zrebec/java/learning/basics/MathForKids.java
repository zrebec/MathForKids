package sk.zrebec.java.learning.basics;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MathForKids {
    public static void main(String[] args) {
        Random random = new Random();
        int operand1, operand2, expectedAnswer;

        // Set initial variables
        final int maxAllowedTimeInSeconds = 12;
        final int expectedCalculatedExercises = 6;
        boolean isAddition;
        int successfulExercisesCount = 0;
        int totalAttemptedExercisesCount = 0;
        int totalTimeInSeconds = 0;

        do try {
            /*
             * Now we can set some variables at start of every cycle
             *
             * @isAddition is true of false based on random
             * @operand1 will be always random number between 0 and 100
             * @operand2 will be calculated based on addition. If added, we need to subtract
             * number1 from 101
             * @expectedAnswer expectedAnswer is calculated also on addition condition. If is true, the expectedAnswer is
             * operand1 + number, otherwise (we mean minus, then operand1 - operand2)
             * @totalAttemptedExercisesCount after every input we must add input to "totalAttemptedExercisesCount" variable
             */
            isAddition = random.nextBoolean();
            operand1 = random.nextInt(101);
            operand2 = random.nextInt(isAddition ? 101 - operand1 : operand1);
            expectedAnswer = isAddition ? (operand1 + operand2) : (operand1 - operand2);
            System.out.printf("%d %s %d\n", operand1, isAddition ? "+" : "-", operand2);
            Scanner scanner = new Scanner(System.in);
            long start = System.nanoTime();
            int result = scanner.nextInt();
            long duration = TimeUnit.SECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS);
            if (result == expectedAnswer && duration <= maxAllowedTimeInSeconds) {
                System.out.printf("This is OK. The real expectedAnswer is %d\n", expectedAnswer);
                successfulExercisesCount++;
            } else if (result != expectedAnswer && duration <= maxAllowedTimeInSeconds) {
                // Student's answer was right and in max allowed time
                System.out.printf("You're fast. But you have incorrect result. Correct result is %d\n", expectedAnswer);
            } else if (result == expectedAnswer) {
                // Student's answer was right but too slow
                System.out.printf("You're on good way. Correct result but your time was %ds\n", duration);
            } else {
                // Student's answer was incorrect
                System.out.printf("Incorrect. Correct result is %d and maximum duration is %ds\n", expectedAnswer, maxAllowedTimeInSeconds);
            }
            totalAttemptedExercisesCount++;
            totalTimeInSeconds += duration;
        } catch (Exception e) {
            System.out.println("This is not number");
        } while (successfulExercisesCount < expectedCalculatedExercises);

        System.out.printf(
                """
                Congratulations.
                You did successful %d math exercises under %d seconds from %d total.
                Your total time was %d seconds and
                Your success ratio was %.2f%%.
                """,
                successfulExercisesCount,
                maxAllowedTimeInSeconds,
                totalAttemptedExercisesCount,
                totalTimeInSeconds,
                ((double) successfulExercisesCount / totalAttemptedExercisesCount) * 100);
    }



}