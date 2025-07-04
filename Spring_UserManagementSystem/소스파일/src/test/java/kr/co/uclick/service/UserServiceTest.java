package kr.co.uclick.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import kr.co.uclick.configuration.SpringConfiguration;
import kr.co.uclick.entity.User;
import kr.co.uclick.repository.UserRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class UserServiceTest {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	// CREATE-------------------------------------------
//	@Test
//	public void testSave() {
//		User u = new User();
//		u.setId(1L);
//		u.setName("송태양");
////		u.setPhoneList(phoneList);
//		userService.save(u);
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
//		User u = userService.findById(1L);;
//		
//		assertEquals("df", u.getName());
//	}
	
//	@Test
//	public void testFindAll() {
//		List<User> us = userService.findByName("송태양");
//		assertEquals("??", us.get(0).getName());
//	}
	
//	//DELETE---------------------------------------------
//	@Test
//	public void testDelete() {
//		User u = userService.findById(2L);;
//		userService.delete(u);
//	}
	
/*	//Cache---------------------------------------------
	@Test
	public void testSelectOne() {
		
		//--------------------------------
		
		StopWatch sw = new StopWatch();
		sw.start();
		User u1 = userService.selectOne(1L);
		sw.stop();
		System.out.println("total time : " + sw.getTotalTimeSeconds());
		System.out.println("name : " + u1.getName());
		
		sw = new StopWatch();
		sw.start();
		User u2 = userService.selectOne(1L);
		sw.stop();
		System.out.println("total time : " + sw.getTotalTimeSeconds());
		System.out.println("name : " + u2.getName());
		
		sw = new StopWatch();
		sw.start();
		User u3 = userService.selectOne(1L);
		sw.stop();
		System.out.println("total time : " + sw.getTotalTimeSeconds());
		System.out.println("name : " + u3.getName());
		
		//--------------------------------
		u3.setName("송태양124");
		userService.updateOne(u3);
		
		sw = new StopWatch();
		sw.start();
		User u4 = userService.selectOne(1L);
		sw.stop();
		System.out.println("total time : " + sw.getTotalTimeSeconds());
		System.out.println("name : " + u4.getName());
		
		sw = new StopWatch();
		sw.start();
		User u5 = userService.selectOne(1L);
		sw.stop();
		System.out.println("total time : " + sw.getTotalTimeSeconds());
		System.out.println("name : " + u5.getName());
		
		sw = new StopWatch();
		sw.start();
		User u6 = userService.selectOne(1L);
		sw.stop();
		System.out.println("total time : " + sw.getTotalTimeSeconds());
		System.out.println("name : " + u6.getName());
		
		assertEquals(1, u1.getId().intValue());
	}*/
	
	//DELETE---------------------------------------------
	
//	@Test
//	public void testfindByNameLike() {
//		List<User> users = userService.findByNameLike("태양");
//		assertEquals(1, users.get(0).getName());
//	}
	
	//Cache---------------------------------------------
	@Test
	public void testfindByNameContaining() {
		
		//--------------------------------
		
		StopWatch sw = new StopWatch();
		sw.start();
		List<User> users = userService.findByNameContaining("태");
		sw.stop();
		System.out.println("total time : " + sw.getTotalTimeSeconds());
		System.out.println("size : " + users.size());
		
		sw = new StopWatch();
		sw.start();
		List<User> users2 = userService.findByNameContaining("태");
		sw.stop();
		System.out.println("total time : " + sw.getTotalTimeSeconds());
		System.out.println("size : " + users2.size());
		
		sw = new StopWatch();
		sw.start();
		List<User> users3 = userService.findByNameContaining("태");
		sw.stop();
		System.out.println("total time : " + sw.getTotalTimeSeconds());
		System.out.println("size : " + users3.size());
		
		//--------------------------------
//		User user = userService.findById(161L);
//		user.setName("김태희");
//		userService.save(user);
		
		sw = new StopWatch();
		sw.start();
		List<User> users4 = userService.findByNameContaining("태양");
		sw.stop();
		System.out.println("total time : " + sw.getTotalTimeSeconds());
		System.out.println("size : " + users4.size());
		
		sw = new StopWatch();
		sw.start();
		List<User> users5 = userService.findByNameContaining("태양");
		sw.stop();
		System.out.println("total time : " + sw.getTotalTimeSeconds());
		System.out.println("size : " + users5.size());
		
		sw = new StopWatch();
		sw.start();
		List<User> users6 = userService.findByNameContaining("태양");
		sw.stop();
		System.out.println("total time : " + sw.getTotalTimeSeconds());
		System.out.println("size : " + users6.size());
		
//		assertEquals(1, u1.getId().intValue());
	}
	
}
