package com.greeting.service;

import com.greeting.exception.GreetingException;
import com.greeting.repository.GreetingRepository;
import com.greeting.model.Greeting;
import com.greeting.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template,(user.toString().isEmpty()) ?"Hello world":user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));

    }

    @Override
    public Greeting createGreeting(User user) {
        String fullname = String.format(template,(user.getFirstName().isEmpty()) ?"Hello world":user.getFirstName()+ " " + user.getLastName());
        System.out.println(user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(),fullname));
    }


    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElseThrow(()->new GreetingException("No Record Available"));
    }

    @Override
    public Greeting updateGreeting(User user) {
        if(!greetingRepository.existsById(user.getId()))
            throw new GreetingException("Record Can Not Be Update");
        String message=user.getFirstName() +" "+user.getLastName();
        Greeting greeting = greetingRepository.findById(user.getId()).get();
        greeting.setMessage(String.format(template,message));
        return greetingRepository.save(greeting);

    }

    @Override
    public String deleteGreeting(Long id) {
        if(!greetingRepository.existsById(id)) throw new GreetingException("Record Can Not Be Deleted");
        greetingRepository.deleteById(id);
        return "Greeting with id "+id+" successfully deleted";
    }


    @Override
    public String deleteALLGreeting() {
       long count= greetingRepository.count();
        greetingRepository.deleteAll();
        return "Deleted "+ count+" greetings sucessfully";

    }
}