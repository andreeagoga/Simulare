package Service;

public class ExceptionValidatorService extends RuntimeException{
    public ExceptionValidatorService(String exceptionValidatorService){
        super(exceptionValidatorService);
    }
}
    