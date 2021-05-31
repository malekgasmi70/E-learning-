package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Cours;
import Beans.Formation;

public class CoursDAOImpl implements CoursDAO{
	
	private DAOFactory daoFactory; 
	CoursDAOImpl(DAOFactory daoFactory) { 
        this.daoFactory = daoFactory;
    }


	@Override
	public void Ajouter(Cours cr, Formation Form) {
		Connection connexion = null; 
	     PreparedStatement preparedStatement = null; 
	        try { 
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO cours(nom, idformation, contenu) VALUES(?, ?, ?)"); 
	            preparedStatement.setString(1,cr.getNom());
	            preparedStatement.setInt(2,Form.getIdformation());
	            preparedStatement.setString(3,cr.getcontenu()); 
	            preparedStatement.executeUpdate(); 
	        } catch (SQLException e) { 
	            e.printStackTrace(); 
	        }		
	}

	@Override
	public List<Cours> consulter(int idformation) {
		 List<Cours> Courss = new ArrayList<Cours>();
	        Connection connexion = null;
	        Statement statement = null; 
	        ResultSet resultat = null; 
	        try {
	            connexion = daoFactory.getConnection(); 
	        statement = connexion.createStatement(); 
	        resultat = statement.executeQuery("SELECT contenu,description FROM cours where idformation="+idformation); 
	        if (resultat.next()) { 
	            String description = resultat.getString("description");  
	            String contenu = resultat.getString("contenu");
	            Cours cr = new Cours(); 
	            cr.setcontenu(contenu);
	            cr.setDescription(description);
	            Courss.add(cr); }
	        } catch (SQLException e) { 
	            e.printStackTrace(); 
	        } 
	        return Courss;
	}

	@Override
	public void modifier(Cours cr, String novnom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(Cours cr) {
		// TODO Auto-generated method stub
		
	}

}
