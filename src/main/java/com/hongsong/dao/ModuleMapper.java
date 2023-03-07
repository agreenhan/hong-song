package com.hongsong.dao;

import com.hongsong.pojo.po.Module;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 模块表 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2023-03-06 09:57:52
 */
public interface ModuleMapper extends BaseMapper<Module> {
    /**
     * @Description: 根据员工职位查询对应的模块权限
     * @param roleId 职位id
     * @return List<Module> 模块记录
     * @Author: agreenHan
     * @Date: 2023/3/7 0:02
     */
    List<Module> getModuleList(@Param("roleId") Integer roleId);
}
