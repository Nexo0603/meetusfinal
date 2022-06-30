package pe.edu.upc.MeetUs.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.MeetUs.models.entities.Segment;
import pe.edu.upc.MeetUs.models.entities.User;
import pe.edu.upc.MeetUs.models.repository.UserRepository;

@Service
public class InitUser implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {    //Se ejecuta de inmediato
        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
                // ROLE_XXXXX    -> Segmento Objetivo
                // ACCESS_YYYYY

                // SIEMPRE DEBE DE ESTAR COMENTADO
                // SOLO SE DEBE DESBLOQUEAR CUANDO SE CREAN USUARIOS
                //AQUI SE CONECTA CON EL SECURITYCONFIG

        /*User andrea = new User();
        andrea.setUsername("andrea");
        andrea.setPassword(bcpe.encode("andrea"));
        andrea.setSegment(Segment.ORGANIZER);
        andrea.setIdSegment(1);
        andrea.addAuthority("ROLE_ORGANIZER");
        andrea.addAuthority("ACCESS_VIEW_MEETING");
        andrea.addAuthority("ACCESS_EDIT_MEETING");
        andrea.addAuthority("ACCESS_LIST_MEETINGS");
        andrea.addAuthority("ACCESS_NEW_MEETING");
        andrea.addAuthority("ACCESS_LIST_PAYMENTS");
        andrea.addAuthority("ACCESS_NEW_PAYMENT");
        andrea.addAuthority("ACCESS_VIEW_PAYMENT");
        andrea.addAuthority("ACCESS_VIEW_APPRECIATION");
        andrea.addAuthority("ACCESS_LIST_APPRECIATION");
        andrea.addAuthority("ACCESS_LIST_SUGGESTIONS");
        andrea.addAuthority("ACCESS_VIEW_SUGGESTION");
        userRepository.save(andrea);

        User martin = new User("martin", bcpe.encode("martin"), Segment.LOCALOWNER, 1);
        martin.addAuthority("ROLE_LOCALOWNER");
        martin.addAuthority("ACCESS_VIEW_LOCALS");
        martin.addAuthority("ACCESS_NEW_LOCAL");
        martin.addAuthority("ACCESS_LIST_LOCALS");
        martin.addAuthority("ACCESS_EDIT_LOCAL");
        martin.addAuthority("ACCESS_VIEW_PAYMENT");
        martin.addAuthority("ACCESS_LIST_PAYMENTS");
        userRepository.save(martin); 
        
        User angel = new User("angel", bcpe.encode("angel"), Segment.GUEST, 1);
        angel.addAuthority("ROLE_GUEST");
        angel.addAuthority("ACCESS_VIEW_APPRECIATION");
        angel.addAuthority("ACCESS_NEW_APPRECIATION");
        angel.addAuthority("ACCESS_LIST_APPRECIATION");
        angel.addAuthority("ACCESS_EDIT_APPRECIATION");
        angel.addAuthority("ACCESS_EDIT_SUGGESTION");
        angel.addAuthority("ACCESS_LIST_SUGGESTIONS");
        angel.addAuthority("ACCESS_NEW_SUGGESTION");
        angel.addAuthority("ACCESS_VIEW_SUGGESTION");
        angel.addAuthority("ACCESS_LIST_MEETINGS");
        angel.addAuthority("ACCESS_VIEW_MEETING");
        userRepository.save(angel); 
        
        User admin = new User("admin", bcpe.encode("admin"), Segment.ORGANIZER, 2);
        admin.addAuthority("ROLE_ADMINISTRATOR");
        admin.addAuthority("ACCESS_ALL");
        userRepository.save(admin); */

    }

}