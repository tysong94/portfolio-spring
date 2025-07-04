package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.domain.User;

public interface UserDao {
	//READ
	Long count();
	User selectOne(long index);
	User selectOne(String id);
	
	List<User> selectAll();
	List<User> selectAllByPagination(int page, int itemSizePerPage);
	
	//C, U, D
	int createOne(User user);
	void updateOne(User user);
	void deleteOne(User user);
	int deleteAll();
}
