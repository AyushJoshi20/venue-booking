package venueBookingexample.venBook.Booking;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import venueBookingexample.venBook.User.User;
import venueBookingexample.venBook.User.UserRepository;
import venueBookingexample.venBook.Venue.Venue;
import venueBookingexample.venBook.Venue.VenueRepository;

@Service
public class BookingServiceImpl implements BookingService{

   private final BookingRepository bookingRepository;
   private final UserRepository userRepository;
   private final VenueRepository venueRepository;
   private final JavaMailSender mailSender;

    public BookingServiceImpl(BookingRepository bookingRepository, UserRepository userRepository, VenueRepository venueRepository, JavaMailSender mailSender) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.venueRepository = venueRepository;
        this.mailSender = mailSender;
    }

    @Override
    public Booking createBooking(Booking booking) {
        Long userId = booking.getUser().getId();
        Long venueId = booking.getVenue().getId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new RuntimeException("Venue not found"));

        booking.setUser(user);
        booking.setVenue(venue);

        Booking saved = bookingRepository.save(booking);

        sendBookingConfirmationEmail(user.getEmail(), venue.getName());
        return saved;
    }

    private void sendBookingConfirmationEmail(String to, String venueName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Booking Confirmation");
        message.setText("Your booking for venue '" + venueName + "' is confirmed.");
        mailSender.send(message);
    }
}
