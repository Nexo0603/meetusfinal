package pe.edu.upc.MeetUs.business.crud;

import java.util.List;

import pe.edu.upc.MeetUs.models.entities.LocalOwner;

public interface LocalOwnerService extends CrudService<LocalOwner, Integer> {
	List<LocalOwner> findByName(String name) throws Exception;
}
