package biblioexp.bibleo.Imp;

import biblioexp.bibleo.Entity.Book;
import biblioexp.bibleo.Service.BookService;
import biblioexp.bibleo.exception.ResourceNotFoundException;

import biblioexp.bibleo.Controller.BookRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService{
    private BookRepository BookRepository;
    public BookServiceImp(BookRepository BookRepository) {
        super();
        this.BookRepository = BookRepository;
    }
    @Override
    public Book saveBook(Book Book) {
        return BookRepository.save(Book);
    }
    @Override
    public List<Book> getAllBooks() {
        return BookRepository.findAll();
    }
    @Override
    public Book getBookById(long ISBN) {
// Optional<Book> Book = BookRepository.findById(id);
// if(Book.isPresent()) {
// return Book.get();
// }else {
// throw new ResourceNotFoundException("Book", "Id", id);
// }
        return BookRepository.findById(ISBN).orElseThrow(() ->
                new
                        ResourceNotFoundException("Book", "ISBN", ISBN));
    }
    @Override
    public Book updateBook(Book updatedBook, long ISBN) {
        Book existingBook = BookRepository.findById(ISBN)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "ISBN", ISBN));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setNbr_copies(updatedBook.getNbr_copies());
        existingBook.setAvb_copies(updatedBook.getAvb_copies());
        existingBook.setDate_pub(updatedBook.getDate_pub());
        existingBook.setCategory(updatedBook.getCategory());

        return BookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(long ISBN) {
// check whether a Book exist in a DB or not
        BookRepository.findById(ISBN).orElseThrow(() ->
                new
                        ResourceNotFoundException("Book", "ISBN", ISBN));
        BookRepository.deleteById(ISBN);
    }

    @Override
    public Optional<Book> findById(Long ISBN) {
        return BookRepository.findById(ISBN);
    }
    @Override
    public List<Book> searchAndSortBooks(String query, String sortCriteria) {
        List<Book> result;

        switch (sortCriteria) {
            case "title":
                result = BookRepository.findByTitleContainingIgnoreCaseOrderByTitle(query);
                break;
            case "author":
                result = BookRepository.findByAuthorContainingIgnoreCaseOrderByAuthor(query);
                break;
            default:
                result = BookRepository.findByTitleContainingIgnoreCaseOrderByTitle(query);
                break;
        }

        return result;
    }
}