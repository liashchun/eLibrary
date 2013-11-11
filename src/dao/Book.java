package dao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = Book.ALL, query = "Select b From Book b"),
		@NamedQuery(name = Book.BY_NAME, query = "Select b From Book b where b.name = :name"),
		@NamedQuery(name = Book.BY_NAME_AND_PAGES, query = "Select b From Book b where b.name = :name and b.numberOfPages =:pages")
})
public class Book implements Serializable {
	private static final long serialVersionUID = 6462584529896200013L;
	
	public final static String ALL = "dao.Book.ALL";
	public final static String ALL_DTO = "dao.Book.ALL_DTO";
	public final static String BY_NAME = "dao.Book.BY_NAME";
	public final static String BY_NAME_AND_PAGES = "dao.Book.BY_NAME_AND_PAGES";
	
	@Id
	private Integer id;
	private String isbn;
	private String name;

	public Book() {
	}

	public Book(String isbn, String name) {
		this.isbn = isbn;
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "dao.Book[isbn=" + isbn + "]";
	}
}
