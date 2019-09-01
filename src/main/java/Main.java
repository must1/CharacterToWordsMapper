import historysystem.HistorySystem;
import historysystem.HistorySystemService;
import view.ApplicationMessages;
import view.ConsoleMessages;

public class Main {
    public static void main(String[] args) {

        HistorySystem historySystemService = new HistorySystemService();
        ApplicationMessages applicationMessages = new ConsoleMessages();
        WordContainingLetterMapCreator wordContainingLetterMapCreator = new WordContainingLetterMapCreator();

        WordsFetcherEngine wordsFetcherEngine = new WordsFetcherEngine(historySystemService, applicationMessages, wordContainingLetterMapCreator);
        wordsFetcherEngine.executeEngine();
    }
}
