package kr.ac.kopo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import kr.ac.kopo.board.dao.RoomDao;
import kr.ac.kopo.board.domain.Room;

@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDao roomDao;
	
	@Override
	public Long count() {
		return roomDao.count();
	}

	@Override
	public Room selectOne(long id) {
		return roomDao.selectOne(id);
	}

	@Override
	public List<Room> selectAll() {
		return roomDao.selectAll();
	}

	@Override
	public List<Room> selectAllByPagination(int page, int itemSizePerPage) {
		return roomDao.selectAllByPagination(page, itemSizePerPage);
	}

	@Override
	public int createOne(Room room) {
		return roomDao.createOne(room);
	}

	@Override
	public void updateOne(Room room) {
		roomDao.updateOne(room);
	}

	@Override
	public void deleteOne(Room room) {
		roomDao.deleteOne(room);
	}

	@Override
	public int deleteAll() {
		return roomDao.deleteAll();
	}
	
	@Override
	public boolean isUserExist(Room room) {
		Room u = roomDao.selectOne(room.getId());
		return u == null ? false : true;
	}
	
	@Override
	public void deleteOne(long id) {
		Room u = roomDao.selectOne(id);
		roomDao.deleteOne(u);
	}
	
}
