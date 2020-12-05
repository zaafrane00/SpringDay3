package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    String index() {
        return "Hello from home index";
    }

    @RequestMapping("/info")
    String info() {
        return "Hello from info";
    }
}
