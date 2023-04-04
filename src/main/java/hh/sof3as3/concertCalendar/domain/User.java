package hh.sof3as3.concertCalendar.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;;

@Entity(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Atribuutit
    @Column(name="id", nullable=false, updatable=false)
    private Long id;

    @Column(name="username", nullable=false, unique=true)
    private String username;

    @Column(name="password", nullable=false)
    private String passwordHash;

    @Column(name="email", nullable=false)
    private String email;

    @Column(name="role", nullable=false)
    private String role;

    public User() {
    }

    public User(String username, String passwordHash, String email, String role) {
        super();
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", email=" + email
                + ", role=" + role + "]";
    }
}
