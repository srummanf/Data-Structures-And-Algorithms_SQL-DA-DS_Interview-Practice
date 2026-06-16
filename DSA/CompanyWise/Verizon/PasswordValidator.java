import java.util.regex.Pattern;

public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        // Check for length between 8 and 20 characters
        if (password.length() < 8 || password.length() > 20) {
            return false;
        }

        // Regular expressions to check password constraints
        String digitRegex = ".*\\d.*";       // At least one digit
        String lowerCaseRegex = ".*[a-z].*"; // At least one lowercase letter
        String upperCaseRegex = ".*[A-Z].*"; // At least one uppercase letter
        String specialCharRegex = ".*[!@#$%^&*(),.?\":{}|<>].*"; // At least one special character

        // Validate all the conditions
        boolean hasDigit = Pattern.matches(digitRegex, password);
        boolean hasLowerCase = Pattern.matches(lowerCaseRegex, password);
        boolean hasUpperCase = Pattern.matches(upperCaseRegex, password);
        boolean hasSpecialChar = Pattern.matches(specialCharRegex, password);

        // Return true only if all conditions are satisfied
        return hasDigit && hasLowerCase && hasUpperCase && hasSpecialChar;
    }

    public static void main(String[] args) {
        String password = "Passw0rd!";
        if (isValidPassword(password)) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
    }
}
