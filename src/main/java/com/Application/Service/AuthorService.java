package com.Application.Service;

import com.Application.Model.Author;
import com.Application.DAO.AuthorDAO;

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
public class AuthorService {
    private AuthorDAO authorDAO;
    /**
     * no-args constructor for creating a new AuthorService with a new AuthorDAO.
     */
    public AuthorService(){
        authorDAO = new AuthorDAO();
    }
    /**
     * Constructor for an AuthorService when an AuthorDAO is provided.
     * This is used for when a mock AuthorDAO that exhibits mock behavior is used in the test cases.
     * This would allow the testing of AuthorService independently of AuthorDAO.
     * @param authorDAO
     */
    public AuthorService(AuthorDAO authorDAO){
        this.authorDAO = authorDAO;
    }
    /**
     * Task: Retrieve all authors using the AuthorDAO.
     *
     * @return all authors
     */
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }
    /**
     * Task: Persist an author using the AuthorDAO. The given Author will not have an id provided.
     *
     * @param author an author object.
     * @return The persisted author if the persistence is successful.
     */
    public Author addAuthor(Author author) {
        return authorDAO.insertAuthor(author);
    }
}