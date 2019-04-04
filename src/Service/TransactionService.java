package Service;

import Domain.Transaction;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    private IRepository<Transaction> repository;

    /**
     *  Instantiates a service
     * @param repository the repository used by the server
     */
    public TransactionService(IRepository<Transaction> repository){
        this.repository = repository;
    }

    /**
     * Add and update a transaction to the repository
     * @param id the transaction's id to add and update
     * @param idMedicine the id of a medicine to add and update
     * @param idClientCard the client's id to add and update
     * @param numberMedicine the number of medicine of the transaction to add and update
     * @param date the date of the transaction to add and update
     * @param hour the hour of the transaction to add and update
     */
    public void addAndUpdate(Integer id,Integer idMedicine, Integer idClientCard, Integer numberMedicine, String date,String hour){
        Transaction transaction = repository.findById(id);
        if(transaction != null){
            if (idMedicine != null){
                idMedicine = transaction.getIdMedicine();
            }
            if (idClientCard != null){
                idClientCard = transaction.getIdClientCard();
            }
            if (numberMedicine == 0) {
                numberMedicine = transaction.getNumberMedicine();
            }
            if (date.isEmpty()){
                date = transaction.getDate();
            }

            if (hour.isEmpty()){
                hour = transaction.getHour();
            }

        }
        Transaction transaction1 = new Transaction(id, idMedicine, idClientCard, numberMedicine, date, hour);
        repository.addAndUpdate(transaction1);
    }

    /**
     * Remove a transaction from the repository
     * @param id the id of the transaction to remove
     */
    public void delete(Integer id){
        repository.remove(id);
    }

    /**
     * @return the list with all the transactions
     */
    public List<Transaction> getAll(){
        return  repository.getAll();
    }

    public List<Transaction> searchTransaction(String option){
        List<Transaction> transactionsFound = new ArrayList<>();
        for(Transaction transaction : repository.getAll()){
            if(transaction.toString().contains(option))
                transactionsFound.add(transaction);
        }
        return transactionsFound;
    }
}
