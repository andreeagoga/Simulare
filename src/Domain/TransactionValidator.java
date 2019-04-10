package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TransactionValidator implements IValidator<Transaction> {

    /**
     *Validate a transaction
     * @param transaction the transaction to validate
     * @throws RuntimeException if there are validation errors
     */
    public void validate(Transaction transaction){
        String errors = "";
        if (transaction.getNumberMedicine() < 0){
            errors += "The number of medicine is positive and it is not 0!\n";
        }
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
        try {
            formatDate.parse(transaction.getDate());
        } catch (ParseException pe) {
            errors += "The date is not in a correct format!\n";
        }
        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm");
        try{
            formatTime.parse(transaction.getHour());
        } catch (ParseException p) {
            errors += "The time is not in a correct format!\n";
        }
        if(!errors.isEmpty()){
            throw new ExceptionDomain("Nu s-a validat"+errors);
        }
    }
}
