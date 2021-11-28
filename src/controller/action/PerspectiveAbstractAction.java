package controller.action;

import controller.singleton.CommandManager;
import model.ImageModel;
import view.Fenetre;

import javax.swing.*;

/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Anyin Zhang, Isaac David Zolana,
               Hanz Sami, Fatsy Ramampiarison,
               Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: PerspectiveAbstractAction.java
 Date créé: 2021-11-21
 *******************************************************/

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
