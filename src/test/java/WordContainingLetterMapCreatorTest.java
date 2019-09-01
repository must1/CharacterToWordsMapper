import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import utils.SentenceUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class WordContainingLetterMapCreatorTest {


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"ala", "ma"}, "{a=[ala, ma], l=[ala], m=[ma]}"},
                {new String[]{"kon", "w", "dole"}, "{d=[dole], e=[dole], k=[kon], l=[dole], n=[kon], o=[dole, kon], w=[w]}"}
        });
    }

    private final WordContainingLetterMapCreator wordContainingLetterMapCreator;
    private final String[] givenWords;
    private final String expectedString;

    public WordContainingLetterMapCreatorTest(String[] givenWords, String expectedString) {
        this.wordContainingLetterMapCreator = new WordContainingLetterMapCreator();
        this.givenWords = givenWords;
        this.expectedString = expectedString;
    }

    @Test
    public void prepareCharacterWithAccordingMapOfWordsWithProperSentence() {
        Map<Character, Set<String>> map = wordContainingLetterMapCreator.prepareMapWithCharacterToAccordingWords(givenWords);
        assertEquals(expectedString, map.toString());
    }

    @Test
    public void prepareMapWithCharacterToAccordingWordsWithPunctuationMarks() {
        //given
        String sentence = ". / a";
        String[] splitPurifiedLowerCaseSentence = SentenceUtils.getSplitPurifiedLowerCaseSentence(sentence);
        String expectedToString = "{a=[a]}";
        //when
        Map<Character, Set<String>> map =
                wordContainingLetterMapCreator.prepareMapWithCharacterToAccordingWords(splitPurifiedLowerCaseSentence);
        //then
        assertEquals(expectedToString, map.toString());
    }
}