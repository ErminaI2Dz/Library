package library;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class AccountManager {

	// Method creates an account
	public static void createAccount(ArrayList<Account> accounts, int accountNumber, String clientName)
			throws FileNotFoundException {

		Account account = new Account(accountNumber, clientName);

		accounts.add(account);

		java.io.File file = new java.io.File("accounts.txt");

		java.io.PrintWriter output = new java.io.PrintWriter(file);

		for (int i = 0; i < accounts.size(); i++) {

			output.print("Account number: " + accounts.get(i).getAccountNumber() + ", client name: "
					+ accounts.get(i).getClientName() + ", number of borrowed books: "
					+ accounts.get(i).getBorrowedBooks() + "\n");
		}

		output.close();
	}

	// Method validates data and creates an account
	public static void dataValidationAccountCreation(ArrayList<Account> accounts) throws FileNotFoundException {

		int accountNumber = -1, inputContinue = 1;
		String clientName;

		do {
			try {
				System.out.println("Input account number: ");
				accountNumber = Library.input.nextInt();

				while (accountNumber < 0 || AccountValidation.doesAccountExist(accounts, accountNumber)) {
					while (AccountValidation.doesAccountExist(accounts, accountNumber)) {
						System.out.println("The account number already exists. Input again: ");
						accountNumber = Library.input.nextInt();
					}
					while (accountNumber < 0) {
						System.out.println("The account number must be positive. Input again: ");
						accountNumber = Library.input.nextInt();
					}
				}

				inputContinue = 2;
			} catch (InputMismatchException ex) {

				System.out.println("Incorrect input: an integer is required!");
				Library.input.nextLine();
			}
		} while (inputContinue == 1);
		
		clientName = Library.input.nextLine();
		System.out.println("Input client name: ");
		clientName = Library.input.nextLine();

		createAccount(accounts, accountNumber, clientName);
	}

	// Method displays an account if it exists
	public static void displayAccount(ArrayList<Account> accounts) {

		int accountNumber;

		System.out.println("Input an account number: ");
		accountNumber = Library.input.nextInt();

		while (!AccountValidation.doesAccountExist(accounts, accountNumber)) {
			System.out.println(" That account does not exists. Input again: ");
			accountNumber = Library.input.nextInt();
		}

		System.out.println("Account number: " + accountNumber);
		AccountValidation.displayAccount(accounts, accountNumber);
	}
}
