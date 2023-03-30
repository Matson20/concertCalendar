package hh.sof3as3.concertCalendar.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Vastaa taulua tietokannassa
public class Event {
    @Id // Luo Id-sarakkeen
    @GeneratedValue(strategy=GenerationType.AUTO) // Autogeneroi idt
    private Long id;
    private String title;
    // private Date date; // TODO: ENSIN YKSINKERTAINEN VERSIO
    private Double price;
    private String info;

    // constructors
    public Event() {
        super();
        this.title = null;
        this.price = 0.0;
        this.info = null;
    }

    public Event(String title, Double price, String info) {
        this.title = title;
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

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    // toString
    @Override
    public String toString() {
        return "Event [id=" + id + ", title=" + title + ", price=" + price + ", info=" + info + "]";
    }

    
}
