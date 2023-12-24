package biblioexp.bibleo.Service;

import biblioexp.bibleo.Entity.Book;
import biblioexp.bibleo.Controller.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
/*
    public static List<Book> getAllBooks() {
        return BookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public static Book saveBook(Book book) {
        return BookRepository.save(book);
    }

    public void deleteBook(Long id) {
        BookRepository.deleteById(id);
    }*/
}
