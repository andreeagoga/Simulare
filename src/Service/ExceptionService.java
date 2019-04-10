package Service;

public class ExceptionService extends RuntimeException{
    public ExceptionService(String exceptionValidatorService){
        super(exceptionValidatorService);
    }
}
    