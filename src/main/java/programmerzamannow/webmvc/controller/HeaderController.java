package programmerzamannow.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {
    
    @GetMapping("/header/token")
    @ResponseBody
    public String token(@RequestHeader(name = "x-token", defaultValue = "")String token){
        if(token != "ahmad"){
            return "KO";
        }else{
            return "OK";
        }
    }
}
