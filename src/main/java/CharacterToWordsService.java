import historysystem.HistorySystem;
import utils.SentenceUtils;
import view.ApplicationMessages;

import java.util.*;

class CharacterToWordsService {

    private static final String FILE_PATH = "Result.txt";

    private final HistorySystem historySystem;
    private final CharacterToWordsMapCreator wordContainingLetterMapCreator;
    private final ApplicationMessages applicationMessages;
    private Scanner scanner;

    CharacterToWordsService(HistorySystem historySystem, ApplicationMessages applicationMessages,
                            CharacterToWordsMapCreator wordContainingLetterMapCreator) {
        this.historySystem = historySystem;
        this.applicationMessages = applicationMessages;
        this.wordContainingLetterMapCreator = wordContainingLetterMapCreator;
        scanner = new Scanner(System.in);
    }

    void executeEngine() {
        String userInput = getUserInput();

        String[] splitPurifiedLowerCaseSentence = SentenceUtils.getErasedFromPunctuationMarksSplitLowerCaseSentence(userInput);
        Map<Character, Set<String>> characterWithAccordingWord =
                wordContainingLetterMapCreator.createMapWithCharacterToAccordingWords(splitPurifiedLowerCaseSentence);

        historySystem.overwriteFileWithGivenResult(FILE_PATH, characterWithAccordingWord, userInput);
        applicationMessages.writeResult(characterWithAccordingWord);
    }

    private String getUserInput() {
        applicationMessages.askAboutInput();
        return scanner.nextLine();
    }
}
