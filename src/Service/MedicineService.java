package Service;

import Domain.Medicine;
import Domain.Transaction;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MedicineService {
    private IRepository<Medicine> repository;
    private IRepository<Transaction> repositoryTransactions;
    private Stack<UndoRedoOperation<Medicine>> undoableOperations = new Stack<>();
    private Stack<UndoRedoOperation<Medicine>> redoableOperations = new Stack<>();

    /**
     *  Instantiates a service
     * @param repository the repository used by the server
     */
    public MedicineService(IRepository<Medicine> repository) {
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
            if (recipe != true && recipe != false){
                recipe = medicine.isRecipe();
            }
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
     * @return the list with all medicines
     */
    public List<Medicine> getAll(){
        return repository.getAll();
    }

    /**
     *
     * @param option
     * @return
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
     *
     * @return
     */
    public List<Medicine> sortMedicineBySales() {
        Comparator<Medicine> bySales = (d1, d2) -> {
            int t1 = 0, t2 = 0;
            for (Transaction transaction : repositoryTransactions.getAll()) {
                if (transaction.getId().equals(d1.getId()))
                    t1 += transaction.getNumberMedicine();
                if (transaction.getIdMedicine() == (d2.getId()))
                    t2 += transaction.getNumberMedicine();
            }
            return t2 - t1;
        };
        List<Medicine> medicines = new ArrayList<>(repository.getAll());
        medicines.sort(bySales);
        return medicines;
    }

    /**
     *
     */
    public void undo() {
        if (!undoableOperations.empty()) {
            UndoRedoOperation<Medicine> lastOperation = undoableOperations.pop();
            lastOperation.doUndo();
            redoableOperations.add(lastOperation);

        }
    }

    /**
     *
     */
    public void redo() {
        if (!redoableOperations.empty()) {
            UndoRedoOperation<Medicine> lastOperation = redoableOperations.pop();
            lastOperation.doRedo();
            undoableOperations.add(lastOperation);
        }
    }
}
