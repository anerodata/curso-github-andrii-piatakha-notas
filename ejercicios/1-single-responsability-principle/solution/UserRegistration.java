public class UserRegistration {
    public static boolean registerUser(String username, String password) {
        UserValidator userValidator = new UserValidator();
        if (userValidator.validateUsername(username) && userValidator.validatePassword(password)) {
            // Register user in the database
            return true;
        }
        return false;
    }
}
