package hh.sof3as3.concertCalendar;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3as3.concertCalendar.domain.Event;
import hh.sof3as3.concertCalendar.domain.EventRepository;
import hh.sof3as3.concertCalendar.domain.Genre;
import hh.sof3as3.concertCalendar.domain.GenreRepository;
import hh.sof3as3.concertCalendar.domain.User;
import hh.sof3as3.concertCalendar.domain.UserRepository;

@SpringBootApplication
public class ConcertCalendarApplication {

	private static final Logger log = LoggerFactory.getLogger(ConcertCalendarApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConcertCalendarApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EventRepository eventrepository, GenreRepository genrerepository, UserRepository userrepository) {
		return (args) -> {
			//Testidataa
			/* 
			Event event1 = new Event("JamNight", 5.0, "Lava vapaa");
			Event event2 = new Event("Pop-ilta", 10.0, "Tervetuloa!");
			eventrepository.save(event1);
			eventrepository.save(event2);
			*/

			// Testidataa genre
			Genre genre1 = new Genre("Jazz");
			Genre genre2 = new Genre("Pop");
			
			Set <Genre> genres = new HashSet<Genre>();
			genres.add(genre1);
			genres.add(genre2);

			genrerepository.save(genre1);
			genrerepository.save(genre2);
			
			
			eventrepository.save(new Event("JamNight", 5.0, "Lava vaplaa",null ));
			eventrepository.save(new Event("Pop-ilta", 10.0, "Tervetuloa", genres));

			// Käyttäjien luonti
			User user1 = new User("user","$2a$10$emCwN96VXoqfKVEUHrbkSeFjqpUrqh.diPRTQuxHoVKNqStwHGXwO" ,"user@user.com" ,"USER");
			User user2 = new User("admin","$2a$10$spbK7EtDD5VHqkPT2pNpXugBKbum0WNij/QebZha8tkAowShbm4QS" ,"admin@admin.com" ,"ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);

			// Event logitus
			log.info("show all events");
			for (Event event : eventrepository.findAll()) {
				log.info(event.toString());
			}

			// Genre Logitus
			log.info("show all genres");
			for (Genre genre : genrerepository.findAll()) {
				log.info(genre.toString());
			}
		};
	}

}
