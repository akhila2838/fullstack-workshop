package registration;

import java.util.List;

public class UserController {

    private UserService service = new UserService();

    public Result register(String name, String email, String password, int age) {

        User user = new User(name, email, password, age);
        List<String> errors = user.validate();

        if (!errors.isEmpty()) {
            return Result.failure(errors);
        }

        try {
            service.register(user);
            return Result.success("User registered successfully");

        } catch (DuplicateUserException e) {
            return Result.failure(List.of(e.getMessage()));
        } catch (ValidationException e) {
            return Result.failure(List.of(e.getMessage()));
        }
    }
}