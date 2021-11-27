package controller.action;

import controller.singleton.CommandManager;
import model.ImageModel;
import view.Fenetre;

import javax.swing.*;

public abstract class PerspectiveAbstractAction extends AbstractAction {
    protected final static CommandManager cm = CommandManager.getInstance();
    protected Fenetre view;
    protected ImageModel img;

    public PerspectiveAbstractAction(Fenetre view, String text, Icon icon, String description, Integer mnemonic) {
        super(text, icon);

        putValue(SHORT_DESCRIPTION, description); // Action's description
        putValue(MNEMONIC_KEY, mnemonic); // Action's shortcut key

        this.view = view;
    }

    public PerspectiveAbstractAction(Fenetre view, ImageModel img, String text, Icon icon, String description, Integer mnemonic) {
        super(text, icon);

        putValue(SHORT_DESCRIPTION, description); // Action's description
        putValue(MNEMONIC_KEY, mnemonic); // Action's shortcut key

        this.view = view;
        this.img = img;
    }
}
