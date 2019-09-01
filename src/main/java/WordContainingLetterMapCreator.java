import java.util.*;

class WordContainingLetterMapCreator {

    Map<Character, Set<String>> prepareCharacterWithAccordingWordsMap(String[] splittedSentence) {
        Map<Character, Set<String>> characterWithAccordingWord = new TreeMap<>();
        for (String iteratedWord : splittedSentence) {
            for (int j = 0; j < iteratedWord.length(); j++) {
                characterWithAccordingWord.computeIfAbsent(iteratedWord.charAt(j), k -> new TreeSet<>()).add(iteratedWord);
            }
        }
        return characterWithAccordingWord;
    }
}

