package com.mb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import com.facade.*;
import com.model.*;

@ManagedBean
@SessionScoped
public class SearchBean {

	@EJB
	private DogFacade dogFacade;
	
	@EJB
	private BookFacade bookFacade;
	
	private static final String STAY_IN_THE_SAME_PAGE = null;
	private static final String SEARCH_RESULTS = "searchResults";
	
	private boolean visibleSearch;
	private String authors;
	private String bookName;
	private String isbn;
	private String keywords;
	private String genre;
	
	private List<Book> selectedList; 

	public List<Book> getSelectedList() {
		return selectedList;
	}

	public String getGenre() {
		return genre;
	}
	
	public String search() {
		selectedList = bookFacade.findByCriterias(bookName, authors, isbn, keywords, genre);
		return SEARCH_RESULTS;		
	}
	
	public String makeOrder() {
		selectedList = bookFacade.findByCriterias(bookName, authors, isbn, keywords, genre);
		return SEARCH_RESULTS;		
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public boolean isVisibleSearch() {
		return visibleSearch;
	}

	public void setVisibleSearch(boolean visibleSearch) {
		this.visibleSearch = visibleSearch;
	}

	private void sendInfoMessageToUser(String message){
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	private void sendErrorMessageToUser(String message){
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	private FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context;
	}
}