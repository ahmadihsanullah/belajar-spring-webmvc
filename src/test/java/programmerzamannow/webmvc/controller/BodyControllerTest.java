package programmerzamannow.webmvc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import programmerzamannow.webmvc.model.HelloRequest;
import programmerzamannow.webmvc.model.HelloResponse;

@SpringBootTest
@AutoConfigureMockMvc
public class BodyControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testBody() throws Exception{
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName("ahmad");

        String request = objectMapper.writeValueAsString(helloRequest);

        mockMvc.perform(
                post("/body/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(request))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(result ->{
                String response = result.getResponse().getContentAsString();
                HelloResponse helloResponse = objectMapper.readValue(response, HelloResponse.class);
                assertEquals("Hello ahmad", helloResponse.getHello());
            });
    }
    
}
