package mate.academy.boot.helloboot.service;

import mate.academy.boot.helloboot.entity.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    Book findById(Long id);

    void deleteBookById(Long id);

    Book update(Long id, Book book);
}
