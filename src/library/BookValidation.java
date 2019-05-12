package library;

import java.util.ArrayList;

public class BookValidation {

	// Method checks if a book exists
	public static boolean doesBookExist(ArrayList<Book> books, int bookNumber) {

		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getBookNumber() == bookNumber) {
				return true;
			}
		}
		return false;

	}

	// Method deletes the book
	public static void deleteBook(ArrayList<Book> books, int bookNumber) {

		if (doesBookExist(books, bookNumber)) {
			books.remove(bookNumber);
		} else {
			System.out.println("The book you want to delete does not exist in the library!");
		}
	}

	// Method checks book's status
	public static boolean bookStatus(ArrayList<Book> books, int bookNumber) {

		boolean bookStatus = false;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getBookNumber() == bookNumber) {
				bookStatus = books.get(i).getBookStatus();
				break;
			}
		}

		return bookStatus;
	}
	
}
