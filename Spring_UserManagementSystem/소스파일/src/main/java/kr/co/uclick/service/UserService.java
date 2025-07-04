package kr.co.uclick.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.User;
import kr.co.uclick.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	//READ---------------------------------------------
	@Transactional(readOnly = true)
	public List<User> findAllByOrderByIdDesc() {
		return userRepository.findAllByOrderByIdDesc();
	}
	
	@Transactional(readOnly = true)
	public List<User> findByNameContaining(String name) {
		return userRepository.findByNameContaining(name);
	}

	@Transactional(readOnly = true)
	public User findById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		return user.get();
	}

	//CREATE, UPDATE-------------------------------------
	public void save(User user) {
		userRepository.save(user);
	}
	
	//DELETE----------------------------------------------
	public void delete(User entity) {
		userRepository.delete(entity);
	}
	
	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

//@Transactional(readOnly = true)
//public List<User> findByNameLike(String name) {
//	Iterable<User> users_Iterable = userRepository.findAll(QUser.user.name.like("%" + name + "%"));
//	List<User> users = Lists.newArrayList(users_Iterable);
//	return users;
//}
