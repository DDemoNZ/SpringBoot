package mate.academy.boot.helloboot.service.impl;

import mate.academy.boot.helloboot.entity.Book;
import mate.academy.boot.helloboot.repository.BookRepository;
import mate.academy.boot.helloboot.service.BookService;

import java.util.List;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book " +
                "with id " + id + " not found."));
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book update(Long id, Book book) {
        Book updatedBook = findById(id);
        updatedBook.setTitle(book.getTitle());
        updatedBook.setDescription(book.getDescription());
        updatedBook.setPrice(book.getPrice());
        updatedBook.setYear(book.getYear());
        deleteBookById(id);
        return bookRepository.save(updatedBook);
    }
}
