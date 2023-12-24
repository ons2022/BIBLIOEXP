package biblioexp.bibleo.Controller;

import biblioexp.bibleo.Entity.book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookrepository extends JpaRepository<book,Long>{

}
