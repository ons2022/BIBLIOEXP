package biblioexp.bibleo.Service;

import biblioexp.bibleo.Entity.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoanService {
    Loan saveLoan(Loan Loan);
    List<Loan> getAllLoans();
    Loan getLoanById(long id);
    Loan UpdateLoan(Loan Loan, long id);
    void DeleteLoan(long id);

}
