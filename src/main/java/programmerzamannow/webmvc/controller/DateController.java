package programmerzamannow.webmvc.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DateController {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    @RequestMapping("/date")
    public void getDate(@RequestParam(name = "date")Date date,
                        HttpServletResponse response) throws IOException {
        response.getWriter().println(String.format("Date: " + dateFormat.format(date)));
    }
}
