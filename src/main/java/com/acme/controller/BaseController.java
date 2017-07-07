package com.acme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Taras Oleksiuk
 */

@Controller
@RequestMapping(path = "/")
public class BaseController {
    @RequestMapping("/")
    public String home(){
        return "index";
    }

}
