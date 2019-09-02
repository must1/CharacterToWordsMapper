import java.util.*;
import java.util.stream.IntStream;

class CharacterToWordsMapper {

    Map<Character, Set<String>> createMapWithCharacterToAccordingWords(String[] splitSentence) {

        Map<Character, Set<String>> characterWithAccordingWord = new TreeMap<>();

        Arrays.stream(splitSentence)
                .forEach(word -> IntStream.range(0, word.length())
                        .forEach(j -> characterWithAccordingWord
                                .computeIfAbsent(word.charAt(j), k -> new TreeSet<>())
                                .add(word)));

        return characterWithAccordingWord;
    }
}

