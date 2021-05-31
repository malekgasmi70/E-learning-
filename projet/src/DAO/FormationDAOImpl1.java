package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Formation;



public class FormationDAOImpl1 implements FormationDAO {

private DAOFactory daoFactory; 
	FormationDAOImpl1(DAOFactory daoFactory) { 
        this.daoFactory = daoFactory;
    }
	
	
	
	

	@Override
	public void supprimer(int idformation) {
		Connection connexion = null; 
        PreparedStatement preparedStatement = null; 
        try { 
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM formation where idformation=?"); 
            preparedStatement.setInt(1,idformation);
            preparedStatement.executeUpdate(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }		
	}


	
	@Override
	public void créer(String nomformation, String id, String nomformateur, String desc) {
		Connection connexion = null; 
	     PreparedStatement preparedStatement = null; 
	        try { 
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO formation(nom,idformateur,nomfr,description) VALUES(?, ?, ?, ?)"); 
	            preparedStatement.setString(1,nomformation); 
	            int idformateur = Integer.parseInt(id);
	            preparedStatement.setInt(2,idformateur);
	            preparedStatement.setString(3,nomformateur);
	            preparedStatement.setString(4,desc);
	            preparedStatement.executeUpdate(); 
	        } catch (SQLException e) { 
	            e.printStackTrace();
	        
	}
		
	}


	




	@Override
	
		public List<Formation> consulter(String id) {
			List<Formation> Formations = new ArrayList<Formation>();
	        Connection connexion = null;
	        Statement statement = null; 
	        ResultSet resultat = null; 
	        int idformateur = Integer.parseInt(id);
	        try {
	            connexion = daoFactory.getConnection(); 
	        statement = connexion.createStatement(); 
	        resultat = statement.executeQuery("SELECT idformation,nom,description FROM formation where idformateur="+idformateur); 
	        while (resultat.next()) { 
	            int idformation = resultat.getInt("idformation");
	            String nom = resultat.getString("nom");
	            String description = resultat.getString("description");
	            Formation Form = new Formation(); 
	            Form.setNom(nom);
	            Form.setDescription(description);
	            Form.setIdformation(idformation);
	            Formations.add(Form); }
	        } catch (SQLException e) { 
	            e.printStackTrace(); 
	        } 
	        return Formations;
	}





	@Override
	public void modifier(String idformation, String nomformation, String desc) {
		 Connection connexion = null; 
	        PreparedStatement preparedStatement = null;
			int idform=Integer.parseInt(idformation);		

	        try { 
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("UPDATE formation set nom=?, description=? where idformation=?"); 
	            preparedStatement.setString(1,nomformation);
	            preparedStatement.setString(2,desc);
	            preparedStatement.setInt(3,idform);
	            preparedStatement.executeUpdate(); 
	        } catch (SQLException e) { 
	            e.printStackTrace(); 
	        }	
		
	}








	
	


	}
