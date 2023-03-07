package com.hongsong.service.impl;

import com.hongsong.constant.ErrorCode;
import com.hongsong.exception.ValidException;
import com.hongsong.pojo.po.Employee;
import com.hongsong.pojo.po.Module;
import com.hongsong.dao.ModuleMapper;
import com.hongsong.pojo.vo.ModuleVO;
import com.hongsong.service.ModuleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongsong.util.EmployeeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

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

        return null;
    }
}
