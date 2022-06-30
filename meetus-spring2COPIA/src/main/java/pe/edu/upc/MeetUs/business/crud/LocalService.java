package pe.edu.upc.MeetUs.business.crud;

import java.util.List;

import pe.edu.upc.MeetUs.models.entities.Local;
import pe.edu.upc.MeetUs.models.entities.LocalOwner;

public interface LocalService extends CrudService<Local, Integer>{
	
	List<Local> findByName(String name) throws Exception;
	
	List<Local> findByLocalowner(Integer id) throws Exception;
	
}
