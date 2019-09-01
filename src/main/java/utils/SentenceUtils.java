package utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SentenceUtils {

    private static final String SPLITTER_REGEX_EXP = "\\s";
    private static final String PUNCTUATION_MARKS_REMOVER_REGEX_EXP = "\\p{P}";

    public String[] getSplitPurifiedLowerCaseSentence(String sentence) {
        return erasePunctuationMarks(sentence).toLowerCase().split(SPLITTER_REGEX_EXP);
    }

    public String erasePunctuationMarks(String sentence) {
        return sentence.replaceAll(PUNCTUATION_MARKS_REMOVER_REGEX_EXP, "");
    }
}
