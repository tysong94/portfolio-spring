package kr.co.uclick.repository;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.uclick.configuration.SpringConfiguration;
import kr.co.uclick.entity.Phone;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class PhoneRepositoryTest {

	@Autowired
	PhoneRepository phoneRepository;
	@Autowired
	UserRepository userRepository;
	
//	//CREATE-------------------------------------------
//	@Test
//	public void testSave() {
//		Optional<User> o = userRepository.findById(1L);
//		User u = o.get();
//		
//		Phone p = new Phone();
//		p.setId(1L);
//		p.setUser(u);
//		p.setNumber("010-6219-0764");
//		phoneRepository.save(p);
//	}
	
	// READ--------------------------------------------- 
//	@Test
//	public void testFindAll() {
//		List<Phone> ps = phoneRepository.findAll();
//		assertEquals("??", ps.get(0).getId());
//	}
	
//	@Test
//	public void testFindById() {
//		Optional<Phone> p = phoneRepository.findById(4L);;
//		assertEquals("df", p.get().getNumber());
//	}
	
//	@Test
//	public void testFindByName() {
//		List<Phone> ps = phoneRepository.findByName("송태양");
//		assertEquals("??", us.get(0).getName());
//	}
	
//	// DELETE---------------------------------------------
//	@Test
//	public void testDelete() {
//		Optional<Phone> o = phoneRepository.findById(4L);
//		Phone p = o.get();
//		phoneRepository.delete(p);
//	}
	
}
