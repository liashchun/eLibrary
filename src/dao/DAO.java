package dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * A common interface for all CRUD-Component implementations. The type of the
 * entity is specified in the implementation.
 */
public interface DAO<K, T> {
	public T create(T t);

	public T find(K id);

	public void delete(T t);

	public T update(T t);

	public Collection<T> findByNamedQuery(String queryName);

	public Collection<T> findByNamedQuery(String queryName, int resultLimit);

	public List<T> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters);

	public List<T> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters, int resultLimit);
}