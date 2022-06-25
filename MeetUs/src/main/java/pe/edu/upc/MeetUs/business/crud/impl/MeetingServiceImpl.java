package pe.edu.upc.MeetUs.business.crud.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUs.business.crud.MeetingService;
import pe.edu.upc.MeetUs.models.entities.Meeting;
import pe.edu.upc.MeetUs.models.repository.MeetingRepository;

@Service
public class MeetingServiceImpl implements MeetingService {
	
	@Autowired
	private MeetingRepository meetingRepository;
	
	@Override
	public JpaRepository<Meeting, Integer> getJpaRepository() {
		return this.meetingRepository;
	}
	
	@Override
	public List<Meeting> findByName(String name) throws Exception {
		return this.meetingRepository.findByName(name);
	}

}
