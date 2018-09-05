package kr.ac.kopo.board.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.domain.Room;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/applicationContext-test.xml"})
public class RoomDaoTest {

	@Autowired
	RoomDao roomDao;
	
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
//    
//    @After
//    public void cleanUp(){
//    	userDao.deleteAll();
//    }
    
//    @Test
//    public void testCount() throws Exception {
//    	Long count = gongjiDao.count();
//        assertEquals(1, count.intValue());
//    }
//    
	@Test
	public void testSelectOne() throws Exception {
       Room r = roomDao.selectOne(1);
       assertEquals(1, r.getId());
	}
//    
//    @Test
//    public void testSelectAll() throws Exception {
//    	List<Gongji> g = gongjiDao.selectAll();
//        assertEquals(1, g.size());
//    }
    
//    @Test
//    public void testSelectAllByPagination() throws Exception {
//    	List<Gongji> gongjis = gongjiDao.selectAllByPagination(2, 3);
//    	
//    	for (Gongji g: gongjis) {
//    		System.out.println(g.getTitle());
//    	}
//    	
//        assertEquals(3, gongjis.size());
//    }
    
//    @Test
//    public void testCreateOne() throws Exception {
//    	Gongji g = new Gongji();
//    	Date today = new Date();
//    	g.setDate(today);
//    	g.setTitle("새글");
//    	g.setContent("새글이닷");
//    	g.setViewcnt(0);
//    	g.setRootid(12);
//    	g.setRecnt(0);
//    	g.setRelevel(0);
//    	
//    	int id = gongjiDao.createOne(g);
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
	
	
//	  @Test
//	  public void testGetRecnt() throws Exception {
//		int recnt = gongjiDao.getRecnt(1, 1, 1);
//	  	assertEquals(12, recnt);
//	  }
	
//	  @Test
//	  public void testUpdateRecnt() throws Exception {
//		int recnt = gongjiDao.updateRecnt(16, recnt)
//	  	assertEquals(12, recnt);
//	  }
	
	

}
