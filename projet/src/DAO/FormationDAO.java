package DAO;

import java.util.List;

import Beans.Formation;

public interface FormationDAO {

	
	public List<Formation> consulter(String id);
	public void supprimer(int idformation);
	public void cr�er(String nomformation, String idformateur, String nomformateur, String desc);
	public void modifier(String idformation, String nomformation, String desc);
	
}
