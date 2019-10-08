package routing;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private static final String message = "Hello, World!";

    @CrossOrigin
    @RequestMapping("/helloWorld")
    public HelloWorld helloWorld() {
        return new HelloWorld(message);
    }
}