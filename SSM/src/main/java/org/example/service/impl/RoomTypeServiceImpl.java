package org.example.service.impl;

import org.example.dao.RoomTypeMapper;
import org.example.entity.RoomType;
import org.example.service.RoomTypeService;
import org.example.vo.RoomTypeVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService {

    @Resource
    private RoomTypeMapper roomTypeMapper;

    /**
     * 查询房型列表
     *
     * @param roomTypeVo
     * @return
     */
    public List<RoomType> findRoomTypeList(RoomTypeVo roomTypeVo) {
        return roomTypeMapper.findRoomTypeList(roomTypeVo);
    }

    public int addRoomType(RoomType roomType) {
        //可用房间数默认是全部的房间数量
        roomType.setAvilablenum(roomType.getRoomnum());
        roomType.setLivednum(0);//已入住房间数量
        return roomTypeMapper.addRoomType(roomType);
    }

    public int updateRoomType(RoomType roomType) {
        //可用房间数默认是全部的房间数量
        roomType.setAvilablenum(roomType.getRoomnum()); // 10
        roomType.setLivednum(0);//已入住房间数量
        return roomTypeMapper.updateRoomType(roomType);
    }
}
