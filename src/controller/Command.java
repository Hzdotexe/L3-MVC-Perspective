package controller;

public interface Command {
    boolean execute();
    void undo();
    void redo();
}
