package Repository;

    public class ExceptionValidatorRepository extends RuntimeException{
        public ExceptionValidatorRepository(String exceptionValidatorRepository){
            super(exceptionValidatorRepository);
        }
    }

