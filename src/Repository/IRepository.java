package Repository;

import Domain.Entity;

import java.util.List;

public interface IRepository <T extends Entity>{

        T findById(Integer id);
        void addAndUpdate(T medicine);
        void remove(Integer id);
        List<T> getAll();
}
