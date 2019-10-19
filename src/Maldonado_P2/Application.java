package Maldonado_P2;

import static org.junit.jupiter.api.Assertions.*;

class Application {

    @org.junit.jupiter.api.Test
    void main() {
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);

        saver1.modifyInterestRate(4);
        saver2.modifyInterestRate(4);

        for (int i = 1; i <= 12; i++) {
            System.out.println("Month " + i + ":");
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.println ("");
        }

        saver1.modifyInterestRate(5);
        saver2.modifyInterestRate(5);

        System.out.println("Month 13:");
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
    }
}