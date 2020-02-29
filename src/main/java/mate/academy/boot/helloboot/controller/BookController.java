package mate.academy.boot.helloboot.controller;

import mate.academy.boot.helloboot.entity.Book;
import mate.academy.boot.helloboot.entity.dto.request.BookRequestDto;
import mate.academy.boot.helloboot.entity.dto.response.BookResponseDto;
import mate.academy.boot.helloboot.service.BookService;

import java.util.List;
import java.util.stream.Collectors;
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

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponseDto> allBooks() {
        return bookService.findAll().stream()
                .map(this::responseDtoFromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookResponseDto findById(@PathVariable Long id) {
        return responseDtoFromEntity(bookService.findById(id));
    }

    @PostMapping
    public BookResponseDto addBook(@RequestBody @Valid BookRequestDto bookRequestDto) {
        Book book = entityFromRequestDto(bookRequestDto);
        return responseDtoFromEntity(bookService.save(book));
    }


    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @PutMapping("{id}")
    public BookResponseDto updateBook(@PathVariable Long id,
                                      @RequestBody @Valid BookRequestDto bookRequestDto) {
        Book book = entityFromRequestDto(bookRequestDto);
        return responseDtoFromEntity(bookService.update(id, book));
    }

    private BookResponseDto responseDtoFromEntity(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setYear(book.getYear());
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setPrice(book.getPrice());
        bookResponseDto.setDescription(book.getDescription());
        return bookResponseDto;
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
