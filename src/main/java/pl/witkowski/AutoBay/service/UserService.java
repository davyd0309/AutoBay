package pl.witkowski.AutoBay.service;

import pl.witkowski.AutoBay.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
