package biblioexp.bibleo.Controller;

import biblioexp.bibleo.Entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long>{

}
