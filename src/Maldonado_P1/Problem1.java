/*Ricardo Maldonado
Problem 1 of Program Assignment 3
Due October 18, 2019
 */
package Maldonado_P1;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Problem1 {

    public static int randomNumberGenerator(int chosenLevel) {
        SecureRandom randomNum = new SecureRandom();
        double range = Math.pow(10, chosenLevel);
        return randomNum.nextInt((int)range-1) + 1;
    }

    public static void questionUser(int firstNum, int secondNum, int mathSymbol) {

        switch (mathSymbol) {
            case 1:
                System.out.printf("How much is %d plus %d?\n", firstNum, secondNum);
                break;
            case 2:
                System.out.printf("How much is %d times %d?\n", firstNum, secondNum);
                break;
            case 3:
                System.out.printf("How much is %d minus %d?\n", firstNum, secondNum);
                break;
            case 4:
                System.out.printf("How much is %d divided by %d?\n", firstNum, secondNum);
                break;
            default:
        }
        return;
    }

    public static double userResponse () {
        //DecimalFormat decfor = new DecimalFormat("#.##");
        Scanner scnr = new Scanner(System.in);
        return scnr.nextDouble();
    }

    public static double calculateAnswer(int firstNum, int secondNum, int chosenArithmetic) {
        double randomResult = 0.2f;
        switch (chosenArithmetic) {
            case 1:
                randomResult = firstNum + secondNum;
                break;
            case 2:
                randomResult = firstNum * secondNum;
                break;
            case 3:
                randomResult = firstNum - secondNum;
                break;
            case 4:
                randomResult = ((double)firstNum) / secondNum;
                break;
            default:
        }

        DecimalFormat decfor = new DecimalFormat("#.##");
        //System.out.printf(decfor.format(randomResult));
        return randomResult;
    }

    //NEED FLOATING POINT COMPARISONS
    public static boolean compareAnswers(double randResult, double userAnswer) {
        if (randResult == userAnswer)
            return true;
        else
            return false;
    }

    private static void successQuotes() {
        SecureRandom randomNum = new SecureRandom();
        int newNumber = randomNum.nextInt(4) + 1;

        switch (newNumber) {
            case 1:
                System.out.println("Very Good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice Work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
            default:
        }
    }

    public static void failQuotes() {
        SecureRandom randomNum = new SecureRandom();
        int newNumber = randomNum.nextInt(4) + 1;

        switch (newNumber) {
            case 1:
                System.out.println("No. Please try again");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don't give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
            default:
        }
    }

    public static double calculateScore(int scoreCounter) {
        return (scoreCounter / 10.0) * 100;
    }

    public static int difficultyLevel() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Select a difficulty level between 1 through 4:");
        int chosenLevel = scnr.nextInt();

        if ((chosenLevel < 1) || (chosenLevel > 4)) {
            System.out.println("Select a difficulty level between 1 through 4:");
            chosenLevel = scnr.nextInt();
        } else
            System.out.println("Selected " + chosenLevel);

        return chosenLevel;
    }

    public static int arithmeticType() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Choose an arithmetic type:");
        System.out.println("1: Addition, 2: Multiplication, 3: Subtraction, 4: Division, 5: Mix of all these");
        return scnr.nextInt();
    }

    public static int arithmeticRandom() {
        SecureRandom randomNum = new SecureRandom();
        return randomNum.nextInt(4) + 1;
    }

    public static void main(String[] args) {
        /* Type your code here. */
        boolean continueProgram = true;
        System.out.println("Welcome!");

        do {
            int counter = 0;
            int scoreCounter = 0;
            int mathSymbol = 0;
            int chosenLevel = difficultyLevel();
            int chosenArithmetic = arithmeticType();

            do {
                int firstNum = randomNumberGenerator(chosenLevel);
                int secondNum = randomNumberGenerator(chosenLevel);

                if (chosenArithmetic == 5)
                    mathSymbol = arithmeticRandom();
                else
                    mathSymbol = chosenArithmetic;

                double randResult = calculateAnswer(firstNum, secondNum, mathSymbol);
                // double precision floating-point variable for user answer
                questionUser(firstNum, secondNum, mathSymbol);
                boolean compareResult = compareAnswers(randResult, userResponse());

                if (compareResult) {
                    successQuotes();
                    scoreCounter++;
                } else {
                    failQuotes();
                }
                counter++;
            } while (counter < 10);

            double percentCorrect = calculateScore(scoreCounter);
            System.out.println("Score: " + percentCorrect + "%");

            if (percentCorrect < 75.0)
            {
                System.out.println("Please ask your teacher for extra help.");
            } else {
                System.out.println("Congratulations, you are ready for the next level!");
            }
            System.out.println("New User:");

        } while (continueProgram);
    }
    //after main
}
