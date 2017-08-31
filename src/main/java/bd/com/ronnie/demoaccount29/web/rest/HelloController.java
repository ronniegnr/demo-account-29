package bd.com.ronnie.demoaccount29.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "hello")
    public String helloWorld() {
        return "Hello World";
    }

}
