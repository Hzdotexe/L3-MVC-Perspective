package controller.action;

import controller.command.UndoCommand;
import view.Fenetre;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UndoAction extends PerspectiveAbstractAction implements PropertyChangeListener {
    public UndoAction(Fenetre view, String text, String description, Integer mnemonic) {
        super(view, text, description, mnemonic);
        PerspectiveAbstractAction.COMMAND_MANAGER.addPropertyChangeListener(this);
        setEnabled(false);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setEnabled(PerspectiveAbstractAction.COMMAND_MANAGER.canUndo());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PerspectiveAbstractAction.COMMAND_MANAGER.execute(new UndoCommand());
    }
}
