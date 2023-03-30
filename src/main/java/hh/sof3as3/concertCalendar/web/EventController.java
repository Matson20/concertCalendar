package hh.sof3as3.concertCalendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof3as3.concertCalendar.domain.Event;
import hh.sof3as3.concertCalendar.domain.EventRepository;

@Controller
public class EventController {
    // TODO
    // list OK
    // add OK
    // save OK
    // delete
    // edit
    // search

    @Autowired
    private EventRepository eventrepository;
    
    // List all the event
    @GetMapping(value="/eventlist")
    public String getEvents(Model model) {
        model.addAttribute("events", eventrepository.findAll());
        return "eventlist"; //eventlist.html
    }

    // Add a new event
    @RequestMapping("/addevent")
    public String addEvent(Model model) {
        model.addAttribute("event", new Event());
        return "addevent"; // .html
    }

    // Save new event
    @PostMapping("/saveevent")
    public String saveEvent(Event event) {
        eventrepository.save(event);
        return "redirect:eventlist";
    }

    // Delete event
    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable("id") Long eventid, Model model) {
        eventrepository.deleteById(eventid);
        return "redirect:booklist";
    }

    // Edit event
    @GetMapping("/edit/{id}")
    public String editEvent(@PathVariable("id") Long eventid, Model model) {
        model.addAttribute("event", eventrepository.findById(eventid));
        return "editevent";
    }

}
