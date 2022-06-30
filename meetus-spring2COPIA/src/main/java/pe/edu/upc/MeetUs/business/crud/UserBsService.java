package pe.edu.upc.MeetUs.business.crud;

import java.util.Optional;

import pe.edu.upc.MeetUs.models.entities.User;

public interface UserBsService {

	boolean existsByUsername(String username) throws Exception;
	Optional<User> register(User User) throws Exception;
}
