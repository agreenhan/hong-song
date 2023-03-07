package com.hongsong.controller;


import com.hongsong.common.ResponseResult;
import com.hongsong.constant.HttpStatus;
import com.hongsong.service.ModuleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 模块表 前端控制器
 * </p>
 *
 * @author author
 * @since 2023-03-06 09:57:52
 */
@RestController
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('test')")
    @ApiOperation(value = "获取当前用户的可用模块")
    public ResponseResult<?> moduleList() {
        return ResponseResult.success().data(moduleService.getModuleList());
    }
}
