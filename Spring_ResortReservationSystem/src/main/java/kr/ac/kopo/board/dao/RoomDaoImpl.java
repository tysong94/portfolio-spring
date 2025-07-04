package kr.ac.kopo.board.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.board.domain.Room;

@Transactional
@Repository
public class RoomDaoImpl implements RoomDao {

	@Autowired
	private SessionFactory sessionFactory; // ∞¥√º∞° ¡÷¿‘µ .
	
	private Session getSession() {
//		return sessionFactory.openSession();	
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Long count() {
		String hql = "SELECT COUNT(*) FROM Room";
		Query query = getSession().createQuery(hql);
		Long totalCount = (Long) query.uniqueResult();
		return totalCount;
	}
	
	@Override
	public Room selectOne(long id) {
		String hql = "FROM Room r WHERE r.id = " + id;
		Query query = getSession().createQuery(hql);
		return (Room) query.uniqueResult();
		
//		return (Room) query.list().get(0);
		
//		return (Rooms) getSession().get(Rooms.class, id);
	}

	@Override
	public List<Room> selectAll() {
		String hql = "FROM Room";
		Query query = getSession().createQuery(hql);
		return query.list();
		
//		return getSession().createCriteria(Rooms.class).list();
	}
	
	@Override
	public List<Room> selectAllByPagination(int page, int itemSizePerPage) {
		String hql = "FROM Room ORDER BY root desc, parent asc";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((page - 1) * itemSizePerPage);
		query.setMaxResults(itemSizePerPage);
		return query.list();
	}

	@Override
	public int createOne(Room room) {
		return (int) getSession().save(room);
		
//		session.close();
//		session.close();
	}

	@Override
	public void updateOne(Room room) {
		getSession().saveOrUpdate(room);
	}

	@Override
	public void deleteOne(Room room) {
		getSession().delete(room);
	}
	
	@Override
	public int deleteAll() {
		String hql = "DELETE FROM Room";
		Query query = getSession().createQuery(hql);
		return query.executeUpdate();
	}

	@Override
	public int getRecnt(int rootid, int parentRelevel, int parentRecnt) {
		String hql = "select ifnull((select min(recnt) from room where root = "+rootid+" and relevel <= "+parentRelevel+" and recnt > "+parentRecnt+"),\r\n" 
                +"(select max(recnt) + 1 from room where root = "+rootid+"))\r\n"
                +"from dual";
		Query query = getSession().createSQLQuery(hql);
		int recnt = ((BigInteger) query.uniqueResult()).intValue();
		
		return recnt;
	}
	
	public void updateRecnt(int rootid, int recnt) {
		String hql = "UPDATE Room SET recnt = recnt+1 where root = "+rootid+" and recnt >= "+recnt;
        Query query = getSession().createSQLQuery(hql);
        query.executeUpdate();
       
    }

	@Override
	public void delete(int rootid, int recnt, int nextRecnt) {
		String hql = "delete from room where root = "+rootid+" and recnt >= "+recnt+" and recnt < "+nextRecnt;
		Query query = getSession().createSQLQuery(hql);
		query.executeUpdate();
		
		hql = "update room set recnt = recnt-"+(nextRecnt-recnt)+" where recnt >= "+nextRecnt;
		query = getSession().createSQLQuery(hql);
		query.executeUpdate();
	}
	
}
