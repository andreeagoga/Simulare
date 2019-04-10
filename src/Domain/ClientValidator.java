package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientValidator implements IValidator<Client> {

    /**
     * Validates a client
     * @param client the client to validate
     * @throws RuntimeException if there are validation errors
     */
    public void validate(Client client){
        String errors = "";
        if(!client.getName().matches( "[A-Z][a-zA-Z]*" )){
            errors +="The name contains only letters and starts with a big letter\n";
        }
        if(!client.getFirstName().matches( "[A-Z][a-zA-Z]*" )) {
            errors += "The first name contains only letters and starts with a big letter\n";
        }
        if(client.getCNP().length() != 13){
            errors += "The CNP is not correct!\n";
        }
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            format.parse(client.getDateOfBirth());
        } catch (ParseException pe) {
            errors += "The date of birth is not in a correct format!\n";
        }
        try {
            format.parse(client.getDateOfRegistration());
        } catch (ParseException pe) {
            errors += "The date of registration is not in a correct format!\n";
        }
        if(!errors.isEmpty()){
            throw new ExceptionDomain("Nu s-a validat"+errors);
        }
    }
}
