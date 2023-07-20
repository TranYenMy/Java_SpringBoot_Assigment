package fpt.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("say-hello")

    public String sayHello(Model model){
        String username = "myTy";
        model.addAttribute("name", username);
        return "hello";
    }
}
