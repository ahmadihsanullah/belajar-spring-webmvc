package programmerzamannow.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import programmerzamannow.webmvc.model.HelloRequest;
import programmerzamannow.webmvc.model.HelloResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BodyController {
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(
        path = "/body/hello",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public String body(@RequestBody String request) throws  JsonProcessingException {
        HelloRequest helloRequest = objectMapper.readValue(request, HelloRequest.class);

        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setHello("Hello " + helloRequest.getName());

        return objectMapper.writeValueAsString(helloResponse);

    }
    
}
