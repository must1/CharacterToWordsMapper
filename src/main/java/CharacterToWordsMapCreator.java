import java.util.*;
import java.util.stream.IntStream;

class CharacterToWordsMapCreator {

    Map<Character, Set<String>> createMapWithCharacterToAccordingWords(String[] splitSentence) {

        Map<Character, Set<String>> characterWithAccordingWord = new TreeMap<>();
        for (String iteratedWord : splitSentence) {

            IntStream.range(0, iteratedWord.length())
                    .forEach(j -> characterWithAccordingWord
                            .computeIfAbsent(iteratedWord.charAt(j), k -> new TreeSet<>())
                            .add(iteratedWord));

        }
        return characterWithAccordingWord;
    }
}

