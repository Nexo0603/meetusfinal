package pe.edu.upc.MeetUs.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUs.business.crud.LocalService;
import pe.edu.upc.MeetUs.models.entities.Local;
import pe.edu.upc.MeetUs.models.repository.LocalRepository;

@Service
public class LocalServiceImpl implements LocalService {
	
	@Autowired
	private LocalRepository localRepository;
	
	@Override
	public JpaRepository<Local, Integer> getJpaRepository() {
		return this.localRepository;
	}
	
	@Override
	public List<Local> findByName(String name) throws Exception {
		return this.localRepository.findByName(name);
	}

}
