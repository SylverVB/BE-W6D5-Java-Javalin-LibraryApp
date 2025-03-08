package com.Application.Service;

import com.Application.DAO.BookDAO;
import com.Application.Model.Book;

import java.util.List;

/**
 * The purpose of a Service class is to contain "business logic" that sits between the web layer (controller) and
 * persistence layer (DAO). That means that the Service class performs tasks that aren't done through the web or
 * SQL: programming tasks like checking that the input is valid, conducting additional security checks, or saving the
 * actions undertaken by the API to a logging file.
 *
 * It's perfectly normal to have Service methods that only contain a single line that calls a DAO method. An
 * application that follows best practices will often have unnecessary code, but this makes the code more
 * readable and maintainable in the long run!
 */
public class BookService {
    public BookDAO bookDAO;

    /**
     * No-args constructor for bookService which creates a BookDAO.
     */
    public BookService(){
        bookDAO = new BookDAO();
    }
    /**
     * Constructor for a BookService when a BookDAO is provided.
     * This is used for when a mock BookDAO that exhibits mock behavior is used in the test cases.
     * This would allow the testing of BookService independently of BookDAO.
     * @param bookDAO
     */
    public BookService(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }
    /**
     * Task: Retrieve all books using the bookDAO.
     * @return all books.
     */
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }
    /**
     * Task: Persist a book to the database using the bookDAO.
     * An ISBN will be provided in Book. Method should check if the book ISBN already exists before it attempts to
     * persist it.
     * @param book a book object.
     * @return book if it was successfully persisted, null if it was not successfully persisted (e.g., if the book primary
     * key was already in use.)
     */
    public Book addBook(Book book) {
        if (bookDAO.getBookByIsbn(book.getIsbn()) != null) {
        return null;
        }
        bookDAO.insertBook(book);
        return book;
    }
    /**
     * Task: Retrieve a list of all books that have a bookCount above 0 using the bookDAO.
     * @return all available books (bookCount over zero)
     */
    public List<Book> getAllAvailableBooks() {
        return bookDAO.getBooksWithBookCountOverZero();
    }
}