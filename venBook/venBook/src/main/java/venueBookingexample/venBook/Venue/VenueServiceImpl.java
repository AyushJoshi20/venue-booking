package venueBookingexample.venBook.Venue;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService{

    final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venue> findall() {
       return venueRepository.findAll();
    }

    @Override
    public void addVenues(Venue venue) {
        venueRepository.save(venue);
    }
}
