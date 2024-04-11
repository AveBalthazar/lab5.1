package commands;

import utility.HistoryBuffer;

/**
 * Абстрактный класс, от которого наследуются все команды.
 */

public abstract class AbstractCommand implements Command {
    protected String description;
    public AbstractCommand(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return this.getName() + ": " + this.getDescription();
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
    public String getDescription() {
        return description;
    }
    protected void toHistory() {
        HistoryBuffer.add(this.getClass().getSimpleName());
    }
}
