package BI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;


/**
 * Servlet implementation class Cours
 */
@WebServlet("/Lecours")
public class Lecours extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CoursDAO CoursDAO;
	public void init() throws ServletException { 
	    DAOFactory  daofactory= DAOFactory.getInstance(); 
	    this.CoursDAO = daofactory.getCoursDAO(); 
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lecours() {
    
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomfr = request.getParameter("custId4"); 
		String nomformati = request.getParameter("custId8"); 
		String idformati = request.getParameter("custId12"); 
		int idformation = Integer.parseInt(idformati);
		HttpSession session = request.getSession();
	    session.setAttribute("Cours", CoursDAO.consulter(idformation));
	    session.setAttribute("nomformation", nomformati);
	    session.setAttribute("nomformateur", nomfr); 
	    this.getServletContext().getRequestDispatcher("/cours.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

}
