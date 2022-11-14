package aula.application;

import aula.entities.Account;
import aula.entities.BusinessAccount;
import aula.entities.SavingsAccount;

public class Program {

    public static void main(String[] args) {

        BusinessAccount account = new BusinessAccount(8010, "Bob Brown", 10.0, 500.0);

        System.out.println(account.getBalance());

        // UPCASTING

        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);

        // DOWNCASTING

        BusinessAccount acc4 = (BusinessAccount)acc2;
        acc4.loan(100.0);

        // BusinessAccount acc5 = (BusinessAccount)acc3;
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount)acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
            //NÃO FEZ O LOAN
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount)acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }

        Account acc7 = new Account(1001, "Alex", 1000.0);
        acc7.withdraw(200.0);
        System.out.println(acc7.getBalance());

        Account acc5 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
        acc5.withdraw(200.0);
        System.out.println(acc5.getBalance());

        Account acc6 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
        acc6.withdraw(200.0);
        System.out.println(acc6.getBalance());
    }
}
