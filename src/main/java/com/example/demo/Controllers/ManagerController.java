package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    String index() {
        return "Hello from manager index";
    }

    @RequestMapping("/index")
    String edit() {
        return "Hello from manager edit manager";
    }
}
