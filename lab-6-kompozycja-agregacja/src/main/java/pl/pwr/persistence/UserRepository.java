package pl.pwr.persistence;

import pl.pwr.user.User;

public interface UserRepository {

    void persist(User user);

    void remove(String username);


}
