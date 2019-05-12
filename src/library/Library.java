package library;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {

	public static ArrayList<Account> accounts = new ArrayList<Account>();
	public static ArrayList<Book> books = new ArrayList<Book>();
	public static ArrayList<BookCheckOut> bookCheckedOut = new ArrayList<BookCheckOut>();
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws InputMismatchException, FileNotFoundException {

		int choice = -1;

		Account account1 = new Account(1, "Amir");
		accounts.add(account1);

		Account account2 = new Account(2, "Amira");
		accounts.add(account2);

		Book book1 = new Book(1, "Grass");
		books.add(book1);

		Book book2 = new Book(2, "Snail");
		books.add(book2);

		do {
			System.out.println("---------------------------------------------------");
			System.out.println("Make a choice!\n");
			System.out.println(
					"1---Create an account\n2---Add a book\n3---Check out a book\n4---Account information\n5---Exit");
			System.out.println("---------------------------------------------------");

			choice = input.nextInt();
			if (choice == 1) {

				AccountManager.dataValidationAccountCreation(accounts);

				System.out.println("                         You have successfully created an account!");

			} else if (choice == 2) {

				BookManager.dataValidationBookCreation(books);

				System.out.println("                         You have successfully created a book!");

			} else if (choice == 3) {

				BookCheckOutManager.bookBorrowing(accounts, books, bookCheckedOut);

				System.out.println("                         You have successfully borrowed a book!");

			} else if (choice == 4) {

				AccountManager.displayAccount(accounts);

			} else if (choice == 5) {

				break;
			}

		} while (true);
	}

}
