package DAO;
import java.util.List;

import Beans.Apprenant;

public interface ApprenantDAO {
	
public List<Apprenant> consulter();
public void modifier(Apprenant App,String novnom);
public void supprimer(Apprenant App);
}
