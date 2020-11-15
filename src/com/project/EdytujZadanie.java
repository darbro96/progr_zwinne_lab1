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

import com.project.model.Zadanie;
import com.project.util.HibernateUtil;

/**
 * Servlet implementation class EdytujZadanie
 */
@WebServlet("/EdytujZadanie")
public class EdytujZadanie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EdytujZadanie() {
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

		System.out.println(request.getParameter("x_zadanie_id"));
		System.out.println("Zadannie: " + request.getParameter("nazwa"));

		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();

		int idZadania = Integer.parseInt(request.getParameter("x_zadanie_id"));

		TypedQuery<Zadanie> query = entityManager
				.createQuery("SELECT z FROM Zadanie z WHERE z.zadanieId = " + idZadania, Zadanie.class);
		Zadanie zadanie = query.getSingleResult();

		zadanie.setNazwa(request.getParameter("nazwa"));
		zadanie.setOpis(request.getParameter("opis"));
		zadanie.setKolejnosc(Integer.parseInt(request.getParameter("kolejnosc")));
		
		entityManager.getTransaction().begin();
		entityManager.merge(zadanie);
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
