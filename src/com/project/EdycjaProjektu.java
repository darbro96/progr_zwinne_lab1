package com.project;

import java.io.IOException;

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
 * Servlet implementation class EdycjaProjektu
 */
@WebServlet("/EdycjaProjektu")
public class EdycjaProjektu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EdycjaProjektu() {
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
		int idProjektu = Integer.parseInt(request.getParameter("x_projekt_id"));
		System.out.println(idProjektu);

		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();

		TypedQuery<Projekt> query = entityManager
				.createQuery("SELECT p FROM Projekt p WHERE p.projektId = " + idProjektu, Projekt.class);
		Projekt projekt = query.getSingleResult();

		entityManager.close();

		request.setAttribute("projekt", projekt);
		request.setAttribute("x_projekt_id", idProjektu);

		ServletContext context = getServletContext();
		entityManager.close();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/edycja_projektu.jsp");
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
