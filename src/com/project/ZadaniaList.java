package com.project;

import java.io.IOException;
import java.util.List;

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
import com.project.model.Zadanie;
import com.project.util.HibernateUtil;

/**
 * Servlet implementation class ZadaniaList
 */
@WebServlet("/ZadaniaList")
public class ZadaniaList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ZadaniaList() {
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
		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
		String projekt_id = request.getParameter("x_projekt_id");

		System.out.println(projekt_id);

		TypedQuery<Projekt> query = entityManager.createQuery(
				"SELECT p FROM Projekt p WHERE p.projektId = " + Integer.parseInt(projekt_id), Projekt.class);
		Projekt projekt = query.getSingleResult();
		
		TypedQuery<Zadanie> query2 = entityManager.createQuery(
				"FROM Zadanie WHERE projekt.projektId="+projekt_id, Zadanie.class);
		List<Zadanie> zadania=query2.getResultList();
		System.out.println("Ilosc: " + zadania.size());
		for (Zadanie z : zadania) {
			System.out.println(z.getNazwa());
		}
		request.setAttribute("zadania", zadania);
		ServletContext context = getServletContext();

		request.setAttribute("projekt", projekt);
		RequestDispatcher dispatcher = context.getRequestDispatcher("/zadania.jsp");
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
