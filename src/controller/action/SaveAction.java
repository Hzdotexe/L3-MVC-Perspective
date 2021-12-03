/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s:  Anyin Zhang, Isaac David Zolana,
                Hanz Sami, Fatsy Ramampiarison,
                Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: SaveAction.java
 Date créé: 2021-11-21
 *******************************************************/
package controller.action;

import controller.command.SaveCommand;
import view.Fenetre;
import java.awt.event.ActionEvent;

public class SaveAction extends PerspectiveAbstractAction{
    public SaveAction(Fenetre view, String text, String description, Integer mnemonic) {
        super(view, text, description, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PerspectiveAbstractAction.COMMAND_MANAGER.execute(new SaveCommand(view));
    }
}
