package kr.co.uclick.repository;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.uclick.configuration.SpringConfiguration;
import kr.co.uclick.entity.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	// CREATE-------------------------------------------
//	@Test
//	public void testSave() {
//		User u = new User();
//		u.setId(3L);
//		u.setName("aaaaaaaaaaa");
//		userRepository.save(u);
//	}
	
	// READ--------------------------------------------- 
//	@Test
//	public void testFindAll() {
//		List<User> us = userService.findAll();
//		
//		assertEquals("??", us.get(0).getName());
//	}
	
//	@Test
//	public void testFindById() {
//		Optional<User> u = userRepository.findById(1L);;
//		assertEquals("df", u.get().getName());
//	}
	
//	@Test
//	public void testFindAll() {
//		List<User> us = userService.findByName("송태양");
//		assertEquals("??", us.get(0).getName());
//	}
	
	// DELETE---------------------------------------------
//	@Test
//	public void testFindAll() {
//		User u = userService.findById(1L);;
//		userService.delete(u);
//	}
	
}
