package venueBookingexample.venBook;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import venueBookingexample.venBook.Venue.Venue;
import venueBookingexample.venBook.Venue.VenueRepository;

import java.util.List;

@Component
public class VenueDataLoader implements CommandLineRunner {
    private final VenueRepository venueRepository;

    public VenueDataLoader(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        updateImage(1L, "http://localhost:8080/images/venues/venue1.jpg");
        updateImage(2L, "http://localhost:8080/images/venues/venue2.jpg");
        updateImage(3L, "http://localhost:8080/images/venues/venue3.jpg");
        updateImage(4L, "http://localhost:8080/images/venues/venue4.jpg");
        updateImage(5L, "http://localhost:8080/images/venues/venue5.jpg");
        updateImage(6L, "http://localhost:8080/images/venues/venue6.jpg");
    }

    private void updateImage(Long id, String imageUrl) {
        venueRepository.findById(id).ifPresent(venue -> {
            venue.setImageUrl(imageUrl);
            venueRepository.save(venue);
        });
    }
}
