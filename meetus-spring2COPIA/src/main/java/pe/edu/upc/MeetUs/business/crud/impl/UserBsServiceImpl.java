package pe.edu.upc.MeetUs.business.crud.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUs.business.crud.UserBsService;
import pe.edu.upc.MeetUs.models.entities.Segment;
import pe.edu.upc.MeetUs.models.entities.User;
import pe.edu.upc.MeetUs.models.repository.UserRepository;



@Service
public class UserBsServiceImpl implements UserBsService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public boolean existsByUsername(String username) throws Exception {
		Optional<User> optional = userRepository.findByUsername(username);
		if (optional.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Optional<User> register(User user) throws Exception {
		// Agregar los Authorities por defecto
		if (user.getSegment().equals(Segment.ORGANIZER)) {
			user.addAuthority("ROLE_ORGANIZER");
		} else if (user.getSegment().equals(Segment.GUEST)) {
			user.addAuthority("ROLE_GUEST");
		}	else if (user.getSegment().equals(Segment.LOCALOWNER))	{
			user.addAuthority("ROLE_LOCALOWNER");
		}
		user.addAuthority("ACCESS_VIEW_MATRI");
	
		
		// Cifrar el password
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		user.setPassword(bcpe.encode(user.getPassword()));
		
		// Grabar el usuario			
		return Optional.of(userRepository.save(user)); 
	}

}
