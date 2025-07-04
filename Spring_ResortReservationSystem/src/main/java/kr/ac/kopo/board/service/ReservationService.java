package kr.ac.kopo.board.service;

import java.util.Date;
import java.util.List;

import kr.ac.kopo.board.domain.Reservation;
import kr.ac.kopo.board.vo.PaginationVO;
import kr.ac.kopo.board.vo.ReservationVO;

public interface ReservationService {
	
	//-------------------simple--------------------------------------------------------
	Long count();
	Reservation selectOne(long id);
	Reservation selectOneByDateRoom(Date date, int room_id);
	List<Reservation> selectAll();
	List<Reservation> selectAllByPagination(int page, int itemSizePerPage);
	
	int createOne(Reservation reservation);
	void updateOne(Reservation reservation);
	void deleteOne(Reservation reservation);
	int deleteAll();
	
	//-------------------complex--------------------------------------------------------
	List<ReservationVO> setReservationVOs();
	List<String> dates();
}
//	int getRecnt(int rootid, int parentRelevel, int parentRecnt);
//	void updateRecnt(int rootid, int recnt);
//	void delete(int rootid, int recnt, int nextRecnt);

//	boolean isReservationExist(Reservation reservation);
//	void deleteOne(long id);
//	PaginationVO calcPagination(int page, int itemSizePerPage);
//	Reservation selectOneWithCheckPoint(long userId, long reservationId);