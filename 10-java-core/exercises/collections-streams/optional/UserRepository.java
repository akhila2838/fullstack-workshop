
package Optional;


import java.util.*;

public class UserRepository {

    private Map<Long, User> users = new HashMap<>();

    public UserRepository() {
        users.put(1L, new User(
                1L,
                "john@example.com",
                "Michael",
                new Address("A-101")
        ));
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public Optional<User> findByEmail(String email) {
        return users.values().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
}
