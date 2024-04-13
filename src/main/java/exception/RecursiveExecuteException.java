package exception;

/**
 * Команда не получила аргумент, который ожидался.
 */
public class RecursiveExecuteException extends RuntimeException {
    public RecursiveExecuteException() {
        super("Внутри введённого скрипта обнаружен execute_script с его же названием, что приведёт к рекурсивному вызову, выполнение остановлено.");
    }

}
