package library;

public class Book {

	private int bookNumber;
	private String bookName;
	private boolean bookStatus;
	
	Book(){
		
	}
	
	Book(int bookNumber, String bookName){
		
		this.bookNumber=bookNumber;
		this.bookName=bookName;
		this.bookStatus=true;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public boolean getBookStatus() {
		return bookStatus;
	}
	
	public void setBookStatus(boolean bookStatus) {
		this.bookStatus = bookStatus;
	}

	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookName=" + bookName + ", bookStatus=" + bookStatus + "]";
	}

}

