package library;

import java.util.ArrayList;

public class AccountValidation {

	// Method check does account exist
	public static boolean doesAccountExist(ArrayList<Account> accounts, int accountNumber) {

		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) {
				return true;
			}
		}

		return false;
	}

	// Method display account
	public static void displayAccount(ArrayList<Account> accounts, int accountNumber) {

		for (int i = 0; i < accounts.size(); i++) {

			if (accounts.get(i).getAccountNumber() == accountNumber) {

				System.out.println("Client name: " + accounts.get(i).getClientName());
				System.out.println("Number of borrowed books: " + accounts.get(i).getBorrowedBooks());
				break;
			}
		}
	}

	// Method checks number of clinent's borrowed books
	public static boolean bookLimit(ArrayList<Account> accounts, int accountNumber) {

		boolean limit = false;

		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) {
				if (accounts.get(i).getBorrowedBooks() < 3) {
					limit = true;
				} else {
					limit = false;
				}
			}
		}
		return limit;
	}
	
}
