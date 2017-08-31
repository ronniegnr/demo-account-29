package bd.com.ronnie.demoaccount29.service;

import bd.com.ronnie.demoaccount29.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User findOne(Long id);

    Page<User> findAll(Pageable pageable);

    User save(User user);

    void delete(Long id);

}
