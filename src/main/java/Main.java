import historysystem.HistorySystem;
import historysystem.HistorySystemService;
import view.ApplicationMessages;
import view.ConsoleMessages;

public class Main {
    public static void main(String[] args) {

        HistorySystem historySystemService = new HistorySystemService();
        ApplicationMessages applicationMessages = new ConsoleMessages();
        CharacterToWordsMapCreator wordContainingLetterMapCreator = new CharacterToWordsMapCreator();

        CharacterToWordsService wordsFetcherEngine = new CharacterToWordsService(
                historySystemService,
                applicationMessages,
                wordContainingLetterMapCreator
        );

        wordsFetcherEngine.executeEngine();
    }
}
