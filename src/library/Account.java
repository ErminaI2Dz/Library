package library;

public class Account {

	private int accountNumber;
	private String clientName;
	private int borrowedBooks;
	
	Account(){
		
	}
	
	Account(int accountNumber, String clientName){
		this.accountNumber=accountNumber;
		this.clientName=clientName;
		this.borrowedBooks=0;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(int borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", clientName=" + clientName + ", borrowedBooks="
				+ borrowedBooks + "]";
	}
	
}
