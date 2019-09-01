import historysystem.HistorySystem;
import historysystem.HistorySystemService;
import view.ApplicationMessages;
import view.ConsoleMessages;

public class Main {
    public static void main(String[] args) {

        HistorySystem historySystemService = new HistorySystemService();
        ApplicationMessages applicationMessages = new ConsoleMessages();

        WordsFetcherEngine wordsFetcherEngine = new WordsFetcherEngine(historySystemService, applicationMessages);
        wordsFetcherEngine.executeEngine();
    }
}
