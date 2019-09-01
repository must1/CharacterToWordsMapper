import org.junit.Test;
import util.SentenceActions;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class WordContainingLetterMapCreatorTest {

    private final WordContainingLetterMapCreator wordContainingLetterMapCreator = new WordContainingLetterMapCreator();

    @Test
    public void prepareCharacterWithAccordingWordsMapWithProperSentence() {
        String[] words = new String[]{"ala", "ma"};
        Map<Character, Set<String>> map = wordContainingLetterMapCreator.prepareCharacterWithAccordingWordsMap(words);
        String expectedToString = "{a=[ala, ma], l=[ala], m=[ma]}";

        assertEquals(expectedToString, map.toString());

        words = new String[]{"kon", "w", "dole"};
        map = wordContainingLetterMapCreator.prepareCharacterWithAccordingWordsMap(words);
        expectedToString = "{d=[dole], e=[dole], k=[kon], l=[dole], n=[kon], o=[dole, kon], w=[w]}";

        assertEquals(expectedToString, map.toString());
    }

    @Test
    public void prepareCharacterWithAccordingWordsMapWithPunctuationMarks() {
        String sentence = ". / a";
        String purifiedSentence = SentenceActions.getPurifiedLowerCaseSentence(sentence);
        Map<Character, Set<String>> map = wordContainingLetterMapCreator.prepareCharacterWithAccordingWordsMap(purifiedSentence.split("\\s"));
        String expectedToString = "{a=[a]}";

        assertEquals(expectedToString, map.toString());
    }
}