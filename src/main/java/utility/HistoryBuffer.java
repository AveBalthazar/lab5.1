package utility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HistoryBuffer {
    private static LinkedList<String> HISTORY = new LinkedList<>();

    public static void add(String value) {
        if (HISTORY.size() == 11) {
            HISTORY.removeLast();
        }
        HISTORY.addFirst(value);
    }
    public static List<String> getAll() {
        return new ArrayList<>(HISTORY);
    }
}
