package programmerzamannow.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static  org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloGuest() throws Exception {
        mockMvc.perform(
                get("/hello")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Guest"))
        );
    }

    @Test
    void helloAhmad() throws Exception {
        mockMvc.perform(
                get("/hello").queryParam("name","Ahmad")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Ahmad"))
        );
    }

    @Test
    void helloName() throws Exception{
        mockMvc.perform(
                get("/hello").queryParam("name","Sholihaha")
        ).andDo(print())
        .andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Sholihah"))
        );
    }

    @Test
    void helloNotAllowed() throws Exception{
        mockMvc.perform(
                post("/hello").queryParam("name","Sholihaha")
        ).andDo(print())
        .andExpectAll(
                status().isMethodNotAllowed()
        );
    }
}
