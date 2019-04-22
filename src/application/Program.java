package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.next();
		System.out.print("Initial balance: ");
		sc.nextLine();
		Double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		Double withdraw = sc.nextDouble();
		
		if (withdraw > withdrawLimit) {
			System.out.println("Withdraw error: The amount exceeds withdraw limit");
		} else if (withdraw > acc.getBalance()) {
			System.out.println("Withdraw error: Not enough balance");
		} else {
			acc.withdraw(withdraw);
			System.out.printf("New balance: %.2f%n", acc.getBalance());
		}
		
		sc.close();
	}
}
