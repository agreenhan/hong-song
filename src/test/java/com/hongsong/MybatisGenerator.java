package com.hongsong;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;

/**
 * @Description: mybatis-plus代码生成器
 * @Author: agreenHan
 * @Date: 2023/2/26 10:39
 */
public class MybatisGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/hongsong", "root", "jht123456")
                // 全局配置
                .globalConfig(builder -> {
                    System.out.println(builder.author("author") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir") + "/src/main/java") // 指定输出目录
                            .dateType(DateType.ONLY_DATE) //定义生成的实体类中日期的类型 TIME_PACK=LocalDateTime;ONLY_DATE=Date;
                            .commentDate("yyyy-MM-dd hh:mm:ss"));
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("com") // 设置父包名
                            .moduleName("hongsong") // 设置父包模块名
                            .entity("pojo.po") // 设置实体包名
                            .service("service") // Service包名
                            .serviceImpl("service.impl") // ServiceImpl包名
                            .controller("controller") // controller包名
                            .mapper("dao") // Mapper包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml , System.getProperty("user.dir")+"/src/main/resources/mapper"));    //配置 mapper.xml 路径信息：项目的 resources 目录下
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("t_role_permission", "t_button", "t_button_permission", "t_emp_role", "t_employee_training")
                            .addTablePrefix("t_") // 设置过滤表前缀
                            .enableSkipView() // 开启跳过视图
                            // 实体类策略配置
                            .entityBuilder()
                            .enableTableFieldAnnotation() // 开启生成实体时字段注解
                            .enableLombok() // 开启 lombok 模型
                            .logicDeleteColumnName("is_deleted") //逻辑删除字段名(数据库)
                            .logicDeletePropertyName("deleted") //逻辑删除属性名(实体)
                            .naming(NamingStrategy.underline_to_camel) //数据库表映射到实体的命名策略：默认是下划线转驼峰命。这里可以不设置
                            .columnNaming(NamingStrategy.underline_to_camel) //数据库表字段映射到实体的命名策略：下划线转驼峰命。(默认是和naming一致，所以也可以不设置)
                            .addTableFills(
                                    new Column("created_time", FieldFill.INSERT),
                                    new Column("modified_time", FieldFill.INSERT_UPDATE)
                            ) // 添加表字段填充，"create_time"字段自动填充为插入时间，"modify_time"字段自动填充为插入修改时间
                            .idType(IdType.AUTO) // 开启主键自增
                            // Controller策略配置
                            .controllerBuilder()
                            .enableHyphenStyle() // 开启驼峰连转字符
                            .formatFileName("%sController") // 格式化 Controller 类文件名称，%s进行匹配表名，如 UserController
                            .enableRestStyle() // 开启生成@RestController控制器
                            // service策略配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                            .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl
                            .mapperBuilder()
                            .superClass(BaseMapper.class) // 设置父类
                            .formatXmlFileName("%sMapper") //格式化Xml文件名称
                            .formatMapperFileName("%sMapper");   //格式化Mapper文件名称
                    ;
                })
                // 模板
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                // 执行
                .execute();
    }
}
