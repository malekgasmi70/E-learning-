package BI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Formation;
import DAO.DAOFactory;
import DAO.FormationDAO;

/**
 * Servlet implementation class Supprimer
 */
@WebServlet("/Supprimer")
public class Supprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FormationDAO FormationDAO;
	public void init() throws ServletException { 
	    DAOFactory  daofactory= DAOFactory.getInstance(); 
	    this.FormationDAO = daofactory.getFormationDAO(); 
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supprimer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String idform1 = request.getParameter("custId1"); 	
	    int idformation=Integer.parseInt(idform1); 
	    String idform2 = request.getParameter("custId2"); 	
	    int idformateur=Integer.parseInt(idform2);  
		FormationDAO.supprimer( idformation);
		String idfor = String.valueOf(idformateur); 
		HttpSession session = request.getSession();
		session.setAttribute("Formations",FormationDAO.consulter(idfor));	
	    this.getServletContext().getRequestDispatcher("/Formateur.jsp").forward(request, response);
	}

}
