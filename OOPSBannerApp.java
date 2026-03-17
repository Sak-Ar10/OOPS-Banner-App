/**
 * OOPSBannerApp UC7 Store Character Pattern in a Class
 *
 * This use case extends UC6 by implementing a CharacterPatternMap class to encapsulate
 * character-to-pattern mappings. The application retrieves and displays the "OOPS"
 * banner using these mappings. This approach enhances code organization and modularity.
 *
 * @author Developer
 * @version 7.0
 */
public class OOPSBannerApp {

    /**
     * CharacterPatternMap
     * Inner class for storing character-to-pattern mappings.
     * Encapsulates a single character and its corresponding ASCII art pattern.
     * Provides immutable access to character and pattern data through getters.
     */
    static class CharacterPatternMap {
        /** The character being represented */
        private Character character;
        /** The ASCII art pattern lines for the character */
        private String[] pattern;

        /**
         * Constructs a CharacterPatternMap with a character and its pattern
         * @param character the character to be mapped
         * @param pattern the ASCII art pattern representation as array of strings
         */
        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        /**
         * Retrieves the mapped character
         * @return the character associated with this pattern map
         */
        public Character getCharacter() {
            return this.character;
        }

        /**
         * Retrieves the ASCII art pattern
         * @return the pattern array representing the character
         */
        public String[] getPattern() {
            return this.pattern;
        }
    }

    /**
     * Static Method to Create and initializes CharacterPatternMap array for predefined characters
     * Populates pattern maps for letters 'O', 'P', 'S' and space character.
     * Each character has a 7-line ASCII art representation.
     *
     * @return array of CharacterPatternMap objects containing character patterns
     */
    public static CharacterPatternMap[] createCharacterPatternMaps() {
        return new CharacterPatternMap[] {
            new CharacterPatternMap('O', new String[] {
                "  ***** ", " ** ** ", " ** ** ", " ** ** ", " ** ** ", " ** ** ", "  ***** "
            }),
            new CharacterPatternMap('P', new String[] {
                " ******* ", " ** ** ", " ** ** ", " ******* ", " ** ", " ** ", " ** "
            }),
            new CharacterPatternMap('S', new String[] {
                "  ***** ", " ** ** ", " ** ", "  ***** ", "      ** ", " ** ** ", "  ***** "
            }),
            new CharacterPatternMap(' ', new String[] {
                "         ", "         ", "         ", "         ", "         ", "         ", "         "
            })
        };
    }

    /**
     * Retrieves the ASCII pattern for a given character
     * Searches through the character pattern maps to find a matching character.
     * If the character is not found, recursively returns the pattern for space character.
     *
     * @param ch the character to look up
     * @param charMaps the array of CharacterPatternMap objects to search through
     * @return the pattern array for the given character, or space pattern if not found
     */
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {
        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter().equals(ch)) {
                return map.getPattern();
            }
        }
        // If character isn't mapped, return the blank space pattern
        return getCharacterPattern(' ', charMaps);
    }

    /**
     * Prints a message as a banner using ASCII art patterns
     * Renders the entire message horizontally by combining individual character
     * patterns line by line. Characters are separated by spacing for readability.
     *
     * @param message the message string to be displayed as a banner
     * @param charMaps the array of CharacterPatternMap objects containing available patterns
     */
    public static void printMessage(String message, CharacterPatternMap[] charMaps) {
        // We know our patterns are 7 lines tall, so we loop 7 times for the rows
        for (int i = 0; i < 7; i++) {
            // StringBuilder is used here for highly efficient string concatenation
            StringBuilder lineBuilder = new StringBuilder();
            
            // Loop through every letter in the requested message
            for (char ch : message.toCharArray()) {
                String[] pattern = getCharacterPattern(ch, charMaps);
                lineBuilder.append(pattern[i]);
            }
            // Print the completed row
            System.out.println(lineBuilder.toString());
        }
    }

    /**
     * Main method Entry point for the banner display application
     * Initializes the character pattern maps and displays "OOPS" as an ASCII art banner.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create CharacterPatternMap array
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();

        // Define the message to be displayed
        String message = "OOPS";

        // Print the banner message
        printMessage(message, charMaps);
    }
}