package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HelloWorldController {

    @GetMapping(path = "/hello")
    String helloWorld() {
        return "hello";
    }

}
