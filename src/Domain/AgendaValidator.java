package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AgendaValidator  implements IValidator<Agenda> {

    public void validate(Agenda agenda){
        String errors = "";
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
        try {
            formatDate.parse(agenda.getZi());
        } catch (ParseException pe) {
            errors += "The date is not in a correct format!\n";
        }
        SimpleDateFormat formatTime = new SimpleDateFormat("hh:mm");
        try{
            formatTime.parse(agenda.getOra());
        } catch (ParseException p) {
            errors += "The time is not in a correct format!\n";
        }
        if(agenda.getDurata() < 0){
            errors +="The duration is positive\n";
        }
        if(!errors.isEmpty()){
            throw new ExceptionDomain("Nu s-a validat"+errors);
        }
    }
}
