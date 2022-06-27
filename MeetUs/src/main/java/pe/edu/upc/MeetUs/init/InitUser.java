package pe.edu.upc.MeetUs.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUs.models.entities.User;
import pe.edu.upc.MeetUs.models.repository.UserRepository;

@Service
public class InitUser implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {	//Se ejecuta de inmediato
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
				// ROLE_XXXXX	-> Segmento Objetivo
				// ACCESS_YYYYY
				
				// SIEMPRE DEBE DE ESTAR COMENTADO
				// SOLO SE DEBE DESBLOQUEAR CUANDO SE CREAN USUARIOS
				//AQUI SE CONECTA CON EL SECURITYCONFIG
		
		/*User carlos = new User();
		carlos.setUsername("carlos");
		carlos.setPassword(bcpe.encode("carlos"));
		
		carlos.addAuthority("ROLE_ORGANIZER");
		carlos.addAuthority("ACCESS_VIEW_MEETING");
		carlos.addAuthority("ACCESS_EDIT_MEETING");
		userRepository.save(carlos);
		
		User maria = new User("maria", bcpe.encode("maria"));
		maria.addAuthority("ROLE_ORGANIZER");
		maria.addAuthority("ACCESS_VIEW_MEETING");
		userRepository.save(maria);*/
		

		/*User organizador = new User("organizador", bcpe.encode("organizador"));
		organizador.addAuthority("ROLE_ORGANIZER");
		organizador.addAuthority("ACCESS_VIEW_MEETING");
		userRepository.save(organizador);*/
		
		
		
		
	/*	User admin = new User("admin", bcpe.encode("admin"));
		admin.addAuthority("ROLE_ADMINISTRATOR");
		admin.addAuthority("ACCESS_ALL");
		userRepository.save(admin);
		*/
		
		
	}

}
