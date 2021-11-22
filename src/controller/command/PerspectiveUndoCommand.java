package controller.command;

public class PerspectiveUndoCommand implements Command, Undo {

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public void undo() {}

    @Override
    public void redo() {}
}
