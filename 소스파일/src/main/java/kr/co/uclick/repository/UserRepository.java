package kr.co.uclick.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import kr.co.uclick.entity.User;

public interface UserRepository
		extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {

	public List<User> findAllByOrderByIdDesc();
	
	@QueryHints(value= {
	           @QueryHint(name="org.hibernate.cacheable", value="true"),
	           @QueryHint(name="org.hibernate.cacheMode", value="NORMAL"),
	})
	public List<User> findByNameContaining(String name);
}