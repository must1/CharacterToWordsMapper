package utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SentenceUtils {

    private static final String SENTENCE_TO_WORD_SEPARATOR = "\\s";
    private static final String PUNCTUATION_MARKS_REMOVER_REGEX_EXP = "\\p{P}";

    public String[] purifySentence(String sentence) {
        return erasePunctuationMarks(sentence)
                .toLowerCase()
                .split(SENTENCE_TO_WORD_SEPARATOR);
    }

    private String erasePunctuationMarks(String sentence) {
        return sentence.replaceAll(PUNCTUATION_MARKS_REMOVER_REGEX_EXP, "");
    }
}
