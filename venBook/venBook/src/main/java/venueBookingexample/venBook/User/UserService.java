package venueBookingexample.venBook.User;

public interface UserService {

    User login(String email, String password);
    void register(User user);
}
