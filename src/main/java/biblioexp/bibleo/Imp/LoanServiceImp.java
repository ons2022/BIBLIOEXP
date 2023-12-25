package biblioexp.bibleo.Imp;

import biblioexp.bibleo.Controller.LoanRepository;
import biblioexp.bibleo.Entity.Category;
import biblioexp.bibleo.Entity.Loan;
import biblioexp.bibleo.Service.LoanService;
import biblioexp.bibleo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
@Service

public class LoanServiceImp implements LoanService {
    private LoanRepository LoanRepository;

    public LoanServiceImp(LoanRepository LoanRepository ){
        super();
        this.LoanRepository= LoanRepository;
    }
    @Override
    public Loan saveLoan(Loan Loan) {
        return LoanRepository.save(Loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        return LoanRepository.findAll();
    }

    @Override
    public Loan getLoanById(long id) {
        return LoanRepository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("Loan",
                                "Id", id));
    }

    @Override
    public Loan UpdateLoan(Loan Loan, long id) {
        Loan existingLoan =
                LoanRepository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("Loan",
                                "Id", id));
        existingLoan.setUser(existingLoan.getUser());
        existingLoan.setBook(existingLoan.getBook());
        existingLoan.setBorrowDate(existingLoan.getBorrowDate());
        existingLoan.setReturnDate(existingLoan.getReturnDate());
// save existing Category to DB
        LoanRepository.save(existingLoan);
        return existingLoan;
    }

    @Override
    public void DeleteLoan(long id) {
       LoanRepository.findById(id).orElseThrow(() ->
                new
                        ResourceNotFoundException("Loan", "Id", id));
       LoanRepository.deleteById(id);

    }
}
