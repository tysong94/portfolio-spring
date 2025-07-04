package kr.ac.kopo.board.dao;

import java.util.Date;
import java.util.List;

import kr.ac.kopo.board.domain.Reservation;

public interface ReservationDao {
	
	Long count(); 
	Reservation selectOne(long id); /*공지 하나*/
	Reservation selectOneByDateRoom(Date date, int room_id);
	List<Reservation> selectAll();	/*공지 여러개*/
	List<Reservation> selectAllByPagination(int page, int itemSizePerPage);	/*페이지네이션...*/
	
	int createOne(Reservation gongji);		/*게시글 하나*/
	void updateOne(Reservation gongji);	/*게시글 업데이트*/
	void deleteOne(Reservation gongji);	/*게시글 삭제*/
	int deleteAll();				
	
	// ELSE
//	int getRecnt(int rootid, int parentRelevel, int parentRecnt);
//	void updateRecnt(int rootid, int recnt);
//	void delete(int rootid, int recnt, int nextRecnt);
}
