package venueBookingexample.venBook.Booking;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import venueBookingexample.venBook.User.User;
import venueBookingexample.venBook.Venue.Venue;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate localDate;
    private LocalTime localTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "venue_id", nullable = false)
    @JsonBackReference(value = "venue-bookings")
    private Venue venue;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference(value = "user-bookings")
    private User user;

    public Booking(Long id, LocalDate localDate, LocalTime localTime, Venue venue, User user) {
        this.id = id;
        this.localDate = localDate;
        this.localTime = localTime;
        this.venue = venue;
        this.user = user;
    }

    public Booking() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
