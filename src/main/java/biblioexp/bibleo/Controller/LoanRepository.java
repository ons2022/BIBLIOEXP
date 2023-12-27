package biblioexp.bibleo.Controller;

import biblioexp.bibleo.Entity.Category;
import biblioexp.bibleo.Entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUserId(Long userId);
}
