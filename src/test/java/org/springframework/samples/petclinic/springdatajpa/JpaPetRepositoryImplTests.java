package org.springframework.samples.petclinic.springdatajpa;

import org.junit.runner.RunWith;
import org.springframework.samples.petclinic.AbstractPetRepositoryTests;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Integration tests for the {@link JdbcClinicImpl} implementation.
 * </p>
 * <p>
 * </p>
 *
 * @author Thomas Risberg
 * @author Michael Isvy 
 */
@ContextConfiguration(locations={"classpath:spring/applicationContext-dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext
@ActiveProfiles({"jpa","spring-data-jpa"})
public class JpaPetRepositoryImplTests extends AbstractPetRepositoryTests {
	
	

}
