package com.ken.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MyController
 * @Author xinfei
 * @Date 2018/7/24 17:14
 **/
@RestController
@RequestMapping(value = "/my")
public class MyController {


    @RequestMapping("/first")
    @ResponseBody
    public String firstService(){
        return "Hello world2";
    }

}
