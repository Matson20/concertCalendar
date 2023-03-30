package hh.sof3as3.concertCalendar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof3as3.concertCalendar.domain.Genre;
import hh.sof3as3.concertCalendar.domain.GenreRepository;

@Controller
public class GenreController {
    // TODO
    // show OK
    // add
    // save
    // delete

    @Autowired
    private GenreRepository genrerepository;

    // List all the genres
    @GetMapping("/genrelist")
    public String getGenres(Model model) {
            model.addAttribute("genres", genrerepository.findAll());
            return "genrelist"; // .html
        }

    // Add a new genre
    @RequestMapping(value="/addgenre")
    public String addGenre(Model model) {
        model.addAttribute("genre", new Genre()); //"Genre", single. NOT blurar!
        return "addgenre"; // .html
    }

    // Save a new genre
    @PostMapping("/savegenre")
    private String saveGenre(Genre genre) {
        genrerepository.save(genre);
        return ("redirect:genrelist");
    }

}
