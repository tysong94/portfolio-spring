package kr.ac.kopo.board.service;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.domain.Reservation;
import kr.ac.kopo.board.domain.Room;
import kr.ac.kopo.board.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:META-INF/applicationContext-test.xml"})
public class MakeTestData {

	@Autowired
	UserService userService;
	@Autowired
	RoomService roomService;
	@Autowired
	ReservationService reservationService;
	
//	@Test
//    public void makeUser() throws Exception {
//    	userService.deleteAll();
//		
//		for (int i=1; i <= 3; i++) {
//			User user = new User();
//			user.setId(id);
//		}
//    }
	
	
//    @Test
//    public void makeroom() throws Exception {
//	    roomService.deleteAll();
//		
//		for (int type = 1; type <= 3; type++) {
//			Room r = new Room();
//			r.setType(type);
//			r.setNo(1);
//			roomService.createOne(r);
//		}
//    }
    
    @Test
    public void makereservation() throws Exception {
    	reservationService.deleteAll();
		
		for (int i=1; i <= 3; i++) {
			
			Reservation reservation = new Reservation();
			
			Calendar cal = Calendar.getInstance();
			User user = userService.selectOne(1);
			Room room = roomService.selectOne(i);
			reservation.setDate(cal.getTime());
			reservation.setUser(user);
			reservation.setRoom(room);
			reservation.setComment("방 예약했드아");
			
			reservationService.createOne(reservation);
		}
    }
}
