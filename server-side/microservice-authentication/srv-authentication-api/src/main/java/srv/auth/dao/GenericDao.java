package srv.auth.dao;

import java.util.List;

public interface GenericDao<T>{

    T findOne(final long id);

    List<T> findAll();

    public T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);
}
