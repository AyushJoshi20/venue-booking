package venueBookingexample.venBook.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
    User findByEmail(String email);
}
