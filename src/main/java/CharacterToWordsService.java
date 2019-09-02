import historysystem.ResultService;
import utils.SentenceUtils;
import view.ApplicationMessages;

import java.util.*;

class CharacterToWordsService {

    private static final String FILE_PATH = "Result.txt";

    private final ResultService historySystem;
    private final CharacterToWordsMapper wordContainingLetterMapCreator;
    private final ApplicationMessages applicationMessages;
    private Scanner scanner;

    CharacterToWordsService(ResultService historySystem, ApplicationMessages applicationMessages,
                            CharacterToWordsMapper wordContainingLetterMapCreator) {
        this.historySystem = historySystem;
        this.applicationMessages = applicationMessages;
        this.wordContainingLetterMapCreator = wordContainingLetterMapCreator;
        scanner = new Scanner(System.in);
    }

    void executeEngine() {
        String userInput = getUserInput();

        String[] splitPurifiedLowerCaseSentence = SentenceUtils.purifySentence(userInput);
        Map<Character, Set<String>> characterWithAccordingWord =
                wordContainingLetterMapCreator.createMapWithCharacterToAccordingWords(splitPurifiedLowerCaseSentence);

        historySystem.saveResult(FILE_PATH, characterWithAccordingWord, userInput);
        applicationMessages.displayResult(characterWithAccordingWord);
    }

    private String getUserInput() {
        applicationMessages.askAboutInput();
        return scanner.nextLine();
    }
}
