/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s:  Anyin Zhang, Isaac David Zolana,
                Hanz Sami, Fatsy Ramampiarison,
                Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: UndoAction.java
 Date créé: 2021-11-22
 *******************************************************/
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
