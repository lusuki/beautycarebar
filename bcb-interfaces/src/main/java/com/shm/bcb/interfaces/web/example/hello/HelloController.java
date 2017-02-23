package com.shm.bcb.interfaces.web.example.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sherman on 2017/2/23.
 */
@Controller
public class HelloController {
    @RequestMapping(value="/hello",  method = RequestMethod.GET)
    public String customerList(Model model) {
        model.addAttribute("projectName", "BCB");
        return "example/hello";
    }
}
