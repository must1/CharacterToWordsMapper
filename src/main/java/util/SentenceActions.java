package util;

public class SentenceActions {

    public static String getPurifiedLowerCaseSentence(String sentence) {
        return sentence.replaceAll("\\p{P}", "").toLowerCase();
    }
}
