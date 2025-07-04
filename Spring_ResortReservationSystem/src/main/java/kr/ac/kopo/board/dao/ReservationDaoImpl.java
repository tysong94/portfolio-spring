package kr.ac.kopo.board.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.board.domain.Reservation;

@Transactional
@Repository
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	private SessionFactory sessionFactory; // ∞¥√º∞° ¡÷¿‘µ .
	
	private Session getSession() {
//		return sessionFactory.openSession();	
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Long count() {
		String hql = "SELECT COUNT(*) FROM Reservation";
		Query query = getSession().createQuery(hql);
		Long totalCount = (Long) query.uniqueResult();
		return totalCount;
	}
	
	@Override
	public Reservation selectOne(long id) {
		String hql = "FROM Reservation r WHERE r.id = " + id;
		Query query = getSession().createQuery(hql);
		return (Reservation) query.uniqueResult();
		
//		return (Reservation) query.list().get(0);
		
//		return (Reservations) getSession().get(Reservations.class, id);
	}
	
	@Override
	public List<Reservation> selectAll() {
		String hql = "FROM Reservation";
		Query query = getSession().createQuery(hql);
		return query.list();
		
//		return getSession().createCriteria(Reservations.class).list();
	}
	
	@Override
	public Reservation selectOneByDateRoom(Date date, int roomid) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String string_date = sdf.format(date);
		
		String hql = "FROM Reservation r WHERE r.date like '"+ string_date +"%' and room_id = "+roomid;
		Query query = getSession().createQuery(hql);
		return (Reservation) query.uniqueResult();
	}

	@Override
	public List<Reservation> selectAllByPagination(int page, int itemSizePerPage) {
		String hql = "FROM Reservation ORDER BY root desc, parent asc";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((page - 1) * itemSizePerPage);
		query.setMaxResults(itemSizePerPage);
		return query.list();
	}

	@Override
	public int createOne(Reservation reservation) {
		return (int) getSession().save(reservation);
		
//		session.close();
//		session.close();
	}

	@Override
	public void updateOne(Reservation reservation) {
		getSession().saveOrUpdate(reservation);
	}

	@Override
	public void deleteOne(Reservation reservation) {
		getSession().delete(reservation);
	}
	
	@Override
	public int deleteAll() {
		String hql = "DELETE FROM Reservation";
		Query query = getSession().createQuery(hql);
		return query.executeUpdate();
	}


}

//	@Override
//	public int getRecnt(int rootid, int parentRelevel, int parentRecnt) {
//		String hql = "select ifnull((select min(recnt) from reservation where root = "+rootid+" and relevel <= "+parentRelevel+" and recnt > "+parentRecnt+"),\r\n" 
//                +"(select max(recnt) + 1 from reservation where root = "+rootid+"))\r\n"
//                +"from dual";
//		Query query = getSession().createSQLQuery(hql);
//		int recnt = ((BigInteger) query.uniqueResult()).intValue();
//		
//		return recnt;
//	}
//	
//	public void updateRecnt(int rootid, int recnt) {
//		String hql = "UPDATE Reservation SET recnt = recnt+1 where root = "+rootid+" and recnt >= "+recnt;
//        Query query = getSession().createSQLQuery(hql);
//        query.executeUpdate();
//       
//    }
//
//	@Override
//	public void delete(int rootid, int recnt, int nextRecnt) {
//		String hql = "delete from reservation where root = "+rootid+" and recnt >= "+recnt+" and recnt < "+nextRecnt;
//		Query query = getSession().createSQLQuery(hql);
//		query.executeUpdate();
//		
//		hql = "update reservation set recnt = recnt-"+(nextRecnt-recnt)+" where recnt >= "+nextRecnt;
//		query = getSession().createSQLQuery(hql);
//		query.executeUpdate();
//	}