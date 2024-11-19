import java.io.*;

/**
 * Title: Word Comparator
 *
 * Description: This program reads a list of words from a file and calculates their
 * value based on predefined letter values. It then sorts the words from
 * lowest to highest value and outputs them in a comma-separated format.
 */
public class WordComparator {
    /**
     * This method calculates the value of a word.
     * Each letter in the word is assigned a predefined score, and the total value is returned.
     *
     * @param word the word for which the Scrabble value is calculated
     * @return the total Scrabble score of the word
     */
    public static int calculateScrabbleValue(String word) {
        int value = 0;

        // Loop through each character in the word and add the appropriate score
        for (char letter : word.toUpperCase().toCharArray()) {
            switch (letter) {
                case 'A': case 'E': case 'I': case 'O': case 'U':
                case 'L': case 'N': case 'S': case 'T': case 'R':
                    value += 1;
                    break;
                case 'D': case 'G':
                    value += 2;
                    break;
                case 'B': case 'C': case 'M': case 'P':
                    value += 3;
                    break;
                case 'F': case 'H': case 'V': case 'W': case 'Y':
                    value += 4;
                    break;
                case 'K':
                    value += 5;
                    break;
                case 'J': case 'X':
                    value += 8;
                    break;
                case 'Q': case 'Z':
                    value += 10;
                    break;
                default:
                    value += 0; // Ignore other characters
            }
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        // Fixed-size array to hold up to 100 words
        String[] words = new String[100];
        int wordCount = 0;

        // Read the file wordlist.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("./src/wordlist.txt"))) {
            String word;
            while ((word = reader.readLine()) != null) {
                words[wordCount] = word;
                wordCount++;
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Resize the array to the exact number of words read
        String[] actualWords = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            actualWords[i] = words[i];
        }

        // Sort the words based on their Scrabble value using bubble sort
        for (int i = 0; i < actualWords.length - 1; i++) {
            for (int j = i + 1; j < actualWords.length; j++) {
                int score1 = calculateScrabbleValue(actualWords[i]);
                int score2 = calculateScrabbleValue(actualWords[j]);
                if (score1 > score2) {
                    // Swap the words based on their Scrabble value
                    String temp = actualWords[i];
                    actualWords[i] = actualWords[j];
                    actualWords[j] = temp;
                }
            }
        }

        // Output the sorted list of words in a comma-separated format
        for (int i = 0; i < actualWords.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(actualWords[i]);
        }
        System.out.println();
    }
}
