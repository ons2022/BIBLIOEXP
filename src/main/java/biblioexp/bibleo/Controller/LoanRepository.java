package biblioexp.bibleo.Controller;

import biblioexp.bibleo.Entity.Category;
import biblioexp.bibleo.Entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
