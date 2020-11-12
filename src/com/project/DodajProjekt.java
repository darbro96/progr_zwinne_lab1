package com.project;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
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
 * Servlet implementation class DodajProjekt
 */
@WebServlet("/DodajProjekt")
public class DodajProjekt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DodajProjekt() {
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
		Projekt projekt = new Projekt();
		projekt.setDataczasUtworzenia(LocalDateTime.now());
		projekt.setNazwa(request.getParameter("nazwa"));
		projekt.setOpis(request.getParameter("opis"));
		String dataOddania = request.getParameter("dataOddania");
		projekt.setDataOddania(LocalDate.of(Integer.parseInt(dataOddania.substring(0, 4)),Integer.parseInt(dataOddania.substring(5, 7)), Integer.parseInt(dataOddania.substring(8))));
		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(projekt);
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
