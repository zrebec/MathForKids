# MathForKids
This is a simple math exercise program that is designed to help kids practice addition and subtraction. The program generates two random numbers, num1 and num2, between 0 and 100, and asks the user to perform either an addition or subtraction operation, depending on the result of the random boolean isAddition.

## How it works
The program starts by setting the initial variables: the maximum allowed time for an answer in seconds (maxAllowedTimeInSeconds), the expected number of exercises (expectedCalculatedExercises), and the boolean isAddition to determine whether the operation will be an addition or subtraction.

In each cycle, the program generates a random number num1 between 0 and 100. Then it calculates num2 based on the isAddition value: If it is true, num2 will be a random number from 0 to the difference of 101 and num1 (to ensure the sum does not exceed 100); if isAddition is false, num2 will be a random number from 0 to num1 (to ensure the result of the subtraction does not go below 0).

The program then prints the generated operation (either addition or subtraction) and waits for the user's input. If the user's answer is correct and within the maximum allowed time, the program will print a congratulatory message. If the user's answer is incorrect or if the user takes more time than allowed, the program will print the correct result and either a notification about the incorrect answer or the time limit exceeding.

The program continues to generate exercises until the number of successful inputs reaches expectedCalculatedExercises. After that, it prints a summary including the number of successful exercises, the total number of exercises, the total time taken, and the success ratio.

## Usage
To use this program, simply run it in your Java environment. When prompted with an operation, type in your answer and press Enter. If your answer is correct and entered within the allotted time, you will receive a congratulatory message. If your answer is incorrect or if you exceed the time limit, you will receive the correct result and a message about your error or delay.

## Requirements
This program requires Java to run. It has been written with Java SE Development Kit 17, but it should be compatible with other recent versions of Java.

## Contribution
If you would like to contribute to this project, feel free to fork the repository and submit a pull request. We are always looking for improvements to our projects!

## License
This project is licensed under the MIT License. Please see the LICENSE.md file for details.

## Contact
If you encounter any issues or have questions about this project, please open an issue in this repository. We will try to address it as soon as possible.