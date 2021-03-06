package org.springframework.samples.petclinic.aspects;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Tests for the DAO variant based on the shared EntityManager approach. Uses
 * TopLink Essentials (the reference implementation) for testing.
 * </p>
 * <p>
 * Specifically tests usage of an <code>orm.xml</code> file, loaded by the
 * persistence provider through the Spring-provided persistence unit root URL.
 * </p>
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 */
@ContextConfiguration(locations={"classpath:spring/applicationContext-dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({"jpa","plain-jpa"})
public class UsageLogAspectTests {

	@Autowired
	private UsageLogAspect usageLogAspect;
	
	@Autowired
	private OwnerRepository ownerRepository;


	@Test
	public void testUsageLogAspectIsInvoked() {
		String lastName1 = "Franklin";
		String lastName2 = "Davis";
		String lastName3 = "foo";

		assertFalse(this.ownerRepository.findByLastName(lastName1).isEmpty());
		assertFalse(this.ownerRepository.findByLastName(lastName2).isEmpty());

		List<String> namesRequested = this.usageLogAspect.getNamesRequested();
		assertTrue(namesRequested.contains(lastName1));
		assertTrue(namesRequested.contains(lastName2));
		assertFalse(namesRequested.contains(lastName3));
	}

}
