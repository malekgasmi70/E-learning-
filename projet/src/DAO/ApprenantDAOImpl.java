package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Beans.Apprenant;

public class ApprenantDAOImpl implements ApprenantDAO {
	private DAOFactory daoFactory; 
	ApprenantDAOImpl(DAOFactory daoFactory) { 
        this.daoFactory = daoFactory;
    }


	
	public List<Apprenant> consulter() {
		 List<Apprenant> Apprenants = new ArrayList<Apprenant>();
	        Connection connexion = null;
	        Statement statement = null; 
	        ResultSet resultat = null; 
	        try {
	            connexion = daoFactory.getConnection(); 
	        statement = connexion.createStatement(); 
	        resultat = statement.executeQuery("SELECT nom, prenom, email FROM Apprenant"); 
	        while (resultat.next()) { 
	            String nom = resultat.getString("nom"); 
	            String prenom = resultat.getString("prenom"); 
	            String email = resultat.getString("email"); 
	            Apprenant App = new Apprenant(); 
	            App.setNom(nom);
	            App.setPrenom(prenom);
	            App.setEmail(email);
	            Apprenants.add(App); }
	        } catch (SQLException e) { 
	            e.printStackTrace(); 
	        } 
	        return Apprenants;
	}

	
	public void modifier(Apprenant App,String novnom) {
		 Connection connexion = null; 
	        PreparedStatement preparedStatement = null; 
	        try { 
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("UPDATE Apprenant set nom="+novnom+" where nom=? and prenom=?"); 
	            preparedStatement.setString(1,App.getNom());
	            preparedStatement.setString(2,App.getPrenom()); 
	            preparedStatement.executeUpdate(); 
	        } catch (SQLException e) { 
	            e.printStackTrace(); 
	        }
	}

	
	public void supprimer(Apprenant App) {
		
		Connection connexion = null; 
        PreparedStatement preparedStatement = null; 
        try { 
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM Apprenant where nom=? and prenom=?"); 
            preparedStatement.setString(1,App.getNom());
            preparedStatement.setString(2,App.getPrenom()); 
            preparedStatement.executeUpdate(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
		
	}

}
