/*Ricardo Maldonado
Problem 2 of Programming Assignment 3
Due October 18, 2019
 */
package Maldonado_P2;

public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    //created this method in order to give it the balance, otherwise the class would have a <balance> parameter above?
    public SavingsAccount(double intoBalance) {
        savingsBalance = intoBalance;
    }

    //not a static method, void, and parameters unnecessary with initialized static variables within the class
    public void calculateMonthlyInterest () {
        double monthlyInterest = ((savingsBalance * annualInterestRate) / 12 );
        savingsBalance += monthlyInterest;
        System.out.printf("Monthly Interest at " + (annualInterestRate * 100) + "%%: %.2f\n", savingsBalance);
    }

    public static void modifyInterestRate (double newValue){
        annualInterestRate = newValue / 100; //set rate to 5% or 5/100 for .05?
    }

    public static void main(String args[])
    {

    }
}
