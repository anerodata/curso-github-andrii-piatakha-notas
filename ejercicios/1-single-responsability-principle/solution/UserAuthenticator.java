public class UserAuthenticator {
    public static boolean authenticateUser(String username, String password) {
        UserValidator userValidator = new UserValidator();
         // Validate username and password
        if (userValidator.validateUsername(username) && userValidator.validatePassword(password)) {
            // Authenticate user
            return true;
        }
        return false;
    }
}
