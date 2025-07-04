package kr.ac.kopo.board.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.board.dao.ReservationDao;
import kr.ac.kopo.board.dao.UserDao;
import kr.ac.kopo.board.domain.Reservation;
import kr.ac.kopo.board.domain.User;
import kr.ac.kopo.board.vo.ReservationVO;

@Transactional // 클래스/메소드 단위 모두 붙일 수 있음.
@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDao reservationDao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public Long count() {
		return reservationDao.count();
	}

	@Override
	public Reservation selectOne(long id) {
		return reservationDao.selectOne(id);
	}

	@Override
	public List<Reservation> selectAll() {
		return reservationDao.selectAll();
	}

	@Override
	public List<Reservation> selectAllByPagination(int page, int itemSizePerPage) {
		return reservationDao.selectAllByPagination(page, itemSizePerPage);
	}

	@Override
	public int createOne(Reservation gongji) {
		return reservationDao.createOne(gongji);
	}

	@Override
	public void updateOne(Reservation gongji) {
		reservationDao.updateOne(gongji);
	}

	@Override
	public void deleteOne(Reservation gongji) {
		reservationDao.deleteOne(gongji);
	}

	@Override
	public int deleteAll() {
		return reservationDao.deleteAll();
	}
	
	
	@Override
	public Reservation selectOneByDateRoom(Date date, int room_id) {
		return reservationDao.selectOneByDateRoom(date, room_id);
	}

	@Override
	public List<ReservationVO> setReservationVOs() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");

		List<ReservationVO> rVOs = new ArrayList<ReservationVO>();
        for(int i=0; i<30; i++) {
        	// 예약 여부 확인
        	Reservation vip = selectOneByDateRoom(cal.getTime(), 1);
	    	Reservation common = selectOneByDateRoom(cal.getTime(), 2);
	    	Reservation reasonable = selectOneByDateRoom(cal.getTime(), 3);
	    	
	    	// 예약 객체 세팅
	    	ReservationVO rVO = new ReservationVO();
	    	rVO.setDate(sdf.format(cal.getTime()));
	    	rVO.setVip(vip);
	    	rVO.setCommon(common);
	    	rVO.setReasonable(reasonable);
	    	rVOs.add(rVO);
	    	// 날짜 더하기
	    	cal.add(cal.DATE, 1);    
	    }

        return rVOs;
	}

	@Override
	public List<String> dates() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");

		List<String> dates = new ArrayList<String>();
		for(int i=0; i<30; i++) {
			dates.add(sdf.format(cal.getTime()));
			cal.add(cal.DATE, 1);
		}
		
		return dates;
	}

}

//	@Override
//	public boolean isReservationExist(Reservation gongji) {
//		Reservation g = reservationDao.selectOne(gongji.getId());
//		return g == null ? false : true;
//	}
//	
//	@Override
//	public void deleteOne(long id) {
//		Reservation g = reservationDao.selectOne(id);
//		reservationDao.deleteOne(g);
//	}
//
//	@Override
//	public PaginationVO calcPagination(int page, int itemSizePerPage) {
//		PaginationVO p = new PaginationVO();
//		
//		int last = (count().intValue()-1) / itemSizePerPage + 1;
//		int paginationSize = 10;
//		int start = ((page-1)/paginationSize) * paginationSize+1;
//		int _end = start + paginationSize -1;
//		int end = _end < last ? _end : last;
//		int prev = start > 1 ? start -1 : 1;
//		int next = end >= last ? last : end + 1;
//		
//		p.setFirstPage(1);
//		p.setLastPage(last);
//		p.setPrevPage(prev);
//		p.setNextPage(next);
//		p.setStartPage(start);
//		p.setEndPage(end);
//		
//		return p;
//	}
//
//	@Override
//	public int getRecnt(int rootid, int parentRelevel, int parentRecnt) {
//		return reservationDao.getRecnt(rootid, parentRelevel, parentRecnt);
//	}
//
//	@Override
//	public void updateRecnt(int rootid, int recnt) {
//		reservationDao.updateRecnt(rootid, recnt);
//	}
//
//	@Override
//	public void delete(int rootid, int recnt, int nextRecnt) {
//		reservationDao.delete(rootid, recnt, nextRecnt);
//		
//	}