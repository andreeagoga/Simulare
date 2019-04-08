package Domain;
import java.lang.RuntimeException;

public class ExceptionValidatorDomain extends RuntimeException{
        public ExceptionValidatorDomain(String exceptionValidatorDomain){
            super(exceptionValidatorDomain);
        }
    }
