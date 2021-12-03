/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s:  Anyin Zhang, Isaac David Zolana,
                Hanz Sami, Fatsy Ramampiarison,
                Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: PerspectiveAbstractAction.java
 Date créé: 2021-11-21
 *******************************************************/
package controller.action;

import controller.singleton.CommandManager;
import view.Fenetre;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

public abstract class PerspectiveAbstractAction extends AbstractAction {
    protected final static CommandManager COMMAND_MANAGER = CommandManager.getInstance();
    protected Fenetre view;

    public PerspectiveAbstractAction(Fenetre view, String text, String description, Integer mnemonic) {
        super(text);

        putValue(SHORT_DESCRIPTION, description); // Action's description
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(mnemonic, KeyEvent.CTRL_DOWN_MASK)); // Action's shortcut key

        this.view = view;
    }
}
