package football;

import java.util.Scanner;
import java.util.regex.Pattern;
/**
 * The Validation class implements an application that handle the inputs which taken from user.
 */
public class Validation {
    private static final Scanner scanner = new Scanner(System.in);
    /**
     * This method checks if the password is strong or not.
     * @param password This is password which will be checked.
     * @return boolean This returns if the password is strong or not.
     */
    public static boolean invalidPassword(String password) {
        boolean isValid = false;
        if (password != null) {
            final String MIN_LENGTH = "8";
            final String MAX_LENGTH = "20";
            final boolean SPECIAL_CHAR_NEEDED = true;
            final String ONE_DIGIT = "(?=.*[0-9])";
            final String LOWER_CASE = "(?=.*[a-z])";
            final String UPPER_CASE = "(?=.*[A-Z])";
            final String NO_SPACE = "(?=\\S+$)";
            final String MIN_MAX_CHAR = ".{" + MIN_LENGTH + "," + MAX_LENGTH + "}";
            final String SPECIAL_CHAR;
            if (SPECIAL_CHAR_NEEDED == true) SPECIAL_CHAR = "(?=.*[@#$%^&+=])";
            else SPECIAL_CHAR = "";
            final String PATTERN = ONE_DIGIT + LOWER_CASE + UPPER_CASE + SPECIAL_CHAR + NO_SPACE + MIN_MAX_CHAR;
            isValid = password.matches(PATTERN);
        }
        return isValid;
    }
    /**
     * This method checks if the email is valid or not.
     * @param email This is email which will be checked.
     * @return boolean This returns if the email is valid or not.
     */
    public static boolean invalidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    /**
     *This method is used to check if input
     * Integer or not.
     * @return int This is integer number.
     */
    public static int getIntFromUser(){
        do {
            String input = scanner.nextLine();
            try{
                return Integer.parseInt(input);
            } catch(Exception e) {
                System.out.println("Please enter valid number");
            }
        }while (true);
    }
    /**
     * This method is used to check if input
     * Integer or not but there limit to begin
     * and limit to end.
     * @param from this is the first parameter to getIntFromUser method.
     * @param to this is the second parameter to getIntFromUser method.
     * @return int This is integer with limit.
     */
    public static int getIntFromUser(int from, int to){
        do {
            String input = scanner.nextLine();
            try{
                int num = Integer.parseInt(input);
                if(Integer.parseInt(input) >= from && Integer.parseInt(input) <= to){
                    return num;
                }else{
                    System.out.println("Please enter valid choice");
                }
            } catch(Exception e) {
                System.out.println("Please enter valid number");
            }
        }while (true);
    }
    /**
     * This method is used to check if input
     * double or not.
     * @return double this returns input that user enter.
     */
    public static double getDoubleFromUser(){
        do {
            String input = scanner.nextLine();
            try{
                return Double.parseDouble(input);
            } catch(Exception e) {
                System.out.println("Please enter valid number");
            }
        }while(true);
    }
    /**
     * This method is used to check if input
     * string or not.
     * @return String this returns input that user enter.
     */
    public static String getStringFromUser() {
        do {
            String input = scanner.nextLine();
            if (input == null || input.isEmpty()) {
                System.out.println("Please enter valid string");
            } else {
                return input;
            }
        } while (true);
    }
    /**
     * This method is used to check if input
     * string or not and accept only numbers.
     *@return String this input that user enter.
     */
    public static String getStringNumFromUser(){
        do {
            String input = scanner.nextLine();
            if(input == null || input.isEmpty()){
                System.out.println("Please enter valid string");
            }
            else if(!input.matches("[0-9]+")){
                System.out.println("Please enter valid string");
            }
            else{
                return input;
            }
        }while (true);
    }
    /**
     * This method is used to check if input
     * string or not and accept only alphabet and spaces.
     *@return String this input that user enter.
     */
    public static String getStringAlphaFromUser(){
        do {
            String input = scanner.nextLine();
            if(input == null || input.isEmpty()){
                System.out.println("Please enter valid string");
            }
            else if(!input.matches("[a-zA-Z' ']+")){
                System.out.println("Please enter valid string");
            }
            else{
                return input;
            }
        }while (true);
    }
}