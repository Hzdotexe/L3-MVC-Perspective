package controller.action;

import controller.command.UndoCommand;
import model.Image;
import view.Fenetre;

import javax.swing.Icon;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PerspectiveUndoAction extends PerspectiveAbstractAction implements PropertyChangeListener {
    public PerspectiveUndoAction(Fenetre view, Image img, String text, Icon icon, String description, Integer mnemonic) {
        super(view, img, text, icon, description, mnemonic);
        PerspectiveAbstractAction.cm.addPropertyChangeListener(this);
        setEnabled(false);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        PerspectiveAbstractAction.cm.execute(new UndoCommand());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setEnabled(PerspectiveAbstractAction.cm.canUndo());
    }
}
