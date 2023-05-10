import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MathForKids {
    public static void main(String[] args) {
        Random random = new Random();
        int num2, num1, sum;

        // Set initial variables
        final int maxAllowedTimeInSeconds = 12;
        final int expectedCalculatedExercises = 6;
        boolean isAddition;
        int successInputs = 0;
        int totalInputs = 0;

        do try {
            /*
             * Now we can set some variables at start of every cycle
             *
             * @isAddition is true of false based on random
             * @num1 will be always random number between 0 and 100
             * @num2 will be calculated based on addition. If added, we need to subtract
             * number1 from 101
             * @sum sum is calculated also on addition condition. If is true, the sum is
             * num1 + number, otherwise (we mean minus, then num1 - num2)
             * @totalInputs after every input we must add input to "totalInputs" variable
             */
            isAddition = random.nextBoolean();
            num1 = random.nextInt(101);
            num2 = random.nextInt(isAddition ? 101 - num1 : num1);
            sum = isAddition ? (num1 + num2) : (num1 - num2);
            System.out.printf("%d %s %d\n", num1, isAddition ? "+" : "-", num2);
            Scanner scanner = new Scanner(System.in);
            totalInputs++;
            long start = System.nanoTime();
            int result = scanner.nextInt();
            long duration = TimeUnit.SECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS);
            if (result == sum && duration <= maxAllowedTimeInSeconds) {
                System.out.printf("This is OK. The real sum is %d\n", sum);
                successInputs++;
            } else if (result != sum && duration <= maxAllowedTimeInSeconds) {
                // Student's answer was right and in max allowed time
                System.out.printf("You're fast. But you have incorrect result. Correct result is %d\n", sum);
            } else if (result == sum) {
                // Student's answer was right but too slow
                System.out.printf("You're on good way. Correct result but your time was %ds\n", duration);
            } else {
                // Student's answer was incorrect
                System.out.printf("Incorrect. Correct result is %d and maximum duration is %ds\n", sum, maxAllowedTimeInSeconds);
            }
        } catch (Exception e) {
            System.out.println("This is not number");
        } while (successInputs < expectedCalculatedExercises);

        System.out.printf(
                "Congratulations. You did successful %d math exercises from %d total. Your success ratio is: %.2f%%",
                successInputs,
                totalInputs,
                ((double) successInputs / totalInputs) * 100);
    }



}