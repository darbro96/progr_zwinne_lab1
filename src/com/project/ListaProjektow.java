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
import com.project.util.HibernateUtil;

/**
 * Servlet implementation class ListaProjektow
 */
@WebServlet("/ListaProjektow")
public class ListaProjektow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html;charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaProjektow() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
		boolean next = false;
		int page = 0;
		Integer offset = 0;
		Integer pageSize = 10;
		do {
			TypedQuery<Projekt> query = entityManager
					.createQuery("SELECT p FROM Projekt p ORDER BY p.dataczasUtworzenia", Projekt.class);
			query.setFirstResult(offset);
			query.setMaxResults(pageSize);
			List<Projekt> projekty = query.getResultList();
			if (projekty != null && !projekty.isEmpty()) {
				page += 1;
				System.out.println("Strona " + page);
				for (Projekt projekt : projekty) {
					System.out.println(" - projekt ID: " + projekt.getProjektId() + ", nazwa: " + projekt.getNazwa());
				}
				next = true;
				offset = offset + pageSize;
				request.setAttribute("projekty", projekty);
			} else {
				next = false;
			}
		} while (next);
		entityManager.close();

		ServletContext context = getServletContext();
		entityManager.close();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/lista_projektow.jsp");
		dispatcher.forward(request, response);
	}

}
