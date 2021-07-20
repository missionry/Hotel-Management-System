package org.example.service;

import org.example.entity.Checkin;
import org.example.vo.CheckinVo;

import java.util.List;

public interface CheckinService {
    /**
     * 查询入住列表
     * @param checkinVo
     * @return
     */
    List<Checkin> findCheckinList(CheckinVo checkinVo);

    /**
     * 添加入住信息
     * @param checkin
     * @return
     */
    int addCheckin(Checkin checkin);
}
