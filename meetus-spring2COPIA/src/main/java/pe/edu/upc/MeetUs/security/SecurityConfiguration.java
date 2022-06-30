package pe.edu.upc.MeetUs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Bean
	PasswordEncoder passwordEnconder() {
		return new BCryptPasswordEncoder();
	}
	
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEnconder());		
		
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		// Aqui realiza la configuración de los permisos
		.antMatchers("/").permitAll()
		.antMatchers("/meetings-bs/**").access("hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_ORGANIZER') or hasRole('ROLE_GUEST')")
		.antMatchers("/payments-bs/**").access("hasRole('ROLE_ORGANIZER') or hasRole('ROLE_LOCALOWNER') or hasRole('ROLE_ADMINISTRATOR')")
		.antMatchers("/appreciations-bs/**").access("hasRole('ROLE_ORGANIZER') or hasRole('ROLE_GUEST') or hasRole('ROLE_ADMINISTRATOR')")
		.antMatchers("/suggestions-bs/**").access("hasRole('ROLE_ORGANIZER') or hasRole('ROLE_GUEST') or hasRole('ROLE_ADMINISTRATOR')")
		.antMatchers("/locals-bs/**").access("hasRole('ROLE_LOCALOWNER') or hasRole('ROLE_ADMINISTRATOR')")
		.antMatchers("/guests-bs/**").access("hasRole('ROLE_ADMINISTRATOR')")
		.antMatchers("/localowners-bs/**").access("hasRole('ROLE_ADMINISTRATOR')")
		.antMatchers("/organizers-bs/**").access("hasRole('ROLE_ADMINISTRATOR')")
				//.antMatchers("/students-bs/**/		edit").hasAnyAuthority("ACCESS_EDIT_MATRI", "ACCESS_ALL")
				//.antMatchers("/enrollments/**").hasRole("STUDENT")
				
			.and()
				.formLogin();
	}
	
	
}