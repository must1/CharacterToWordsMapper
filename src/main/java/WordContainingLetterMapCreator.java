import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class WordContainingLetterMapCreator {

    Map<Character, Set<String>> prepareCharacterWithAccordingWordsMap(Set<Character> characters, String[] splittedSentence) {
        Map<Character, Set<String>> characterWithAccordingWord = new LinkedHashMap<>();
        for (char iteratedCharacter : characters) {
            for (String iteratedWord : splittedSentence) {
                if (iteratedWord.indexOf(iteratedCharacter) >= 0) {
                    characterWithAccordingWord.computeIfAbsent(iteratedCharacter, k -> new TreeSet<>());
                    characterWithAccordingWord.get(iteratedCharacter).add(iteratedWord);
                }
            }
        }
        return characterWithAccordingWord;
    }
}
