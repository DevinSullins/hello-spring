package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")

public class HelloController {



    // Handles request at path /hello
    @RequestMapping("")
    public String hello(@RequestParam String name, @RequestParam String language, Model model){
        String greeting = createMessage(name, language);
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Handles request at path /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping("greeting")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        String message = createMessage(name, language);
        return message;
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("/{name}/{language}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name, @PathVariable String language) {
        return createMessage(name, language);
    }


    public static String createMessage(String name, String language){

        if (language.equals("sp")){
            return "Hola, " + name + "!";
        } else if (language.equals("fr")){
            return "Bonjour " + name + "!";
        } else if (language.equals("ru")){
            return "Zdravstvuyte " + name + "!";
        } else if (language.equals("jp")){
            return "Konnichiwa " + name + "!";
        } else if (language.equals("en")){
            return "Hello, " + name + "!";
        } else {
            return language;
        }

    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("names")
    public String helloNames( Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);

        return "hello-list";
    }

}
