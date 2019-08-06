package com.gz.utils.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author by xueqichang
 * @Email 1369521908@qq.com
 * @Date 2019/8/6 12:14
 */
@RestController
public class InsertController {

    @RequestMapping("/insertData")
    public Object insertData() {
        return "fuck";
    }

}
