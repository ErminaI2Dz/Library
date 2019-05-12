package library;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public class BookCheckOutManager {

	// Method adds a checked out book

	public static void addCheckedOutBook(ArrayList<BookCheckOut> bookCheckedOut, int accountNumber, int bookNumber,
			Date date) throws FileNotFoundException {

		BookCheckOut checkedOutBook = new BookCheckOut(accountNumber, bookNumber, date);

		bookCheckedOut.add(checkedOutBook);

		java.io.File file = new java.io.File("checkedOutBooks.txt");

		java.io.PrintWriter output = new java.io.PrintWriter(file);

		for (int i = 0; i < bookCheckedOut.size(); i++) {

			output.print("Account number of clients who borrowed a book: " + bookCheckedOut.get(i).getAccountNumber()
					+ ", borrowed book's number: " + bookCheckedOut.get(i).getBookNumber() + " , date of borrowing: "
					+ bookCheckedOut.get(i).getDate() + "\n");
		}

		output.close();
	}

	public static void bookBorrowing(ArrayList<Account> accounts, ArrayList<Book> books,
			ArrayList<BookCheckOut> bookCheckedOut) throws FileNotFoundException {

		// Book borrowing

		// Input and validation of account number

		int accountNumber = -1, bookNumber = -1, inputContinue = 1, inputContinue1 = 1;

		do {
			try {

				System.out.println("Input account number: ");
				accountNumber = Library.input.nextInt();

				while (!AccountValidation.doesAccountExist(accounts, accountNumber)) {
					System.out.println("The account number does not exists. Input again: ");
					accountNumber = Library.input.nextInt();
				}

				if (!AccountValidation.bookLimit(accounts, accountNumber)) {
					System.out.println("Invalid request! You have already borrowed tree books!");
				}

				inputContinue = 2;
			} catch (InputMismatchException ex) {

				System.out.println("Incorrect input: an integer is required!");
				Library.input.nextLine();
			}
		
		} while (inputContinue == 1);

		// Input and validation of book number and status
		do {
			try {
				
				System.out.println("Input book number: ");
				bookNumber = Library.input.nextInt();

				while (!BookValidation.doesBookExist(books, bookNumber)) {
					System.out.println("The book number does not exists. Input again: ");
					bookNumber = Library.input.nextInt();
				}

				if (!BookValidation.bookStatus(books, bookNumber)) {
					System.out.println("Invalid request! Book not available!");
					bookNumber = Library.input.nextInt();
				}

				inputContinue1 = 2;
			} catch (InputMismatchException ex) {

				System.out.println("Incorrect input: an integer is required!");
				Library.input.nextLine();
			}
		
		} while (inputContinue1 == 1);
		
		Date date = new Date();

		BookCheckOutManager.addCheckedOutBook(bookCheckedOut, accountNumber, bookNumber, date);

		BookCheckOutValidation.bookCheckOut(accounts, books, accountNumber, bookNumber);

	}
	
}
