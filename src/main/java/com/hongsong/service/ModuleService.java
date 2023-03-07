package com.hongsong.service;

import com.hongsong.common.ResponseResult;
import com.hongsong.pojo.po.Module;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hongsong.pojo.vo.ModuleVO;

import java.util.List;

/**
 * <p>
 * 模块表 服务类
 * </p>
 *
 * @author author
 * @since 2023-03-06 09:57:52
 */
public interface ModuleService extends IService<Module> {

    /**
     * @Description: 获取当前员工的可见模块
     * @return ModuleVO
     * @Author: agreenHan
     * @Date: 2023/3/6 22:02
     */
    List<ModuleVO> getModuleList();

    /**
     * @Description: 生成动态路由所需的数据
     * @param moduleList 模块列表
     * @return ModuleVO 模块树状结构
     * @Author: agreenHan
     * @Date: 2023/3/6 23:31
     */
    List<ModuleVO> generatorModuleTree(List<Module> moduleList);
}
