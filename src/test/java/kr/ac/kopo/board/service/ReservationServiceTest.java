package kr.ac.kopo.board.service;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.domain.Reservation;
import kr.ac.kopo.board.vo.PaginationVO;
import kr.ac.kopo.board.vo.ReservationVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/applicationContext-test.xml"})
public class ReservationServiceTest {
	
	
	@Autowired
	ReservationService reservationService;
	
//    @Before
//    public void setUp() throws Exception {
//    }
//    
//    @After
//    public void cleanUp(){
//    }
    
//    @Test
//    public void testIsReservationExist() throws Exception {
//    	Reservation r = new Reservation();
//    	r.setId(1);
//    	
//    	boolean isExist = reservationService.isReservationExist(r);
//        assertEquals(true, isExist);
//    }
    
    @Test
    public void testIsSetReservationVOs() throws Exception {
    	List<ReservationVO> rVOs = reservationService.setReservations();
    	
    	rVOs.size();
        assertEquals(1, rVOs.size());
    }
    
}
