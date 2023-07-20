package fpt.demo.controller;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {
    @GetMapping("login")
    public String getLoginForm() {
        return "login";
    }

    @PostMapping ("login")
    public String login(
            @RequestParam("uname") String username,
            @RequestParam("pw") String password,
//            @RequestParam(name = "remember", defaultValue= "false") Boolean remember
            @RequestParam(name = "remember")Optional<Boolean> remember
            ) {
        System.out.println(username);
        System.out.println(password);
        if(remember.isEmpty()){
            System.out.println("khong nho dang nhap");
        }else{
            System.out.println(remember.get());
        }
        return "login";
    }


}
