package com.project;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.Projekt;
import com.project.model.Zadanie;
import com.project.util.HibernateUtil;

/**
 * Servlet implementation class UsunZadanie
 */
@WebServlet("/UsunZadanie")
public class UsunZadanie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsunZadanie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int idZadanie = Integer.parseInt(request.getParameter("x_zadanie_id"));
		
		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
		TypedQuery<Zadanie> query = entityManager
				.createQuery("SELECT z FROM Zadanie z WHERE z.zadanieId = " + idZadanie, Zadanie.class);
		Zadanie zadanie=query.getSingleResult();
		
		entityManager.getTransaction().begin();
		entityManager.remove(zadanie);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		response.sendRedirect("/project-web-app2/ListaProjektow");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
