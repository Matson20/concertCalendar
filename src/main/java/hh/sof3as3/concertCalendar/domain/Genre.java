package hh.sof3as3.concertCalendar.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long genreid;
    private String name;

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
