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
public class CharacterToWordsMapCreatorTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"ala", "ma"}, "{a=[ala, ma], l=[ala], m=[ma]}"},
                {new String[]{"kon", "w", "dole"}, "{d=[dole], e=[dole], k=[kon], l=[dole], n=[kon], o=[dole, kon], w=[w]}"},
                {new String[]{"jaes", "slo"}, "{a=[jaes], e=[jaes], j=[jaes], l=[slo], o=[slo], s=[jaes, slo]}"}
        });
    }

    private final CharacterToWordsMapCreator characterToWordsMapCreator;
    private final String[] givenWords;
    private final String expectedString;

    public CharacterToWordsMapCreatorTest(String[] givenWords, String expectedString) {
        this.characterToWordsMapCreator = new CharacterToWordsMapCreator();
        this.givenWords = givenWords;
        this.expectedString = expectedString;
    }

    @Test
    public void prepareCharacterWithAccordingMapOfWordsWithProperSentence() {
        Map<Character, Set<String>> map = characterToWordsMapCreator.createMapWithCharacterToAccordingWords(givenWords);
        assertEquals(expectedString, map.toString());
    }

    @Test
    public void prepareMapWithCharacterToAccordingWordsWithPunctuationMarks() {
        //given
        String sentence = ". / a";
        String expectedMapToString = "{a=[a]}";
        String[] splitPurifiedLowerCaseSentence = SentenceUtils.getErasedFromPunctuationMarksSplitLowerCaseSentence(sentence);
        //when
        Map<Character, Set<String>> map =
                characterToWordsMapCreator.createMapWithCharacterToAccordingWords(splitPurifiedLowerCaseSentence);
        //then
        assertEquals(expectedMapToString, map.toString());
    }
}