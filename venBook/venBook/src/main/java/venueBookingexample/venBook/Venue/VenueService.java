package venueBookingexample.venBook.Venue;

import java.util.List;

public interface VenueService {
    List<Venue> findall();
    void addVenues(Venue venue);
}
