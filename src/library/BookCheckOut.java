package library;

import java.util.Date;

public class BookCheckOut {

	private int accountNumber;
	private int bookNumber;
	private Date date;

	BookCheckOut() {

	}

	BookCheckOut(int accountNumber, int bookNumber, Date date) {

		this.accountNumber = accountNumber;
		this.bookNumber = bookNumber;
		this.date = date;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "BookCheckOut [accountNumber=" + accountNumber + ", bookNumber=" + bookNumber + ", date=" + date + "]";
	}

}
