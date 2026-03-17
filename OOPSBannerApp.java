import java.util.HashMap;

/**
 * OOPSBannerApp UC8 Use Map for Character Patterns and Render via Function
 *
 * This use case extends UC7 by utilizing advanced Object-Oriented Programming concepts
 * such as the Collections Framework to manage character patterns in a more flexible
 * and efficient manner. The application retrieves and displays the "OOPS" banner
 * using a HashMap thereby enhancing code organization and modularity.
 *
 * @author Developer
 * @version 8.0
 */
public class OOPSBannerApp {

    /**
     * Creates a HashMap containing ASCII art patterns for supported characters.
     * @return a HashMap where keys are characters (char) and values are String arrays
     */
    public static HashMap<Character, String[]> createCharacterMap() {
        HashMap<Character, String[]> charMap = new HashMap<>();
        
        // Populate charMap with perfectly padded 9-character patterns
        charMap.put('O', new String[] {
            "  ***** ", " ** ** ", " ** ** ", " ** ** ", " ** ** ", " ** ** ", "  ***** "
        });
        charMap.put('P', new String[] {
            " ******* ", " ** ** ", " ** ** ", " ******* ", " ** ", " ** ", " ** "
        });
        charMap.put('S', new String[] {
            "  ***** ", " ** ** ", " ** ", "  ***** ", "      ** ", " ** ** ", "  ***** "
        });
        charMap.put(' ', new String[] {
            "         ", "         ", "         ", "         ", "         ", "         ", "         "
        });

        return charMap;
    }

    /**
     * Displays a banner message using the provided character map.
     * @param message the String message to display as a banner.
     * @param charMap a HashMap containing character patterns.
     */
    public static void displayBanner(String message, HashMap<Character, String[]> charMap) {
        // Getting pattern height. Assuming all patterns have the same height.
        int patternHeight = charMap.get('O').length; 

        // Loop through each line of the pattern height and build the banner line by line
        for (int line = 0; line < patternHeight; line++) {
            StringBuilder sb = new StringBuilder();
            
            for (char ch : message.toCharArray()) {
                // Fetch the pattern array for the current letter from the HashMap
                // If the letter isn't in the map, default to a space so the app doesn't crash
                String[] pattern = charMap.getOrDefault(ch, charMap.get(' ')); 
                sb.append(pattern[line]); 
            }
            
            System.out.println(sb.toString());
        }
    }

    /**
     * Main entry point of the application.
     */
    public static void main(String[] args) {
        // Initialize the HashMap
        HashMap<Character, String[]> charMap = createCharacterMap();

        // Define the message
        String message = "OOPS";

        // Display it
        displayBanner(message, charMap);
    }
}