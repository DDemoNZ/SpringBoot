package mate.academy.boot.helloboot.controller;

import mate.academy.boot.helloboot.entity.Book;
import mate.academy.boot.helloboot.service.BookService;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private BookService bookService;

    @PostConstruct
    public void initData() {
        Book book1 = new Book();
        book1.setTitle("a");
        book1.setDescription("a");
        book1.setPrice(100.1);
        book1.setYear(2000);

        Book book2 = new Book();
        book2.setTitle("B");
        book2.setDescription("b");
        book2.setPrice(200.2);
        book2.setYear(2020);

        Book book3 = new Book();
        book3.setTitle("c");
        book3.setDescription("c");
        book3.setPrice(300.3);
        book3.setYear(2003);

        bookService.save(book1);
        bookService.save(book2);
        bookService.save(book3);
    }
}
