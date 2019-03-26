package UI;

import Domain.Client;
import Domain.Medicine;
import Domain.Transaction;
import Service.ClientService;
import Service.MedicineService;
import Service.TransactionService;

import java.util.Scanner;

public class Console {
    private MedicineService medicineService;
    private ClientService clientService;
    private TransactionService transactionService;
    private Scanner scanner;

    public Console(MedicineService medicineService, ClientService clientService, TransactionService transactionService) {
        this.medicineService = medicineService;
        this.clientService = clientService;
        this.transactionService = transactionService;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Medicines");
        System.out.println("2. Clients");
        System.out.println("3. Transactions");
        System.out.println("x. Exit");
    }

    /**
     * Choose the submenu you want to use
     */
    public void run(){
        while (true){
            showMenu();
            String option = scanner.nextLine();
            switch (option){
                case "1":
                    runMedicines();
                    break;
                case "2":
                    runClients();
                    break;
                case "3":
                    runTransactions();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }

        }
    }

    private void showMedicineMenu() {
        System.out.println("1. Add or update medicines");
        System.out.println("2. Remove medicine");
        System.out.println("3. Show all");
        System.out.println("x. Back");
    }

    private void runMedicines(){
        while (true) {
            showMedicineMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddOrUpdateMedicine();
                    break;
                case "2":
                    handleDeleteMedicine();
                    break;
                case "3":
                    handleShowAllMedicines();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid Option!");
            }
        }
    }

    private void handleAddOrUpdateMedicine() {
        try {
            System.out.print("Enter id: ");
            Integer id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter firstName: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter the producer: ");
            String producer = scanner.nextLine();
            System.out.print("Enter price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter recipe (true/false): ");
            boolean recipe = Boolean.parseBoolean(scanner.nextLine());

            medicineService.addAndUpdate( id, name, firstName, producer, price, recipe);

            System.out.println("Medicine added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleDeleteMedicine() {
        try {
            System.out.print("Enter id to remove: ");
            Integer id = Integer.parseInt(scanner.nextLine());

            medicineService.delete(id);

            System.out.println("Medicine removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleShowAllMedicines() {
        for (Medicine medicine : medicineService.getAll()) {
            System.out.println(medicine);
        }
    }
    private void showClientMenu() {
        System.out.println("1. Add or update clients");
        System.out.println("2. Remove client");
        System.out.println("3. Show all");
        System.out.println("x. Back");
    }

    private void runClients(){
        while (true) {
            showClientMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddOrUpdateClient();
                    break;
                case "2":
                    handleDeleteClient();
                    break;
                case "3":
                    handleShowAllClients();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid Option!");
            }
        }
    }
    private void handleAddOrUpdateClient() {
        try {
            System.out.print("Enter id: ");
            Integer id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter firstName: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter CNP: ");
            String CNP = scanner.nextLine();
            System.out.print("Enter date of birth: ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Enter date of registration: ");
            String dateOfRegistration = scanner.nextLine();

            clientService.addAndUpdate(id, name, firstName, CNP, dateOfBirth, dateOfRegistration);

            System.out.println("Client added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleDeleteClient() {
        try {
            System.out.print("Enter id to remove: ");
            Integer id = Integer.parseInt(scanner.nextLine());

            clientService.delete(id);

            System.out.println("Client removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleShowAllClients() {
        for (Client client : clientService.getAll()) {
            System.out.println(client);
        }
    }

    private void showTransactionMenu() {
        System.out.println("1. Add or update transactions");
        System.out.println("2. Remove transactions");
        System.out.println("3. Show all");
        System.out.println("x. Back");
    }

    private void runTransactions(){
        while (true) {
            showTransactionMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddOrUpdateTransaction();
                    break;
                case "2":
                    handleDeleteTransaction();
                    break;
                case "3":
                    handleShowAllTransactions();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid Option!");
            }
        }
    }
    private void handleAddOrUpdateTransaction() {
        try {
            System.out.print("Enter id: ");
            Integer id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter id medicine: ");
            Integer idMedicine = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter id card client: ");
            Integer idClientCard = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter number of medicines: ");
            Integer numberMedicine = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter date: ");
            String date = scanner.nextLine();
            System.out.print("Enter hour: ");
            String hour = scanner.nextLine();

            transactionService.addAndUpdate( id, idMedicine, idClientCard, numberMedicine, date, hour);

            System.out.println("Transaction added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleDeleteTransaction() {
        try {
            System.out.print("Enter id to remove: ");
            Integer id = Integer.parseInt(scanner.nextLine());

            transactionService.delete(id);

            System.out.println("Transaction removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleShowAllTransactions() {
        for (Transaction transaction : transactionService.getAll()) {
            System.out.println(transaction);
        }
    }
}
