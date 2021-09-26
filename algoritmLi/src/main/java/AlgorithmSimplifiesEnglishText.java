import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class AlgorithmSimplifiesEnglishText {

    /**
     * 1) Remove "c" from the text
     * If the text contains “ci” and “ce”, change it to “si” and “se”.
     * If “ck” then change it to “k”.
     * In the other case replace “c” with “k”.
     * All the changes should be made in a strong order left-to-right.
     * For example:
     * The word “success” first of all will be the word “sukcess”. Then “suksess”.
     */
    private String removeLetterC(String text) {
        return text.replace("ci", "si")
                .replace("ce", "se")
                .replace("ck", "k")
                .replace("c", "k");
    }

    /**
     * 2) Remove a double letter
     * If the text contains “ee” then replace it by simple “i”.
     * If “oo” then change it by “u”.
     * In the other case any double letter should be changed by one letter.
     * For example:
     * “ooo” will be “uo”
     * “oou” will be “u”
     * “iee” will be “i”
     */
    private String removeDoubleLetter(String text) {
        String result = text.replace("oo", "u").replace("ee", "i");
        char[] newText = result.toCharArray();

        for (int i = 0; i < newText.length - 1; i++) {

            if (newText[i] == newText[i + 1]) {

                newText[i] = '$';
            }

            result = new String(newText).replace("$", "");
        }
        return result;
    }

    /**
     * 3) Remove the letter “e” at the end of each word
     * Remove the letter “e” at the end of each word if the word length > 1.
     * For example:
     * “The” will be “Th”.
     */
    private String removeLetterE(String text) {
        List<String> items = Arrays.stream(text.split(" "))
                .collect(Collectors.toList());
        List<String> newCollection = new ArrayList<>();

        for (String item : items) {
            if (item.endsWith("e") && item.length() > 1) {
                newCollection.add(item.substring(0, item.length() - 1));
            } else {
                newCollection.add(item);
            }
        }

        String result = newCollection.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(" "));

        return result;
    }

    /**
     * 4) Remove articles
     * Remove the articles “a”, “an” or “the” from the text. They should be removed only if they were the words a, an, the in the original text.
     * For example:
     * Input text: “the table”. After the first three steps it will be changed to “th tabl”. After the fourth step: “tabl”
     */
    private String removeArticles(String text) {

        return text.replaceAll("(?:(th |a |an |Th |A |An | th| a| an))", "");
    }

    /**
     * Call 4 steps to simplifies English text
     * @param text
     */
    void callAlgorithm(String text) {

        System.out.println("Input Text: " + text);
        String step = removeLetterC(text);
        System.out.println("Remove Letter C: " + step);
        step = removeDoubleLetter(step);
        System.out.println("Remove Double Letter: " + step);
        step = removeLetterE(step);
        System.out.println("Remove Letter E: " + step);
        step = removeArticles(step);
        System.out.println("Output Text: " + step);
    }
}