package com.chenfeng.app.springbootvue.test;

import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Api(value = "person", description = "用户管理", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {
    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户接口", notes = "获取用户接口详细描述")
    public Person get(String name, int num) {
        return new Person(name, num);
    }


    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @ApiOperation(value = "创建用户接口", notes = "创建用户接口详细描述")
    public Map<String, Object> post(Person person) {
        System.out.println(person);
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("status", "ok");
        map.put("msg", "are you ok");
        return map;
    }
}
