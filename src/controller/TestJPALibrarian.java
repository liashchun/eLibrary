package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.*;
import entities.*;
import java.util.*;
import java.math.*;

/**
 * Servlet implementation class AddStudentToUniversity
 */
@WebServlet("/TestJPALibrarian")
public class TestJPALibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestJPALibrarian() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("eLibraryPU");
		EntityManager em = emf.createEntityManager();
		try {

			Librarian first = new Librarian(5, "First", new BigDecimal(3423));		
			
			em.getTransaction().begin();
			em.persist(first);
			em.flush();
			em.getTransaction().commit();

			Librarian recovered = em.find(Librarian.class, 1);
			if (recovered != null) {
				try {
					PrintWriter writer = response.getWriter();
					response.setContentType("text/plain");
					writer.write("Hello, " + recovered.getName());
					writer.close();
				} catch (IOException e) {
				}
			} else {
				try {
					PrintWriter writer = response.getWriter();
					response.setContentType("text/plain");
					writer.write("ERROR! Null pointer!");
					writer.close();
				} catch (IOException e) {
				}
			}
		} finally {
			em.close();
		}

		emf.close();
	}
}
