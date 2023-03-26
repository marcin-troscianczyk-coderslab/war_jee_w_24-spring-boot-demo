package pl.coderslab.service;

import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookService {

    void save(Book book);

    Book findById(Long id);

    List<Book> findAll();

    List<Book> findAllByRating(int rating);

    List<Book> findByPublisherIsNotNull();

    List<Book> findByPublisher(Publisher publisher);

    List<Book> findByAuthor(Author author);

    void update(Book book);

    void deleteById(Long id);

    List<Book> findByTitle(String title);

    List<Book> findByCategory(Category category);

    List<Book> findByCategoryId(Long id);
}