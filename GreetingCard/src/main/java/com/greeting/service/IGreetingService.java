package com.greeting.service;

import com.greeting.model.Greeting;
import com.greeting.model.User;

import java.util.List;


public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting createGreeting(User user);
    List<Greeting> getAllGreetings();
    Greeting getGreetingById(Long id);
    Greeting updateGreeting(User user);
    String deleteGreeting(Long id);
    String deleteALLGreeting();
}
