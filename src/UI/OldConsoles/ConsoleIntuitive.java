package UI.OldConsoles;

import Domain.Client;
import Domain.Medicine;
import Domain.Transaction;
import Service.ClientService;
import Service.MedicineService;
import Service.TransactionService;

import java.util.Scanner;

public class ConsoleIntuitive {
    private MedicineService medicineService;
    private ClientService clientService;
    private TransactionService transactionService;
    private Scanner scanner;

    public ConsoleIntuitive(MedicineService medicineService, ClientService clientService, TransactionService transactionService) {
        this.medicineService = medicineService;
        this.clientService = clientService;
        this.transactionService = transactionService;
        this.scanner = new Scanner(System.in);
    }

    public void showInstructions() {
        System.out.println("Please write here what do you want to do!\n " +
                "Option 1: If you want to add or update a medicine/client/transaction, write:\n" +
                "\tFor medicine: addmedicine/updatemedicine,id,name,first name,producer,price,recipe\n"+
                "\tFor client: addclient/updateclient,id,name,first name,CNP,date of birth,date of registration\n"+
                "\tFor transaction: addtransaction/updatetransaction,id,id of medicine,id of client card,number of medicines,date, hour\n"+
                "Option 2: If you want to remove a medicine/client/transaction, write:\n"+
                "\tFor medicine: removemedicine,id\n"+
                "\tFor client: removeclient,id\n"+
                "\tFor transaction: removetransaction,id\n"+
                "Option 3: If you want to show all the medicines/clients/transactions, write:\n " +
                "\tFor medicines: allmedicines\n"+
                "\tFor clients: allclients\n"+
                "\tFor transactions: alltransactions\n"+
                "Separate the words with \",\" and do not use any spaces!\n");
        System.out.println("Please give here your actions:");
        String ex = scanner.nextLine();
        while (!ex.toLowerCase().contains("exit")) {
            interpretActions(ex);
            ex = scanner.nextLine();
        }
    }

    public void interpretActions(String action){
        String[] option = action.split(",");
        if(option[0].equalsIgnoreCase("addmedicine")){
            handleAddAndUpdateMedicine(Integer.parseInt(option[1]), option[2], option[3], option[4],Double.parseDouble(option[5]), Boolean.parseBoolean(option[6]));
        }
        if(option[0].equalsIgnoreCase("updatemedicine")){
            handleAddAndUpdateMedicine(Integer.parseInt(option[1]), option[2], option[3], option[4],Double.parseDouble(option[5]), Boolean.parseBoolean(option[6]));
        }
        if(option[0].equalsIgnoreCase("removemedicine")) {
            handleRemoveMedicine(Integer.parseInt(option[1]));
        }
        if(option[0].equalsIgnoreCase("allmedicines")){
            handleAllMedicine();
        }
        if(option[0].equalsIgnoreCase("addclient")){
            handleAddAndUpdateClient(Integer.parseInt(option[1]), option[2], option[3], option[4],option[5], option[6]);
        }
        if(option[0].equalsIgnoreCase("updateclient")){
            handleAddAndUpdateClient(Integer.parseInt(option[1]), option[2], option[3], option[4],option[5], option[6]);
        }
        if(option[0].equalsIgnoreCase("removeclient")) {
            handleRemoveClient(Integer.parseInt(option[1]));
        }
        if(option[0].equalsIgnoreCase("allclients")){
            handleAllClients();
        }
        if(option[0].equalsIgnoreCase("addtransaction")){
            handleAddAndUpdateTransaction(Integer.parseInt(option[1]), Integer.parseInt(option[2]), Integer.parseInt(option[3]), Integer.parseInt(option[4]),option[5], option[6]);
        }
        if(option[0].equalsIgnoreCase("updattransaction")){
            handleAddAndUpdateTransaction(Integer.parseInt(option[1]), Integer.parseInt(option[2]), Integer.parseInt(option[3]), Integer.parseInt(option[4]),option[5], option[6]);
        }
        if(option[0].equalsIgnoreCase("removetransaction")) {
            handleRemoveTransaction(Integer.parseInt(option[1]));
        }
        if(option[0].equalsIgnoreCase("alltransactions")){
            handleAllTransactions();
        }
    }

    private void handleAddAndUpdateMedicine(Integer id, String name, String firstName, String producer, Double price, Boolean recipe){
        try {
            medicineService.addAndUpdate(id, name, firstName, producer, price, recipe);
            System.out.println("Medicine added!\n");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleRemoveMedicine(Integer id){
        try {
            medicineService.delete(id);
            System.out.println("Medicine removed!\n");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private  void handleAllMedicine() {
        try {
            for (Medicine medicine : medicineService.getAll()) {
                System.out.println(medicine);
            }
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddAndUpdateClient(Integer id, String name, String firstName, String CNP, String dateOfBirth, String dateOfRegistration){
        try {
            clientService.addAndUpdate(id, name, firstName, CNP, dateOfBirth, dateOfRegistration);
            System.out.println("Client added!\n");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleRemoveClient(Integer id){
        try {
            clientService.delete(id);
            System.out.println("Client removed!\n");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private  void handleAllClients() {
        try {
            for (Client client : clientService.getAll()) {
                System.out.println(client);
            }
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddAndUpdateTransaction(Integer id, Integer idMedicine, Integer idClientCard, Integer numberMedicine, String date, String hour){
        try {
            transactionService.addAndUpdate(id, idMedicine, idClientCard, numberMedicine, date, hour);
            System.out.println("Transaction added!\n");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleRemoveTransaction(Integer id){
        try {
            transactionService.delete(id);
            System.out.println("Transaction removed!\n");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private  void handleAllTransactions() {
        try {
            for (Transaction transaction: transactionService.getAll()) {
                System.out.println(transaction);
            }
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

}
