
package registration;

import java.util.HashSet;
import java.util.Set;

public class UserService {

    private static final Set<String> EMAIL_DB = new HashSet<>();

    public void register(User user) throws ValidationException {

        if (EMAIL_DB.contains(user.getEmail())) {
            throw new DuplicateUserException("Email already registered");
        }

        EMAIL_DB.add(user.getEmail());
    }

    public void findByEmail(String email) throws DatabaseException {
        try {
            if (!EMAIL_DB.contains(email)) {
                throw new DatabaseException("User not found in DB");
            }
        } catch (Exception e) {
            throw new DatabaseException("Database error");
        }
    }
}
