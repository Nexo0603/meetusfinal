package pe.edu.upc.MeetUs.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUs.business.crud.LocalService;
import pe.edu.upc.MeetUs.models.entities.Local;
import pe.edu.upc.MeetUs.models.entities.LocalOwner;
import pe.edu.upc.MeetUs.models.repository.LocalOwnerRepository;
import pe.edu.upc.MeetUs.models.repository.LocalRepository;

@Service
public class LocalServiceImpl implements LocalService {
	
	@Autowired
	private LocalRepository localRepository;
	
	@Autowired
	private LocalOwnerRepository localownerRepository;
	
	@Override
	public JpaRepository<Local, Integer> getJpaRepository() {
		return this.localRepository;
	}
	
	@Override
	public List<Local> findByName(String name) throws Exception {
		return this.localRepository.findByName(name);
	}
	
	@Override
    public List<Local> findByLocalowner(Integer id) throws Exception {
        if (localownerRepository.existsById(id)) {
            Optional<LocalOwner> optional = localownerRepository.findById(id);
            return localRepository.findByLocalowner(optional.get());
        } else {
            return new ArrayList<Local>();
        }
    }
	
}
