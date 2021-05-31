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
 * Servlet implementation class Ajoutform
 */
@WebServlet("/Ajoutform")
public class Ajoutform extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FormationDAO FormationDAO;
	public void init() throws ServletException { 
	    DAOFactory  daofactory= DAOFactory.getInstance(); 
	    this.FormationDAO = daofactory.getFormationDAO(); 
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajoutform() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomformation = request.getParameter("nomformation"); 
		String nomformateur = request.getParameter("formateur"); 
	    String desc = request.getParameter("description"); 
        String idformateur= request.getParameter("custId");
			
		
	 
	    
		FormationDAO.créer(nomformation,idformateur,nomformateur,desc);
        HttpSession session = request.getSession();
        session.setAttribute("Formations", FormationDAO.consulter(idformateur));
	    this.getServletContext().getRequestDispatcher("/Formateur.jsp").forward(request, response);
	}
	

}
