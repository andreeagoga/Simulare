package Repository;

    public class ExceptionRepository extends RuntimeException{
        public ExceptionRepository(String exceptionValidatorRepository){
            super(exceptionValidatorRepository);
        }
    }

