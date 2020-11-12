package com.project;

import java.io.IOException;
import java.time.LocalDateTime;

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
 * Servlet implementation class DodajZadanie
 */
@WebServlet("/DodajZadanie")
public class DodajZadanie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DodajZadanie() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		int idProjekt = Integer.parseInt(request.getParameter("x_projekt_id"));
		System.out.println("DodajZadanie:"+idProjekt);

		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();

		TypedQuery<Projekt> query = entityManager
				.createQuery("SELECT p FROM Projekt p WHERE p.projektId = " + idProjekt, Projekt.class);
		Projekt projekt = query.getSingleResult();
		if (projekt != null) {
			String nazwa = request.getParameter("nazwa");
			String opis = request.getParameter("opis");
			String kolejnosc = request.getParameter("kolejnosc");
			Zadanie zadanie=new Zadanie();
			zadanie.setDataczasOddania(LocalDateTime.now());
			zadanie.setKolejnosc(Integer.parseInt(kolejnosc));
			zadanie.setNazwa(nazwa);
			zadanie.setOpis(opis);
			zadanie.setProjekt(projekt);
			entityManager.getTransaction().begin();
			entityManager.persist(zadanie);
			entityManager.getTransaction().commit();
			entityManager.close();
		}

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
//		int idProjekt = Integer.parseInt(request.getParameter("x_projekt_id"));
//
//		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
//
//		TypedQuery<Projekt> query = entityManager
//				.createQuery("SELECT p FROM Projekt p WHERE p.projektId = " + idProjekt, Projekt.class);
//		Projekt projekt = query.getSingleResult();
//		if (projekt != null) {
//			String nazwa = request.getParameter("nazwa");
//			String opis = request.getParameter("opis");
//			String kolejnosc = request.getParameter("kolejnosc");
//			System.out.print(nazwa + " " + opis + " " + kolejnosc);
//		}
//
//		entityManager.close();

	}

}
