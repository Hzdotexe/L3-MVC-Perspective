package controller.action;

import model.Image;
import view.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PerspectiveUndoAction extends PerspectiveAbstractAction implements PropertyChangeListener {

    public PerspectiveUndoAction(Fenetre view, Image img, String text, Icon icon, String description, Integer mnemonic) {
        super(view, img, text, icon, description, mnemonic);
        // PerspectiveAbstractAction.cm.addUndo(); TODO: requires a addPropertyChangeListener(this);
        setEnabled(false);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // PerspectiveAbstractAction.cm.do TODO: Needs to call do(new PerspectiveUndoCommand);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // setEnabled(PerspectiveAbstractAction.cm.canUndo()); TODO: Needs to inform the command manager that the undo command can be performed.
    }
}
