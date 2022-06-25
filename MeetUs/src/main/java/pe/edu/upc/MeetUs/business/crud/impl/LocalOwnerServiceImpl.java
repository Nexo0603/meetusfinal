package pe.edu.upc.MeetUs.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUs.business.crud.LocalOwnerService;
import pe.edu.upc.MeetUs.models.entities.LocalOwner;
import pe.edu.upc.MeetUs.models.repository.LocalOwnerRepository;

@Service
public class LocalOwnerServiceImpl implements LocalOwnerService {
	
	@Autowired
	private LocalOwnerRepository localownerRepository;
	
	@Override
	public JpaRepository<LocalOwner, Integer> getJpaRepository() {
		return this.localownerRepository;
	}

	@Override
	public List<LocalOwner> findByName(String name) throws Exception {
		return this.localownerRepository.findByName(name);
	}
}
