package Controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<entity.Book,Long>{

}
