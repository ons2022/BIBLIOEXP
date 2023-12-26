package biblioexp.bibleo.Service;


import biblioexp.bibleo.Entity.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Book saveBook(Book Book);
    List<Book> getAllBooks();
    Book getBookById(long id);
    Book updateBook(Book Book, long id);
    void deleteBook(long id);

    Optional<Book> findById(Long bookId);
}