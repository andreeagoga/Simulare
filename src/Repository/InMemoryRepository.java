package Repository;

import Domain.Entity;
import Domain.IValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T extends Entity> implements IRepository<T> {
    private Map<Integer, T> storage = new HashMap<>();
    private IValidator<T> validator;

    public InMemoryRepository(IValidator<T> validator){
        this.validator = validator;
    }

    public T findById(Integer id){
        return  storage.get(id);
    }

    public void addAndUpdate(T entity){
        validator.validate(entity);
        storage.put(entity.getId(), entity);
    }


    public List<T> getAll(){
        return  new ArrayList<>(storage.values());
    }

}
