# meetusfinal


Error creating bean with name 'guestServiceImpl': Unsatisfied dependency expressed through field 'guestRepository'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'guestRepository' defined in pe.edu.upc.MeetUsSpring.model.repository.GuestRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Invocation of init method failed; nested exception is org.springframework.data.repository.query.QueryCreationException: Could not create query for public abstract java.util.List pe.edu.upc.MeetUsSpring.model.repository.GuestRepository.findByLastNameAndFirstName(java.lang.String,java.lang.String) throws java.lang.Exception! Reason: Failed to create query for method public abstract java.util.List pe.edu.upc.MeetUsSpring.model.repository.GuestRepository.findByLastNameAndFirstName(java.lang.String,java.lang.String) throws java.lang.Exception! No property 'lastName' found for type 'Guest'! Did you mean ''lastname''?; nested exception is java.lang.IllegalArgumentException: Failed to create query for method public abstract java.util.List pe.edu.upc.MeetUsSpring.model.repository.GuestRepository.findByLastNameAndFirstName(java.lang.String,java.lang.String) throws java.lang.Exception! No property 'lastName' found for type 'Guest'! Did you mean ''lastname''?


Se soluciona usando:

@ComponentScan({"main.controllers", "main.repositories"})
@EnableJpaRepositories("main.repositories")
@SpringBootApplication
