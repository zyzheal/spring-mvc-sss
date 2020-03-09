package com.lagou.demo.controller;

import com.lagou.demo.service.IDemoService;
import com.lagou.edu.mvcframework.annotations.LagouAutowired;
import com.lagou.edu.mvcframework.annotations.LagouController;
import com.lagou.edu.mvcframework.annotations.LagouRequestMapping;
import com.lagou.edu.mvcframework.annotations.LagouSecurity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@LagouController
@LagouRequestMapping("/demo")
public class DemoController {
    @LagouAutowired
    private IDemoService demoService;

    /**
     * @param request
     * @param response
    ·* @param name
     * @return
     */
    @LagouSecurity({"test"})
    @LagouRequestMapping("/query")
    public String query(HttpServletRequest request, HttpServletResponse response, String username) {
        return demoService.get(username);
    }
    // 接口/demo/handler01 有权限用户 test1 test3
    @LagouSecurity(value = {"test1","test3"})
    @LagouRequestMapping("/handler01")
    public String handler01(HttpServletRequest request, HttpServletResponse response,String username){
        return demoService.get(username);
    }
    // 接口/demo/handler02 有权限用户 test2
    @LagouSecurity({"test2"})
    @LagouRequestMapping("/handler02")
    public String handler02(HttpServletRequest request, HttpServletResponse response,String username){
        return demoService.get(username);
    }
}