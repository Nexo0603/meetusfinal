package pe.edu.upc.MeetUs.business.crud.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUs.business.crud.MeetingService;
import pe.edu.upc.MeetUs.models.entities.Meeting;
import pe.edu.upc.MeetUs.models.entities.Organizer;
import pe.edu.upc.MeetUs.models.repository.MeetingRepository;
import pe.edu.upc.MeetUs.models.repository.OrganizerRepository;

@Service
public class MeetingServiceImpl implements MeetingService {
	
	@Autowired
	private MeetingRepository meetingRepository;
	
	@Autowired
	private OrganizerRepository organizerRepository;
	
	@Override
	public JpaRepository<Meeting, Integer> getJpaRepository() {
		return this.meetingRepository;
	}
	
	@Override
	public List<Meeting> findByName(String name) throws Exception {
		return this.meetingRepository.findByName(name);
	}
	@Override
    public List<Meeting> findByOrganizer(Integer id) throws Exception {
        if (organizerRepository.existsById(id)) {
            Optional<Organizer> optional = organizerRepository.findById(id);
            return meetingRepository.findByOrganizer(optional.get());
        } else {
            return new ArrayList<Meeting>();
        }
    }

}
