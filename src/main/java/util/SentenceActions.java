package util;

import java.util.Set;
import java.util.stream.Collectors;

public class SentenceActions {

    public static String getPurifiedLowerCaseSentence(String sentence) {
        return sentence.replaceAll("\\p{P}", "").toLowerCase();
    }

    public static Set<Character> getEveryCharacterOccurringInSentence(String sentence) {
        return sentence.chars()
                .mapToObj(e -> (char) e).collect(Collectors.toSet());
    }
}
