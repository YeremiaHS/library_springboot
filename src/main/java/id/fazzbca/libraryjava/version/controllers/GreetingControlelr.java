package id.fazzbca.libraryjava.version.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GreetingControlelr {
    @GetMapping("/hello")
    public String greeting(){
        return"Hello World!";
    }

    @PostMapping("/hello4")
    public String greeting3(@PathVariable String name){
        return "Hello" + name + "! dari path variable";
    }
}

