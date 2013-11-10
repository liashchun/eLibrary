package dao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * 
 * @author blog.adam-bien.com
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class GenericCrudTest {

	@EJB
	private CrudService crudService;
	private static final String NEW_LINE = "<br/>";

	public String crudBook(String isbn, String name) {
		StringBuilder builder = new StringBuilder();
		Book book = new Book(isbn, name);
		this.crudService.create(book);
		builder.append("Book created: " + book).append(NEW_LINE);
		int size = this.crudService.findWithNamedQuery(Book.ALL).size();
		builder.append("findAll returns " + size + " books !").append(NEW_LINE);
		String newName = name + "[u]";
		book.setName(newName);

		builder.append("updating book").append(NEW_LINE);
		book = this.crudService.update(book);
		size = this.crudService.findWithNamedQuery(Book.BY_NAME,
				QueryParameter.with("name", newName).parameters()).size();
		builder.append("findAllByName returns " + size + " books !").append(
				NEW_LINE);

		builder.append("deleting book").append(NEW_LINE);
		this.crudService.delete(book.getClass(), book.getIsbn());

		size = this.crudService.findWithNamedQuery(Book.ALL).size();
		builder.append("findAll returns " + size + " books !").append(NEW_LINE);
		return builder.toString();
	}
}
