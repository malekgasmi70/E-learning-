package BI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAOFactory;
import DAO.FormationDAO;

/**
 * Servlet implementation class Modifier
 */
@WebServlet("/Modif")
public class Modif extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FormationDAO FormationDAO;
	public void init() throws ServletException { 
	    DAOFactory  daofactory= DAOFactory.getInstance(); 
	    this.FormationDAO = daofactory.getFormationDAO(); 
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modif() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomformation = request.getParameter("nomformation"); 
	    String desc = request.getParameter("description");
	    String idform = request.getParameter("custId6");
	    FormationDAO.modifier(idform,nomformation, desc);
	    String idformateur = request.getParameter("custId8"); 
		HttpSession session = request.getSession();
		session.setAttribute("Formations",FormationDAO.consulter(idformateur));	
	    this.getServletContext().getRequestDispatcher("/Formateur.jsp").forward(request, response);

	}

}
