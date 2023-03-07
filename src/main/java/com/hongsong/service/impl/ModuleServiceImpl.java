package com.hongsong.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hongsong.constant.ErrorCode;
import com.hongsong.exception.ValidException;
import com.hongsong.pojo.po.Employee;
import com.hongsong.pojo.po.Module;
import com.hongsong.dao.ModuleMapper;
import com.hongsong.pojo.vo.Meta;
import com.hongsong.pojo.vo.ModuleVO;
import com.hongsong.service.ModuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongsong.util.EmployeeUtil;
import com.hongsong.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 模块表 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-03-06 09:57:52
 */
@Service
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements ModuleService {
    @Resource
    private ModuleMapper moduleMapper;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public List<ModuleVO> getModuleList() {
        Employee employee = EmployeeUtil.getEmployee();
        if (Objects.isNull(employee)) {
            throw new ValidException(ErrorCode.LOGIN_STATE_VALID, null);
        }
        List<Module> moduleList = moduleMapper.getModuleList(employee.getRoleId());
        return generatorModuleTree(moduleList);
    }

    @Override
    public List<ModuleVO> generatorModuleTree(List<Module> moduleList) {
        // 一级功能
        List<ModuleVO> firstModuleVOS = new ArrayList<>();
        // 获取父功能
        ModuleVO moduleVO;
        moduleList.forEach(m -> {
            if (Objects.nonNull(m)) {
                if (m.getParentId() == 0) {
                    ModuleVO vo = this.module2ModuleVO(m);
                    firstModuleVOS.add(vo);
                }
            }
        });
        // 将二级功能放入父功能中
        for (ModuleVO firstModuleVO : firstModuleVOS) {
            for (Module module : moduleList) {
                if (Objects.isNull(module.getParentId())) {
                    continue;
                }
                if (module.getParentId().equals(firstModuleVO.getId())) {
                    ModuleVO moduleVO1 = this.module2ModuleVO(module);
                    firstModuleVO.getChildren().add(moduleVO1);
                }
            }
        }
        return firstModuleVOS;
    }

    @Override
    public ModuleVO module2ModuleVO(Module module) {
        if (Objects.isNull(module)) {
            return null;
        }
        ModuleVO moduleVO = new ModuleVO();
        moduleVO.setId(module.getId());
        moduleVO.setName(module.getName());
        moduleVO.setMeta(new Meta(module.getTitle(), module.getIcon()));
        moduleVO.setPath(module.getPath());
        moduleVO.setRedirect(module.getRedirect());
        moduleVO.setComponent(module.getComponent());
        return moduleVO;
    }
}
