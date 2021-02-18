package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
@ResponseBody
public class HelloController {



    // Handles request at path /hello
    @GetMapping("")
    public String hello(){
        return "Hello, Spring!";
    }

    // Handles request at path /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping("greeting")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        String message = createMessage(name, language);
        return message;
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("/{name}/{language}")
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
        return "<html>" +
                "<body>" +
                "<form action='greeting' method='post'>" + //submit a request to hello
                "<input type='text' name='name'>" +
                "<select name='language' id='language-select'>" +
                "<option value=''> Language </option>" +
                "<option value='en'> English </option>" +
                "<option value='sp'> Spanish </option>" +
                "<option value='fr'> French </option>" +
                "<option value='ru'> Russian </option>" +
                "<option value='jp'> Japanese </option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
