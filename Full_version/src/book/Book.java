package book;

import java.time.LocalDate;

import exception.InvalidValueException;

public abstract class Book {
	private String book_id;
	private String title;
	private String author;
	private LocalDate publish_date;
	private int number_of_books;
	private BookStatus book_status;

	public enum BookStatus {
		AVAILABLE, RESERVED
	}

	public abstract String getSubject();

	public abstract double getRentalFee();

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) throws InvalidValueException {
		if (book_id.isBlank())
			throw new InvalidValueException("Book ID could not be blank");
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws InvalidValueException {
		if (title.isBlank())
			throw new InvalidValueException("Title of book could not be blank");
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if (author.isBlank())
			return;
		this.author = author;
	}

	public LocalDate getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		if (publish_date.isBlank() || publish_date == null)
			return;
		this.publish_date = LocalDate.parse(publish_date);
	}

	public int getNumber_of_books() {
		return number_of_books;
	}

	public void setNumber_of_books(int number_of_books) throws InvalidValueException {
		if (number_of_books <= 0)
			throw new InvalidValueException("This number must be greater than 0");
		this.number_of_books = number_of_books;
	}

	public String toString() {
		return "ID: " + book_id + ", Type: " + getSubject() + ", Title: " + title + ", Author: " + author
				+ ", Publish date: " + publish_date + ", Number of books: " + number_of_books;

	}

	public BookStatus getBook_status() {
		return book_status;
	}

	public void setBook_status(String book_status) throws InvalidValueException {
		if (book_status.equalsIgnoreCase("AVAILABLE")) {
			this.book_status = BookStatus.AVAILABLE;
		} else if (book_status.equalsIgnoreCase("RESERVED")) {
			this.book_status = BookStatus.RESERVED;
		} else
			throw new InvalidValueException("Invalid type of book status: " + book_status);
	}

}
