package hh.sof3as3.concertCalendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof3as3.concertCalendar.domain.EventRepository;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventrepository;
    
    @RequestMapping(value="/eventlist")
    public String getEvents(Model model) {
        model.addAttribute("events", eventrepository.findAll());
        return "eventlist"; //eventlist.html
    }

}
