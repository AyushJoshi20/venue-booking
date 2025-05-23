package venueBookingexample.venBook.User;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public void register(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new IllegalArgumentException("Email Already exists");
        }
        userRepository.save(user);
    }
}
