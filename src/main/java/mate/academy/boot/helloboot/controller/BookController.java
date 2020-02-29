package mate.academy.boot.helloboot.controller;

import mate.academy.boot.helloboot.entity.Book;
import mate.academy.boot.helloboot.entity.dto.request.BookRequestDto;
import mate.academy.boot.helloboot.service.BookService;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> allBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public void addBook(@RequestBody @Valid BookRequestDto bookRequestDto) {
        Book book = entityFromRequestDto(bookRequestDto);
        bookService.save(book);
    }


    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @PutMapping("{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody @Valid BookRequestDto bookRequestDto) {
        Book book = entityFromRequestDto(bookRequestDto);
        return bookService.update(id, book);
    }

    private Book entityFromRequestDto(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setDescription(bookRequestDto.getDescription());
        book.setYear(bookRequestDto.getYear());
        book.setPrice(bookRequestDto.getPrice());
        return book;
    }
}
