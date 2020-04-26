package com.example.myfirstspring.controller;

import com.example.myfirstspring.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hellocontroller")
public class HelloWorldController {
    @RequestMapping(value = {"","/","/home"})
    public String sayHello(){
        return "hello world";
    }

    @RequestMapping(value = {"/query"},method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "fname") String fname,@RequestParam(value = "lname") String lname) {
        return "Hello"+"  "+fname+"  "+lname+"!";
    }
    @GetMapping("/param{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello"+" "+name+"!";
    }

    @PostMapping("/post")
    public String sayHello(@RequestBody User user)
    {
        return  "Hello"+" "+user.getFirstName()+" "+user.getLastName()+"!";
    }

    @PutMapping("/put/{firstName}")
    public String sayHelloput(@PathVariable String firstName,@RequestParam(value = "lastName")String lastName){
      return "Hello"+"  "+firstName+" "+lastName+"!";
    }
}
