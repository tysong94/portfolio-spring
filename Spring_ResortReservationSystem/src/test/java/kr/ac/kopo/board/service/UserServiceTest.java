package kr.ac.kopo.board.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/applicationContext-test.xml"})
public class UserServiceTest {

	@Autowired
	UserService userService;
	
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void cleanUp(){
    }
    
//    @Test
//    public void testIsUserExist() throws Exception {
//    	User u = new User();
//    	u.setId(1);
//    	
//    	boolean isExist = userService.isUserExist(u);
//        assertEquals(true, isExist);
//    }
    
}
