package controller.command;

public class UndoCommand implements Command, Undo {

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public void undo() {}

    @Override
    public void redo() {}
}
