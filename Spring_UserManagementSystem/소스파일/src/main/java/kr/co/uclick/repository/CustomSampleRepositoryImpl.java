package kr.co.uclick.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import kr.co.uclick.entity.User;

public class CustomSampleRepositoryImpl implements CustomSampleRepository {

	private static final Logger logger = LoggerFactory.getLogger(CustomSampleRepositoryImpl.class);

//	@Autowired
//	private SessionFactory sessionFactory; // 객체가 주입됨.
//	
//	private Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}
//	
//	
//	@Override
//	public void doSample(String name) {
//		logger.debug("doSample : {}, {}", name, 1);
//		
//		
//		
//		String hql = "SELECT COUNT(*) FROM Gongji";
//		Query query = getSession().createQuery(hql);
//		Long totalCount = (Long) query.uniqueResult();
////		return totalCount;
//	}
	
//	private static final Logger logger = LoggerFactory.getLogger(CustomUserRepositoryImpl.class);
//
//	@Autowired
//	private SessionFactory sessionFactory; // 객체가 주입됨.
//	
//	private Session getSession() {
//		return sessionFactory.getCurrentSession();
//	}
//	
//	private void sleep(long millis) {
//		try {
//			Thread.sleep(millis);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Cacheable(value = "area")
//	public User selectOne(Long id) {
//		sleep(3000);
//		
//		String hql = "FROM User u WHERE u.id = " + id;
//		Query query = getSession().createQuery(hql).setCacheable(true); //.setChacheable(true) : 쿼리캐시
//		return (User) query.uniqueResult();
//		
////		return (User) query.list().get(0);
//		
////		return (Users) getSession().get(Users.class, id);
//	}

}
