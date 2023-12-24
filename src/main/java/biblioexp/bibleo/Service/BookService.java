package biblioexp.bibleo.Service;

import biblioexp.bibleo.Entity.book;
import biblioexp.bibleo.Controller.bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private final bookrepository bookRepository;

    @Autowired
    public BookService(bookrepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public book saveBook(book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
