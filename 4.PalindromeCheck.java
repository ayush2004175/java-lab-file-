public class PalindromeCheck {

    public static void main(String[] args) {

        String str = "madonna";
        String reversed = "";

        // Reverse the string
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        // Check palindrome
        if (str.equalsIgnoreCase(reversed)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is NOT a palindrome.");
        }
    }
}
