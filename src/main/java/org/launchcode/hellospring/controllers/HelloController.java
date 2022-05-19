package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

// Default - localhost:8080
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    // Controller METHODS

    // Handles request at URL path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        String greeting = "Hello, Spring!";
//        return greeting;
//    }

    // Lives at URL path /hello/goodbye
    @GetMapping("goodbye")  // <- argument within parentheses
    public String goodbye() {
        String message = "Goodbye, Spring!";
        return message;
    }

    // Lives at URL path /hello/hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        String greeting = "Hello, " + name + "!";
        return greeting;
    }

    // Lives at URL path /hello/LaunchCode
    @GetMapping("{name}") // <- name is a placeholder
    public String helloWithPathParam(@PathVariable String name) {
        String greeting = "Hello, " + name + "!";
        return greeting;
    }

    // Lives at URL path /hello/form
    @GetMapping("form") // <- argument within parentheses
    public String helloForm() {
        String html =  "<html>" +
                "<body>" +
                "<form action='/hello' method='post'>" + // submit a request to /hello
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet  me!' />" +
                "</form>" +
                "</body>" +
                "</html>";
        return html;
    }

    @GetMapping
    public String mouth() {
        String voice = "Feed me code!";
        return voice;
    }
}

// Controllers and Routers above