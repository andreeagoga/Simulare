package Domain;

public class MedicineValidator implements IValidator<Medicine> {

    /**
     *Validates a medicine
     * @param medicine the medicine to validate
     * @throws RuntimeException if there are validation errors
     */
    public void validate(Medicine medicine){
        String errors = "";
        if(medicine.getPrice() < 0){
            errors += "The price is positive!\n";
        }
        if(!medicine.getName().matches( "[A-Z][a-zA-Z]*" )){
            errors +="The name contains only letters and starts with a big letter\n";
        }
        if(!medicine.getFirstName().matches( "[A-Z][a-zA-Z]*" )){
            errors +="The first name contains only letters and starts with a big letter\n";
        }
        if(!medicine.getProducer().matches( "[A-Z][a-zA-Z]*" )){
            errors +="The producer contains only letters and starts with a big letter\n";
        }
        if ("true".equals(!medicine.isRecipe()) || "false".equals(!medicine.isRecipe())) {
            errors +="You need to have/not have recipe (choose true or false)\n";
        }
        if(!errors.isEmpty()){
            throw new ExceptionValidatorDomain("Nu s-a validat"+errors);
        }
    }
}
