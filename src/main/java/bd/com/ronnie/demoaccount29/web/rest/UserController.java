package bd.com.ronnie.demoaccount29.web.rest;

import bd.com.ronnie.demoaccount29.domain.User;
import bd.com.ronnie.demoaccount29.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<User> findOne(@PathVariable Long id) {
        log.debug("REST request to get User : {}", id);
        User user = userService.findOne(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<User>> findAll(Pageable pageable) {
        log.debug("REST request to get a page of Users");
        Page<User> page = userService.findAll(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        log.debug("REST request to create an User : {}", user);
        if (user.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            User result = userService.save(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PutMapping(value = "")
    public ResponseEntity<User> udpate(@Valid @RequestBody User user) {
        log.debug("REST request to update an User : {}", user);
        if (user.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            User result = userService.save(user);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.debug("REST request to delete an User with ID : {}", id);
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
