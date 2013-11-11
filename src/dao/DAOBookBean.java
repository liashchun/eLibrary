package dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local(DAO.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DAOBookBean implements DAO<Integer, Book> {

	@PersistenceContext
	private EntityManager em;

	public Book create(Book t) {
		this.em.persist(t);
		return t;
	}

	public void delete(Book t) {
		t = this.em.merge(t);
		this.em.remove(t);
	}

	public Book find(Integer id) {
		return this.em.find(Book.class, id);
	}

	public Book update(Book t) {
		return this.em.merge(t);
	}

	@SuppressWarnings("unchecked")
	public List<Book> findByNamedQuery(String namedQueryName) {
		return this.em.createNamedQuery(namedQueryName).getResultList();
	}

	public List<Book> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters) {
		return findByNamedQuery(namedQueryName, parameters, 0);
	}

	@SuppressWarnings("unchecked")
	public List<Book> findByNamedQuery(String queryName, int resultLimit) {
		return this.em.createNamedQuery(queryName).setMaxResults(resultLimit)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Book> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters, int resultLimit) {
		Set<Entry<String, Object>> rawParameters = parameters.entrySet();
		Query query = this.em.createNamedQuery(namedQueryName);
		if (resultLimit > 0)
			query.setMaxResults(resultLimit);
		for (Entry<String, Object> entry : rawParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}

}
