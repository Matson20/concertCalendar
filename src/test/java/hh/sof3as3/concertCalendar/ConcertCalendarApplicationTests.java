package hh.sof3as3.concertCalendar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3as3.concertCalendar.web.EventController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ConcertCalendarApplicationTests {

	@Autowired
	private EventController eventcontroller;

	// SmokeTesting
	@Test
	void contextLoads() throws Exception {
		assertThat(eventcontroller).isNotNull();
	}

}
