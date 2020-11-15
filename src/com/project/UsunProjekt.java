package com.project;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class UsunProjekt
 */
@WebServlet("/UsunProjekt")
public class UsunProjekt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsunProjekt() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());

//		System.out.println(request.getParameter("x_projekt_id"));
//		
//		Map<String, String[]> map=new HashMap<String, String[]>();
//		map=request.getParameterMap();
//		for(String key:map.keySet())
//		{
//			System.out.println("Klucz: "+key);
//		}
//		
//		for(String[] v:map.values())
//		{
//			for(String s:v)
//			{
//				System.out.println("Wartoœæ: "+s);
//			}
//		}

		int idProjekt = Integer.parseInt(request.getParameter("x_projekt_id"));
		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
		TypedQuery<Projekt> query = entityManager
				.createQuery("SELECT p FROM Projekt p WHERE p.projektId = " + idProjekt, Projekt.class);
		Projekt projekt = query.getSingleResult();
		System.out.println("Projekt: "+projekt);
		if (projekt != null) {
			TypedQuery<Zadanie> queryZadania = entityManager
					.createQuery("SELECT z FROM Zadanie z WHERE z.projekt.projektId = " + idProjekt, Zadanie.class);
			List<Zadanie> zadania = queryZadania.getResultList();
			entityManager.getTransaction().begin();
			System.out.println("Zadania: ");
			for (Zadanie z : zadania) {
				entityManager.remove(z);
				System.out.println("Zadanie: "+z);
			}
			entityManager.remove(projekt);
			entityManager.getTransaction().commit();
		}
		entityManager.close();
		response.sendRedirect("/project-web-app2/ListaProjektow");
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
