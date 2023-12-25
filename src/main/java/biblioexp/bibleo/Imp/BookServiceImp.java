package biblioexp.bibleo.Imp;

import biblioexp.bibleo.Entity.Book;
import biblioexp.bibleo.Service.BookService;
import biblioexp.bibleo.exception.ResourceNotFoundException;

import biblioexp.bibleo.Controller.BookRepository;
import org.springframework.stereotype.Service;


import java.util.List;
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
    public Book getBookById(long id) {
// Optional<Book> Book = BookRepository.findById(id);
// if(Book.isPresent()) {
// return Book.get();
// }else {
// throw new ResourceNotFoundException("Book", "Id", id);
// }
        return BookRepository.findById(id).orElseThrow(() ->
                new
                        ResourceNotFoundException("Book", "Id", id));
    }
    @Override
    public Book updateBook(Book Book, long id) {
// we need to check whether Book with given id is exist in
        //DB or not
        Book existingBook =
                BookRepository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("Book",
                                "Id", id));
        existingBook.setTitle(Book.getTitle());

        BookRepository.save(existingBook);
        return existingBook;
    }
    @Override
    public void deleteBook(long id) {
// check whether a Book exist in a DB or not
        BookRepository.findById(id).orElseThrow(() ->
                new
                        ResourceNotFoundException("Book", "Id", id));
        BookRepository.deleteById(id);
    }
}