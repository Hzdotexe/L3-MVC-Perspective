package controller.command;

public interface Command {
    boolean execute();
    void undo();
    void redo();
}
