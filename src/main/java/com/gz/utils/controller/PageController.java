package com.gz.utils.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Gz
 * @Date: 2018/12/24 9:53
 */
@Controller
public class PageController {

    @RequestMapping(value="/upload")
    public String upload(){
        return "upload";
    }
}
