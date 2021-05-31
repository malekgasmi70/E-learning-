package DAO;

import java.util.List;

import Beans.Formation;

public interface TousformationDAO{
	
	public List<Formation> consulter1(int idapp);
	public List<Formation> consulter2(int idapp);
}