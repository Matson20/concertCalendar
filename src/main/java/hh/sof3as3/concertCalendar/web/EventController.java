package hh.sof3as3.concertCalendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof3as3.concertCalendar.domain.Event;
import hh.sof3as3.concertCalendar.domain.EventRepository;
import hh.sof3as3.concertCalendar.domain.GenreRepository;

@Controller
public class EventController {


    @Autowired
    private EventRepository eventrepository;
    @Autowired
    private GenreRepository genrerepository;
    
    // List all the event
    @GetMapping(value="/eventlist")
    public String getEvents(Model model) {
        model.addAttribute("events", eventrepository.findAll());
        return "eventlist"; //eventlist.html
    }

    // Add a new event
    @RequestMapping("/addevent")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addEvent(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("genres", genrerepository.findAll());
        return "addevent"; // .html
    }

    // Save new event
    @PostMapping("/saveevent")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveEvent(Event event) {
        eventrepository.save(event);
        return "redirect:eventlist";
    }

    // Delete event
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteEvent(@PathVariable("id") Long eventid, Model model) {
        eventrepository.deleteById(eventid);
        return "redirect:../eventlist";
    }

    // Edit event
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public String editEvent(@PathVariable("id") Long eventid, Model model) {
        model.addAttribute("event", eventrepository.findById(eventid));
        model.addAttribute("genres", genrerepository.findAll());
        return "editevent";
    }

    /* SIIRRETTY KOMMENNTEIHIN TIETOTURVASYISTÄ!!
    // RESTful services //
    // REST Get all the events
    @GetMapping(value="/events")
    public @ResponseBody List<Event> getEvents() {
        return (List<Event>) eventrepository.findAll();
    }

    // REST find events by ID
    @GetMapping(value="/events/{id}")
    public @ResponseBody Optional<Event> findEventREST(@PathVariable("id") Long eventId) {
        return eventrepository.findById(eventId);
    }

    // REST add events
    @PostMapping(value="/events")
    public @ResponseBody Event addNewEvent(@RequestBody Event event) {
        return eventrepository.save(event);
    }
    */

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
