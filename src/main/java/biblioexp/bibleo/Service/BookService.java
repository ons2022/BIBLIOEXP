package biblioexp.bibleo.Service;


import biblioexp.bibleo.Entity.Book;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Book saveBook(Book Book);
    List<Book> getAllBooks();
    Book getBookById(long id);
    Book updateBook(Book Book, long id);
    void deleteBook(long id);
}