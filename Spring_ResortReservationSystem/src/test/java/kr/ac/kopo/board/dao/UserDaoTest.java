package kr.ac.kopo.board.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/applicationContext-test.xml"})
public class UserDaoTest {

	@Autowired
	UserDao userDao;
	
//    @Before
//    public void setUp() throws Exception {
//    	String u1 = "user1";
//    	User user1 = new User();
//    	user1.setPassword("pw");
//    	user1.setUsername(u1);
//    	user1.setName(u1);
//    	user1.setEmail(u1);
//    	user1.setCreated(new Date());
//    	
//    	String u2 = "user2";
//    	User user2 = new User();
//    	user2.setPassword("pw");
//    	user2.setUsername(u2);
//    	user2.setName(u2);
//    	user2.setEmail(u2);
//    	user2.setCreated(new Date());
//    	
//    	String u3 = "user3";
//    	User user3 = new User();
//    	user3.setPassword("pw");
//    	user3.setUsername(u3);
//    	user3.setName(u3);
//    	user3.setEmail(u3);
//    	user3.setCreated(new Date());
//    	
//    	userDao.createOne(user1);
//    	userDao.createOne(user2);
//    	userDao.createOne(user3);
//    }
    
//    @After
//    public void cleanUp(){
//    	userDao.deleteAll();
//    }
    
//    @Test
//    public void testCount() throws Exception {
//    	Long count = userDao.count();
//        assertEquals(3, count.intValue());
//    }
    
//    @Test
//    public void testSelectOne() throws Exception {
//    	User u = userDao.selectOne(1);
//        assertEquals(1, u.getId());
//    }
    
    @Test
    public void testSelectOne() throws Exception {
    	User user = userDao.selectOne("tysong94");
        assertEquals(1, user.getName());
    }
    
//    @Test
//    public void testSelectAll() throws Exception {
//    	List<User> u = userDao.selectAll();
//        assertEquals(3, u.size());
//    }
    
//    @Test
//    public void testSelectAllByPagination() throws Exception {
//    	List<User> users = userDao.selectAllByPagination(1, 2);
//    	
//    	for (User u: users) {
//    		System.out.println(u.getUsername());
//    	}
//    	
//        assertEquals(2, users.size());
//    }
    
//    @Test
//    public void testCreateOne() throws Exception {
//    	String name = "user4";
//    	User u = new User();
//    	u.setPassword("pw");
//    	u.setUsername(name);
//    	u.setName(name);
//    	u.setEmail(name);
//    	u.setCreated(new Date());
//    	
//    	int id = userDao.createOne(u);
//    	assertEquals(167, id);
//    }
    
//    @Test
//    public void testUpdateOne() throws Exception {
//    	String pw = "pw3";
//    	User u = userDao.selectOne(1);
//    	u.setPassword(pw);
//    	userDao.updateOne(u);
//    	
//    	assertEquals(pw, u.getPassword());
//    }
    
//    @Test
//    public void testDeleteOne() throws Exception {
//    	User u = userDao.selectOne(167);
//    	userDao.deleteOne(u);
//    	
//    	assertEquals(1, 1);
//    }
    
//    @Test
//    public void testDeleteAll() throws Exception {
//    	int count = userDao.deleteAll();
//    	assertEquals(1, count);
//    }
	
//  @Test
//  public void test() throws Exception {
//  	int count = userDao.deleteAll();
//  	assertEquals(1, count);
//  }
    
}
