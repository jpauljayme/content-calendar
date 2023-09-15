package dev.mayhm.contentcalendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "mayhm")
public record ContentCalendarProperties(String welcomeMessage, String about) {


}
