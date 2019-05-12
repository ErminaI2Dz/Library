package library;

import java.util.ArrayList;

public class BookCheckOutValidation {

	/*
	 * Method increases number of client's borrowed books and changes book's
	 * status
	 */
	public static void bookCheckOut(ArrayList<Account> accounts, ArrayList<Book> books, int accountNumber, int bookNumber) {

		for (int i = 0; i < accounts.size(); i++) {

			if (accounts.get(i).getAccountNumber() == accountNumber) {
				int counter = accounts.get(i).getBorrowedBooks();
				counter++;
				accounts.get(i).setBorrowedBooks(counter);
				break;
			}
		}

		for (int i = 0; i < books.size(); i++) {

			if (books.get(i).getBookNumber() == bookNumber) {
				books.get(i).setBookStatus(false);
			}
		}
	}
	
}
