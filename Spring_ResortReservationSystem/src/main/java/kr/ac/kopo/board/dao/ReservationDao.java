package kr.ac.kopo.board.dao;

import java.util.Date;
import java.util.List;

import kr.ac.kopo.board.domain.Reservation;

public interface ReservationDao {
	
	Long count(); 
	Reservation selectOne(long id); /*���� �ϳ�*/
	Reservation selectOneByDateRoom(Date date, int room_id);
	List<Reservation> selectAll();	/*���� ������*/
	List<Reservation> selectAllByPagination(int page, int itemSizePerPage);	/*���������̼�...*/
	
	int createOne(Reservation gongji);		/*�Խñ� �ϳ�*/
	void updateOne(Reservation gongji);	/*�Խñ� ������Ʈ*/
	void deleteOne(Reservation gongji);	/*�Խñ� ����*/
	int deleteAll();				
	
	// ELSE
//	int getRecnt(int rootid, int parentRelevel, int parentRecnt);
//	void updateRecnt(int rootid, int recnt);
//	void delete(int rootid, int recnt, int nextRecnt);
}
