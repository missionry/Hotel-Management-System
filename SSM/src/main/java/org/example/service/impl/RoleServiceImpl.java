package org.example.service.impl;

import org.example.dao.RoleMapper;
import org.example.entity.Role;
import org.example.service.RoleService;
import org.example.vo.RoleVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    /**
     * 查询角色列表
     *
     * @param roleVo
     * @return
     */
    public List<Role> findRoleList(RoleVo roleVo) {
        return roleMapper.findRoleList(roleVo);
    }

    public int addRole(Role role) {
        return roleMapper.addRole(role);
    }

    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    public int deleteById(Integer id) {
        return roleMapper.deleteById(id);
    }

    public int saveRoleMenu(String ids, Integer roleId) {
        try {
            //删除原有的菜单关系
            roleMapper.deleteRoleMenu(roleId);//根据角色ID删除
            //将ids拆分成数组
            String [] idsStr = ids.split(",");
            //循环调用
            for (int i = 0; i <idsStr.length ; i++) {
                //调用保存菜单角色关系的方法
                roleMapper.addRoleMenu(roleId,idsStr[i]);
            }
            return 1;//成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;//失败
    }

    public List<Map<String, Object>> findRoleListByMap() {
        return roleMapper.findRoleListByMap();
    }

    public List<Integer> findEmployeeRoleByEmployeeId(Integer employeeId) {
        return roleMapper.findEmployeeRoleByEmployeeId(employeeId);
    }
}
