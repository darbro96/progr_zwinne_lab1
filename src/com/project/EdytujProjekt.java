package com.project;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.Projekt;
import com.project.util.HibernateUtil;

/**
 * Servlet implementation class EdytujProjekt
 */
@WebServlet("/EdytujProjekt")
public class EdytujProjekt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EdytujProjekt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Id: " + request.getParameter("x_projekt_id"));
		System.out.println("Nazwa: " + request.getParameter("nazwa"));
		
		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
		
		int idProjektu=Integer.parseInt(request.getParameter("x_projekt_id"));
		
		TypedQuery<Projekt> query = entityManager
				.createQuery("SELECT p FROM Projekt p WHERE p.projektId = " + idProjektu, Projekt.class);
		Projekt projekt = query.getSingleResult();
		
		projekt.setNazwa(request.getParameter("nazwa"));
		projekt.setOpis(request.getParameter("opis"));
		
		int y=Integer.parseInt(request.getParameter("dataOddania").substring(0,4));
		int m=Integer.parseInt(request.getParameter("dataOddania").substring(5,7));
		int d=Integer.parseInt(request.getParameter("dataOddania").substring(8));
		
		projekt.setDataOddania(LocalDate.of(y, m, d));
		
		entityManager.getTransaction().begin();
		entityManager.merge(projekt);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/ListaProjektow");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
