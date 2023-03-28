package hh.sof3as3.concertCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3as3.concertCalendar.domain.Event;
import hh.sof3as3.concertCalendar.domain.EventRepository;

@SpringBootApplication
public class ConcertCalendarApplication {

	private static final Logger log = LoggerFactory.getLogger(ConcertCalendarApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConcertCalendarApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EventRepository eventrepository) {
		return (args) -> {
			//Testidataa
			Event event1 = new Event("JamNight", 5.0, "Lava vapaa");
			Event event2 = new Event("Pop-ilta", 10.0, "Tervetuloa!");
			eventrepository.save(event1);
			eventrepository.save(event2);

			log.info("show all events");
			for (Event event : eventrepository.findAll()) {
				log.info(event.toString());
			}
		};
	}

}
