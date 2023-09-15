package dev.mayhm.contentcalendar;

import dev.mayhm.contentcalendar.config.ContentCalendarProperties;
import dev.mayhm.contentcalendar.model.Content;
import dev.mayhm.contentcalendar.model.Status;
import dev.mayhm.contentcalendar.model.Type;
import dev.mayhm.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableConfigurationProperties(ContentCalendarProperties.class)
public class ContentCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCalendarApplication.class, args);
	}
}
