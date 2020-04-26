package com.greeting.controller;

import com.greeting.model.Greeting;
import com.greeting.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.greeting.service.IGreetingService;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private IGreetingService greetingService;

    @GetMapping(value = {"", "/", "/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user  = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    @PostMapping("/post/greeting")
    public Greeting createGreeting(@RequestBody User user) {
        return greetingService.createGreeting(user);
    }

    @GetMapping("/getAll/greeting")
    public List<Greeting> findGreeting(){
        return greetingService.getAllGreetings();
    }

    @GetMapping(value = "/find/greeting/{id}")
    public Greeting findByIdGreeting(@PathVariable(value = "id") Long id){
        return greetingService.getGreetingById(id);
    }

    @PutMapping("/update/greeting")
    public Greeting updateGreeting(@RequestBody User user){
        return greetingService.updateGreeting(user);
    }

    @DeleteMapping(value="/delete/greeting")
    public String deleteGreeting(@RequestParam(value = "id") Long id){
        return greetingService.deleteGreeting(id);
    }

    @DeleteMapping(value="/delete/allgreeting")
    public String deleteALLGreeting(){
            return greetingService.deleteALLGreeting();
    }

}

