package programmerzamannow.webmvc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import programmerzamannow.webmvc.service.HelloService;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(path="/hello")
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String responseBody = helloService.hello(name);
        response.getWriter().print(responseBody);
    }
}
