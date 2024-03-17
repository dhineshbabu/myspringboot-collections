package com.performance.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
//    @GetMapping("/hello")
//    public String sayHello() {
//        return "Hello from my first controller";
//    }

    @GetMapping("/hello2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2() {
        return "Hello2 from my first controller";
    }

    @PostMapping("/post")
    public String post(@RequestBody String message){
        return "Request Accepted and message: " + message;
    }

    @PostMapping("/post-order")
    public String post(@RequestBody Order order){
        return "Request Accepted and order is : " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String post(@RequestBody OrderRecord order){
        return "Request Accepted and order is : " + order.toString();
    }

    //http://localhost:8080/hello/performance
    @GetMapping("/hello/{user-name}")
    public String pathvar(@PathVariable("user-name") String userName) {
        return "My value = " + userName ;
    }

    //http://localhost:8080/hello?user-name=performance&user-exp=12
    @GetMapping("/hello")
    public String paramVars(
            @RequestParam("user-name") String userName,
            @RequestParam("user-exp") String exp) {
        return "My value = " + userName + " exp = " + exp;
    }
}
