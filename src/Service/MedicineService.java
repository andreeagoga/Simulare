package Service;

import Domain.Medicine;
import Domain.Transaction;
import Repository.IRepository;

import java.util.*;

public class MedicineService {
    private IRepository<Medicine> repository;
    private IRepository<Transaction> repositoryTransactions;
    private Stack<UndoRedoOperation<Medicine>> undoableOperations = new Stack<>();
    private Stack<UndoRedoOperation<Medicine>> redoableOperations = new Stack<>();

    /**
     *  Instantiates a service
     * @param repository the repository used by the server
     */
    public MedicineService(IRepository<Medicine> repository, IRepository<Transaction> repositoryTransactions) {
        this.repository = repository;
        this.repositoryTransactions = repositoryTransactions;
    }

    /**
     * Add and update a medicine to the repository
     * @param id the medicine's id to add and update
     * @param name the name of the medicine to add and update
     * @param firstName the first name of the medicine to add and update
     * @param producer the producer of the medicine to add and update
     * @param price the price of the medine to add and update
     * @param recipe the variable which decide if there is any recipe or not and update
     */
    public void addAndUpdate(int id, String name, String firstName, String producer, double price, boolean recipe){
        Medicine medicine = repository.findById(id);
        if(medicine != null){
            if (name.isEmpty()){
                name = medicine.getName();
            }
            if (firstName.isEmpty()) {
                firstName = medicine.getFirstName();
            }
            if (producer.isEmpty()){
                producer = medicine.getProducer();
            }
            if (price == 0){
                price = medicine.getPrice();
            }
                recipe = !!medicine.isRecipe();

        }
        Medicine medicine1 = new Medicine(id, name, firstName, producer, price, recipe);
        repository.addAndUpdate(medicine1);
    }

    /**
     * Remove the medicine with the given id
     * @param id the id of the medicine to remove
     */
    public void delete(Integer id) {
        repository.remove(id);
    }

    /**
     * Show the list with all the medicines
     * @return the list with all medicines
     */
    public List<Medicine> getAll(){
        return repository.getAll();
    }

    /**
     * Search a medicine after the given input
     * @param option the input to search the medicine
     * @return the medicines with the given input
     */
    public List<Medicine> searchMedicine(String option){
        List<Medicine> medicinesFound = new ArrayList<>();
        for(Medicine medicine : repository.getAll()){
            if(medicine.toString().contains(option))
                medicinesFound.add(medicine);
        }
        return medicinesFound;
    }

    /**
     * Sort medicine after the sales
     * @return the sorted medicines
     */
    public List<Medicine> sortMedicineBySales() {
        Comparator<Medicine> bySales = (d1, d2) -> {
            int t1 = 0, t2 = 0;
            for (Transaction transaction : this.repositoryTransactions.getAll()) {
                if (transaction.getId() == d1.getId())
                    t1 += transaction.getNumberMedicine();
                if (transaction.getIdMedicine() == d2.getId())
                    t2 += transaction.getNumberMedicine();
            }
            return t2 - t1;

        };
        List<Medicine> medicines = new ArrayList<>(repository.getAll());
        Collections.sort(medicines, bySales);
        return medicines;
    }

    /**
     * Undo the last operation
     */
    public void undo() {
        if (!undoableOperations.empty()) {
            UndoRedoOperation<Medicine> lastOperation = undoableOperations.pop();
            lastOperation.doUndo();
            redoableOperations.add(lastOperation);

        }
    }

    /**
     * Redo the last operation
     */
    public void redo() {
        if (!redoableOperations.empty()) {
            UndoRedoOperation<Medicine> lastOperation = redoableOperations.pop();
            lastOperation.doRedo();
            undoableOperations.add(lastOperation);
        }
    }
}
