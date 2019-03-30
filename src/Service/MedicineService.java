package Service;

import Domain.Medicine;
import Repository.IRepository;

import java.util.List;

public class MedicineService {
    private IRepository<Medicine> repository;

    /**
     *  Instantiates a service
     * @param repository the repository used by the server
     */
    public MedicineService(IRepository<Medicine> repository) {
        this.repository = repository;
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

    public void searchMedicine(String option){
        int i = 0;
        for(Medicine medicine : repository.getAll()){
            if(medicine.toString().contains(option))
                System.out.printf("%d. ID:%-5s |Name: %-15s |First name: %-10s |Producer: %-10s |Price:%-10s |Recipe:%-10s %n",i, medicine.getId(),medicine.getName(),medicine.getFirstName(),medicine.getPrice(), medicine.isRecipe());
        }
    }
}
