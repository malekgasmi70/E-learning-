package BI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import Beans.Apprenant;
import Beans.Formateur;

/**
 * Servlet implementation class Sinscrire
 */
@WebServlet("/Sinscrire")
public class Sinscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SinscrireDAO SinscrireDAO;
	public void init() throws ServletException { 
	    DAOFactory  daofactory= DAOFactory.getInstance(); 
	    this.SinscrireDAO = daofactory.getSinscrireDAO(); 
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sinscrire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type =(String) request.getParameter("type");
		if (type.equals("option1"))
		{HttpSession session=request.getSession();
		Formateur Form = new Formateur();
		Form.setNomfr(request.getParameter("nom")); 
		Form.setPrenom(request.getParameter("prenom")); 
		Form.setDate_naissance(request.getParameter("dns"));
	    Form.setEmail(request.getParameter("email"));
	    Form.setPassword(request.getParameter("pass")); 
	    SinscrireDAO.sinscrire_Form(Form);	
	    session.setAttribute("nom",Form.getNomfr());
	    session.setAttribute("prenom",Form.getPrenom());
	    session.setAttribute("idformateur",Form.getIdformateur());
	    this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		}	
			
		else if (type.equals("option2"))
		{HttpSession session=request.getSession();
		Apprenant App = new Apprenant();
		App.setNom(request.getParameter("nom")); 
	    App.setPrenom(request.getParameter("prenom")); 
	    App.setDate_naissance(request.getParameter("dns"));
	    App.setEmail(request.getParameter("email"));
	    App.setPassword(request.getParameter("pass")); 
	    SinscrireDAO.sinscrire_App(App);
	    session.setAttribute("nom",App.getNom());
	    session.setAttribute("prenom",App.getPrenom());
		session.setAttribute("idapprenant",App.getIdapprenant());
	    this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response); 
		}
		else 
		{
		    this.getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response); 

		}
	}

}
