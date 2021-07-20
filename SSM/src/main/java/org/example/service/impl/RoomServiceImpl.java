package org.example.service.impl;

import org.example.dao.RoomMapper;
import org.example.entity.Room;
import org.example.service.RoomService;
import org.example.vo.RoomVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Resource
    private RoomMapper roomMapper;

    /**
     * 查询房间列表
     *
     * @param roomVo
     * @return
     */
    public List<Room> findRoomListByPage(RoomVo roomVo) {
        return roomMapper.findRoomListByPage(roomVo);
    }

    public int addRoom(Room room) {
        return roomMapper.addRoom(room);
    }

    public int updateRoom(Room room) {
        return roomMapper.updateRoom(room);
    }

    public int deleteById(int id) {
        return roomMapper.deleteById(id);
    }

    public List<Room> findRoomListByFloorId() {
        return roomMapper.findRoomListByFloorId();
    }

    public Room findById(Integer id) {
        return roomMapper.findById(id);
    }
}
