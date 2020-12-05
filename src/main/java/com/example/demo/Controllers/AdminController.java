package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    String index() {
        return "<h1>Hello from admin index</h1>";
    }

    String configadmin() {
        return "Hello from admin index";
    }

}
