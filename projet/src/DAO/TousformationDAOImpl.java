package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Beans.Formation;



public class TousformationDAOImpl implements TousformationDAO {

private DAOFactory daoFactory; 
TousformationDAOImpl(DAOFactory daoFactory) { 
        this.daoFactory = daoFactory;
    }
	
	
	


	
	





	@Override
	public List<Formation> consulter1(int idapp) {
		 List<Formation> Formations = new ArrayList<Formation>();
		 
	        Connection connexion = null;
	        Statement statement = null; 
	        ResultSet resultat = null; 
	        try {
	            connexion = daoFactory.getConnection(); 
	        statement = connexion.createStatement(); 
	        resultat = statement.executeQuery("SELECT idformation,nom,nomfr,description FROM formation where idformation not in (select idformation from etudier where idapprenant="+idapp+")"); 
	        while (resultat.next()) { 
	            String nom = resultat.getString("nom");
	            String nomfr = resultat.getString("nomfr");
	            String description = resultat.getString("description");
	            int idformation = resultat.getInt("idformation");
	            Formation Form = new Formation(); 
	            Form.setNom(nom);
	            Form.setDescription(description);
	            Form.setNomfr(nomfr);
	            Form.setIdformation(idformation);
	            Formations.add(Form); }
	        } catch (SQLException e) { 
	            e.printStackTrace(); 
	        } 
	        return Formations;
	}





	@Override
	public List<Formation> consulter2(int idapp) {
		 List<Formation> Formations = new ArrayList<Formation>();
	        Connection connexion = null;
	        Statement statement = null; 
	        ResultSet resultat = null; 
	        try {
	            connexion = daoFactory.getConnection(); 
	        statement = connexion.createStatement(); 
	        resultat = statement.executeQuery("SELECT idformation,nom,nomfr,description FROM formation where idformation in (select idformation from etudier where idapprenant="+idapp+")"); 
	        while (resultat.next()) { 
	            String nom = resultat.getString("nom");
	            String nomfr = resultat.getString("nomfr");
	            String description = resultat.getString("description");
	            int idformation = resultat.getInt("idformation");
	            Formation Form = new Formation(); 
	            Form.setNom(nom);
	            Form.setDescription(description);
	            Form.setNomfr(nomfr);
	            Form.setIdformation(idformation);
	            Formations.add(Form); }
	        } catch (SQLException e) { 
	            e.printStackTrace(); 
	        } 
	        return Formations;
	}
}
