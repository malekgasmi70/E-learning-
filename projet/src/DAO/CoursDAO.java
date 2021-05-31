package DAO;

import java.util.List;

import Beans.Cours;
import Beans.Formation;

public interface CoursDAO {

	public void Ajouter(Cours cr,Formation Form);
	public List<Cours> consulter(int idformation);
	public void modifier(Cours cr,String novnom);
	public void supprimer(Cours cr);
	
}
