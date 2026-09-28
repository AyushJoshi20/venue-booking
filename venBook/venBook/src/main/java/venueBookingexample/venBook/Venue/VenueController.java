package venueBookingexample.venBook.Venue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class VenueController {
    final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping("/venues")
    public ResponseEntity<List<Venue>> findall(){
        return new ResponseEntity<>(venueService.findall(), HttpStatus.OK);
    }

    @PostMapping("/add/venues")
    public ResponseEntity<Map<String,String>> addVenues(@RequestBody Venue venue){
        try{
            venueService.addVenues(venue);
            return new ResponseEntity<>(Map.of("message","Venue Added"),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
