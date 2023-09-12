package modulo03.ProjetoLocadora.services.Contracts;

public interface CrudService<T> {

   // T findById(String id);

    boolean add(T object);

    boolean remove(T object);

    boolean edit(T object);
}

