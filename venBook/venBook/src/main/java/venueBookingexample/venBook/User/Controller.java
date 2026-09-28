package venueBookingexample.venBook.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    UserService userService;

    public Controller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
        try {
            userService.register(user);
            return new ResponseEntity<>(Map.of("message", "User registered successfully"), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

/*
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
        User foundUser = userService.login(user.getEmail(), user.getPassword());
        if (foundUser != null) {
            return new ResponseEntity<>(Map.of("message","Login Successfull"),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("message","Invalid Credentials"),HttpStatus.BAD_REQUEST);
        }
    }
*/
@PostMapping("/login")
public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
    User foundUser = userService.login(user.getEmail(), user.getPassword());
    if (foundUser != null) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login Successful");
        Map<String, Object> userData = new HashMap<>();
        userData.put("id", foundUser.getId());
        userData.put("email", foundUser.getEmail());
        response.put("user", userData);

        return new ResponseEntity<>(response, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(Map.of("message", "Invalid Credentials"), HttpStatus.BAD_REQUEST);
    }
  }
}
