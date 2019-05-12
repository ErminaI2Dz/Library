package library;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class BookManager {

	// Method creates a book
	public static void createBook(ArrayList<Book> books, int bookNumber, String bookName) throws FileNotFoundException {

		Book book = new Book(bookNumber, bookName);

		books.add(book);

		java.io.File file = new java.io.File("books.txt");

		java.io.PrintWriter output = new java.io.PrintWriter(file);

		for (int i = 0; i < books.size(); i++) {

			output.print("Book's number: " + books.get(i).getBookNumber() + ", book's name: "
					+ books.get(i).getBookName() + "\n");
		}

		output.close();
	}

	// Method validates data and creates a book
	public static void dataValidationBookCreation(ArrayList<Book> books) throws FileNotFoundException {

		int bookNumber = -1, inputContinue = 1;
		String bookName;

		do {
			try {

				System.out.println("Input book number:");
				bookNumber = Library.input.nextInt();

				while (bookNumber < 0 || BookValidation.doesBookExist(books, bookNumber)) {
					while (BookValidation.doesBookExist(books, bookNumber)) {
						System.out.println("The book number already exists. Input again: ");
						bookNumber = Library.input.nextInt();
					}
					while (bookNumber < 0) {
						System.out.println("The book number must be positive. Inpute again: ");
						bookNumber = Library.input.nextInt();
					}
				}

				inputContinue = 2;
			} catch (InputMismatchException ex) {

				System.out.println("Incorrect input: an integer is required!");
				Library.input.nextLine();
			}
		
		} while (inputContinue == 1);
		
		Library.input.nextLine();
		System.out.println("Input book name:");
		bookName = Library.input.nextLine();

		BookManager.createBook(books, bookNumber, bookName);
	}
	
}
