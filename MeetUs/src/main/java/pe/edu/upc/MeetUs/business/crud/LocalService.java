package pe.edu.upc.MeetUs.business.crud;

import java.util.List;

import pe.edu.upc.MeetUs.models.entities.Local;

public interface LocalService extends CrudService<Local, Integer>{
	
	List<Local> findByName(String name) throws Exception;
	
}
