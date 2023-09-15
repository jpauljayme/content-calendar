package dev.mayhm.contentcalendar.controller;

import dev.mayhm.contentcalendar.config.ContentCalendarProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    //Get value from app.properties
    @Value("${wtf.welcomeMessage: some default}")
    private String welcomeMessage1;

    private final ContentCalendarProperties contentCalendarProperties;

    public HomeController(ContentCalendarProperties contentCalendarProperties) {
        this.contentCalendarProperties = contentCalendarProperties;
    }


//    @GetMapping("/")
//    public String home(){
//        return welcomeMessage;
//    }
    @GetMapping("/")
    public ContentCalendarProperties home(){
        return contentCalendarProperties;
    }

}
