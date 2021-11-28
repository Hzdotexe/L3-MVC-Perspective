package controller.command;

import view.Fenetre;

public class SaveCommand implements Command {
    private Fenetre fenetre;

    public SaveCommand(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    @Override
    public boolean execute() {


        return false;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
