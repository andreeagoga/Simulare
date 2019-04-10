package Service;

import Domain.Client;
import Domain.Medicine;
import Domain.Transaction;
import Repository.IRepository;

import javax.sql.rowset.serial.SerialException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TransactionService {

    private IRepository<Transaction> repository;
    private IRepository<Medicine> repositoryMedicine;

    /**
     * Instantiates a service
     *
     * @param repository         the repository used for transactions
     * @param repositoryMedicine the repository used for medicines
     */
    public TransactionService(IRepository<Transaction> repository, IRepository<Medicine> repositoryMedicine) {
        this.repository = repository;
        this.repositoryMedicine = repositoryMedicine;
    }

    /**
     * Add and update a transaction to the repository
     *
     * @param id             the transaction's id to add and update
     * @param idMedicine     the id of a medicine to add and update
     * @param idClientCard   the client's id to add and update
     * @param numberMedicine the number of medicine of the transaction to add and update
     * @param date           the date of the transaction to add and update
     * @param hour           the hour of the transaction to add and update
     */
    public void addAndUpdate(Integer id, Integer idMedicine, Integer idClientCard, Integer numberMedicine, String date, String hour, boolean withRecipe) {
        Transaction transaction = repository.findById(id);
        if (transaction != null) {
            if (idMedicine != null) {
                idMedicine = transaction.getIdMedicine();
            }
            if (idClientCard != null) {
                idClientCard = transaction.getIdClientCard();
            }
            if (numberMedicine == 0) {
                numberMedicine = transaction.getNumberMedicine();
            }
            if (date.isEmpty()) {
                date = transaction.getDate();
            }

            if (hour.isEmpty()) {
                hour = transaction.getHour();
            }
                withRecipe = !!transaction.isWithRecipe();


        }
        Transaction transaction1 = new Transaction(id, idMedicine, idClientCard, numberMedicine, date, hour, withRecipe);
        repository.addAndUpdate(transaction1);
    }

    /**
     * Remove a transaction from the repository
     *
     * @param id the id of the transaction to remove
     */
    public void delete(Integer id) {
        repository.remove(id);
    }

    /**
     * Show all transactions
     *
     * @return the list with all the transactions
     */
    public List<Transaction> getAll() {
        return repository.getAll();
    }

    /**
     * Search a transaction after the given input
     *
     * @param option the input to search after
     * @return the list of transactions which contain the given input
     */
    public List<Transaction> searchTransaction(String option) {
        List<Transaction> transactionsFound = new ArrayList<>();
        for (Transaction transaction : repository.getAll()) {
            if (transaction.toString().contains(option))
                transactionsFound.add(transaction);
        }
        return transactionsFound;
    }

    /**
     * Sort client card of transaction after discount
     *
     * @return transactions sorted by client cards and the value of the discount
     */
    public List<Transaction> sortClientCardsByDiscount() {
        Comparator<Transaction> byTotalPrice = (o1, o2) -> {
            int t1 = 0;
            int t2 = 0;
            Medicine medidicineFromTR1 = this.repositoryMedicine.findById(o1.getIdMedicine());
            Medicine medidicineFromTR2 = this.repositoryMedicine.findById(o2.getIdMedicine());

            int discountT1 = medidicineFromTR1.isRecipe() && o1.isWithRecipe() ? 15 : 10;
            int discountT2 = medidicineFromTR2.isRecipe() && o2.isWithRecipe() ? 15 : 10;

            double transaction1Total = medidicineFromTR1.getPrice() * o1.getNumberMedicine();
            double transaction2Total = medidicineFromTR2.getPrice() * o2.getNumberMedicine();

            double discountT1Total = transaction1Total * discountT1/100;
            double discountT2Total = transaction2Total * discountT2/100;

            return (int)discountT2Total - (int)discountT1Total;
        };
        List<Transaction> transactions = new ArrayList<>(repository.getAll());
        Collections.sort(transactions, byTotalPrice);
        return transactions;
    }

    /**
     * Show transactions between a date interval
     * @param startDate the start of the interval to search after
     * @param endDate the end of the interval to search after
     * @return the transactions between the given interval
     * @throws ParseException if the format of dates are wrong
     */
    public List<Transaction> showTransactionByDate(String startDate, String endDate) throws ParseException {
        ArrayList<Transaction> foundTransactions = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = sdf.parse(startDate);
        Date date2 = sdf.parse(endDate);
        List<Transaction> transactions = this.getAll();

        for (Transaction transaction : transactions) {
            Date currentTranDate = sdf.parse(transaction.getDate());
            if (currentTranDate.compareTo(date1) >= 0 && currentTranDate.compareTo(date2) <= 0) {
                foundTransactions.add(transaction);
            }
        }
        return foundTransactions;
    }

    /**
     * Remove transaction between a date interval
     * @param startDate the start of the interval to remove after
     * @param endDate the start of the interval to remove after
     * @return only the transactions which are not in the given interval
     * @throws ParseException if the format of dates are wrong
     */
    public List<Transaction> removeTransactionByDate(String startDate, String endDate) throws ParseException {
        ArrayList<Transaction> foundTransactions = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = sdf.parse(startDate);
        Date date2 = sdf.parse(endDate);
        List<Transaction> transactions = this.getAll();

        for (Transaction transaction : transactions) {
            Date currentTranDate = sdf.parse(transaction.getDate());
            if (currentTranDate.compareTo(date1) >= 0 && currentTranDate.compareTo(date2) <= 0) {
                foundTransactions.remove(transaction);
            }
        }
        return transactions;
    }

//    /**
//     *
//     * @param idMedicine
//     * @param numberMedicine
//     * @param idClientCard
//     * @return
//     */
//    public double getPaidPrice(int idMedicine, int numberMedicine, int idClientCard){
//        List<Medicine> medicines = repositoryMedicine.getAll();
//
//        for (Medicine medicine : medicines){
//            if (medicine.getId() == idMedicine){
//                double initialPrice = medicine.getPrice() * numberMedicine;
//                if (idClientCard != 0){
//                    if (medicine.isRecipe()) return initialPrice - (15.00/100 * initialPrice);
//                    else return initialPrice - (10.00/100 * initialPrice);
//                } else return initialPrice;
//            }
//        }
//        throw new ExceptionService("Found no Medicine for this transaction.");
//}
//
//    public List<Transaction> transactionsExpansive(){
//        List<Transaction> transactions = getAll();
//        for(Transaction transaction : transactions){
//            if(transaction.getPaidPriceForTransaction())
//        }
//    }
//
//    public List<Transaction> displayTransaction() {
//        int count = 0;
//        double avg=0;
//        List<Transaction> transList = new ArrayList<>();
//        for(Transaction t: repository.getAll()){
//            Medicine medicineSold = repositoryMedicine.findById(t.getIdMedicine());
//            avg += t.getDiscount()*t.getPieceTotal()*medicineSold.getPaidPrice();
//            count ++;
//        }
//        avg = avg / count;
//
//        for(Transaction t: repository.getAll()){
//            Medicine medicineSold = repositoryMedicine.findById(t.getIdMedicine());
//            if ( avg < t.getDiscount()*t.getPieceTotal()*medicineSold.getPaidPrice()){
//                transList.add(t);
//            }
//        }
//        return transList;
//}



}




