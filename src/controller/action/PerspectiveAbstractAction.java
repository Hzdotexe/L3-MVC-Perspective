package controller.action;

import controller.singleton.CommandManager;
import model.ImageModel;
import view.Fenetre;

import javax.swing.*;
import java.awt.event.KeyEvent;

public abstract class PerspectiveAbstractAction extends AbstractAction {
    protected final static CommandManager cm = CommandManager.getInstance();
    protected Fenetre view;

    public PerspectiveAbstractAction(Fenetre view, String text, Icon icon, String description, Integer mnemonic) {
        super(text, icon);

        putValue(SHORT_DESCRIPTION, description); // Action's description
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(mnemonic, KeyEvent.CTRL_DOWN_MASK)); // Action's shortcut key

        this.view = view;
    }
}
