package mate.academy.boot.helloboot.repository;

import mate.academy.boot.helloboot.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
