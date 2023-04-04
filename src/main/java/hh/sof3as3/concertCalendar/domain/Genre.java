package hh.sof3as3.concertCalendar.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long genreid;
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = { CascadeType.MERGE })
    private Set<Event> events = new HashSet<>();

    // Event getters
    public Set<Event> getEvents() {
        return events;
    }

    // Event setters
    public void setEvents(Set<Event> events) {
        this.events = events;
    }


    // Constructors
    public Genre() {
        
    }

    public Genre(String name) {
        super();
        this.name = name;
    }

    // getters
    public Long getGenreid() {
        return genreid;
    }

    public String getName() {
        return name;
    }

    // setters
    public void setGenreid(Long genreid) {
        this.genreid = genreid;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString
    @Override
    public String toString() {
        return "Genre [genreid=" + genreid + ", name=" + name + "]";
    }

    
    

}
