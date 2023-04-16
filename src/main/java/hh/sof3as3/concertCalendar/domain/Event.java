package hh.sof3as3.concertCalendar.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity // Vastaa taulua tietokannassa
@Table(name="event")
public class Event {
    @Id // Luo Id-sarakkeen
    @GeneratedValue(strategy=GenerationType.AUTO) // Autogeneroi idt
    private Long id;
    private String title;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDay; 
    private Double price;
    private String info;

    // ManyToMany 
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JsonIgnoreProperties("events")
    @JoinTable(
        name="events_genres",
        joinColumns = {
            @JoinColumn(name="id")
        },
        inverseJoinColumns = {
            @JoinColumn(name="genreid")
        }   
    )

    Set <Genre> genres = new HashSet<>();

    // Genre getters
    public Set<Genre> getGenres() {
        return genres;
    }

    // Genre setters
    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    // constructors
    public Event() {
        super();
        this.title = null;
        this.startDay = null;
        this.price = 0.0;
        this.info = null;
        this.genres = null;
    }

    public Event(String title, Date startDay, Double price, String info, Set<Genre> genres) {
        this.title = title;
        this.startDay = startDay;
        this.price = price;
        this.info = info;
        this.genres = genres;
    }

    public Event(String title, Date startDay, Double price, String info) {
        this.title = title;
        this.startDay = startDay;
        this.price = price;
        this.info = info;
    }

    // getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getStartDay() {
        return startDay;
    }

    // Metodi päivän formatoinnille
    public String getDateStr() {
        SimpleDateFormat edate = new SimpleDateFormat("dd.MM.yyyy");
        return edate.format(this.startDay);
    }

    public Double getPrice() {
        return price;
    }

    public String getInfo() {
        return info;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    // Metodin genren lisäykseen
    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    // toString
    @Override
    public String toString() {
        return "Event [id=" + id + ", title=" + title + ", day=" + startDay + ", price=" + price + ", info=" + info + "]";
    }

    
}
