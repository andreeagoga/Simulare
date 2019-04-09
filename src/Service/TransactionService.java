package Service;

import Domain.Client;
import Domain.Medicine;
import Domain.Transaction;
import Repository.IRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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
    public void addAndUpdate(Integer id, Integer idMedicine, Integer idClientCard, Integer numberMedicine, String date, String hour) {
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

        }
        Transaction transaction1 = new Transaction(id, idMedicine, idClientCard, numberMedicine, date, hour);
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
     * @return the list with all the transactions
     */
    public List<Transaction> getAll() {
        return repository.getAll();
    }

    public List<Transaction> searchTransaction(String option) {
        List<Transaction> transactionsFound = new ArrayList<>();
        for (Transaction transaction : repository.getAll()) {
            if (transaction.toString().contains(option))
                transactionsFound.add(transaction);
        }
        return transactionsFound;
    }

//    private double totalDiscount(Transaction transaction) {
//        double discount = 0;
//        if (transaction.getIdClientCard() != 0) {
//            if (repositoryMedicine.findById(transaction.getIdMedicine()).isRecipe())
//                discount = (double) (repositoryMedicine.findById(transaction.getIdMedicine()).getPrice() * 15 / 100) * transaction.getNumberMedicine();
//            else
//                discount = (double) (repositoryMedicine.findById(transaction.getIdMedicine()).getPrice() * 10 / 100) * transaction.getNumberMedicine();
//        }
//        return discount;
//    }

    public List<Transaction> sortClientCardsByDiscount() {
        Comparator<Transaction> byTotalPrice = (o1, o2) -> {
            int t1 = 0;
            int t2 = 0;
            for (Transaction transaction : repository.getAll()) {
                if (transaction.getIdClientCard() == (o1.getIdClientCard())) {
                    if (repositoryMedicine.findById(transaction.getIdMedicine()).isRecipe())
                        t1 += (repositoryMedicine.findById(transaction.getIdMedicine()).getPrice() * 15 / 100) * transaction.getNumberMedicine();
                    else {
                        t1 += (repositoryMedicine.findById(transaction.getIdMedicine()).getPrice() * 10 / 100) * transaction.getNumberMedicine();
                    }
                }
                if (transaction.getIdClientCard() == (o2.getIdClientCard())) {
                    if (repositoryMedicine.findById(transaction.getIdMedicine()).isRecipe())
                        t2 += (repositoryMedicine.findById(transaction.getIdMedicine()).getPrice() * 15 / 100) * transaction.getNumberMedicine();
                    else {
                        t2 += (repositoryMedicine.findById(transaction.getIdMedicine()).getPrice() * 10 / 100) * transaction.getNumberMedicine();
                    }

                }
            }
            return t2 - t1;
        };
        List<Transaction> transactions = new ArrayList<>(repository.getAll());
        transactions.sort(byTotalPrice);
        return transactions;
        }

//    public void showTransactionByDate (String start , String finish){
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        Date begin = data(start);
//        Date end = data(finish);
//        int i=0;
//        for (Transaction transaction : repository.getAll()) {
//            if(transaction.getDate().
//            (begin) && transaction.getData().before(end)){
//                System.out.printf("%d. ID:%-5s |ID-Drug: %-3s |ID-Clientcard: %-3s |Bucati: %-3d |Disccount: %-6.2f   |Pret platit: %-6.2f   |Data si ora:%-10s %n",i,t.getId(),t.getId_drug(),t.getId_clientcard(),t.getBucati(),disccount(t),pretPlatit(t),formatter.format(t.getData_ora()));
//                i++;
//            }
//        }
//    }
    }


