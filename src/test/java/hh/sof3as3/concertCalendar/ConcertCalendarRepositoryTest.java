package hh.sof3as3.concertCalendar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.concertCalendar.domain.Event;
import hh.sof3as3.concertCalendar.domain.EventRepository;
import hh.sof3as3.concertCalendar.domain.Genre;
import hh.sof3as3.concertCalendar.domain.GenreRepository;
import hh.sof3as3.concertCalendar.domain.User;
import hh.sof3as3.concertCalendar.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ConcertCalendarRepositoryTest {
    
    @Autowired
    private EventRepository eventrepository;

    @Autowired
    private UserRepository userrepository;

    @Autowired
    private GenreRepository genrerepository;

    // Find event
    @Test
    public void findByTitle() {
        List<Event> events = eventrepository.findByTitle("JamNight");
        assertThat(events).hasSize(1);
        assertThat(events.get(0).getTitle()).isEqualTo("JamNight");
    }

    // testing UserRepo to search admin
    @Test 
    public void findByUserName() {
        User user = userrepository.findByUsername("admin");
        assertThat(user.getUsername()).isEqualTo("admin");
    }

    // Create a new genre
    @Test
    public void createNewGenre() {
        Genre genre1 = new Genre("Folk");
        genrerepository.save(genre1);
        assertThat(genre1.getGenreid()).isNotNull();
    }

    // Delete event
    @Test
    public void deleteEvent() {
        Event event1 = new Event("MetalNight", 17.50, "It's gonna be LOUD!");
        eventrepository.save(event1);
        eventrepository.deleteById(event1.getId());
        assertThat(eventrepository.count()).isEqualTo(2);
    }

    //TODO 
    // Lisää testauksia
}
