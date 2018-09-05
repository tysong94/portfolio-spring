package kr.ac.kopo.board.dao;

import java.math.BigInteger;
import java.util.List;

import kr.ac.kopo.board.domain.Room;

public interface RoomDao {
	
	// READ
	Long count(); 
	Room selectOne(long id); 
	List<Room> selectAll();
	List<Room> selectAllByPagination(int page, int itemSizePerPage);	/*페이지네이션...*/
	
	// CREATE, UPDATE, DELETE
	int createOne(Room room);		
	void updateOne(Room room);	
	void deleteOne(Room room);	
	int deleteAll();				
	
	// ELSE
	int getRecnt(int rootid, int parentRelevel, int parentRecnt);
	void updateRecnt(int rootid, int recnt);
	void delete(int rootid, int recnt, int nextRecnt);
}
