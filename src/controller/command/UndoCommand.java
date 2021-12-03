/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s:  Anyin Zhang, Isaac David Zolana,
                Hanz Sami, Fatsy Ramampiarison,
                Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: UndoCommand.java
 Date créé: 2021-11-22
 *******************************************************/
package controller.command;

public class UndoCommand implements Command, Undo {
    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public void undo() {}

    @Override
    public void redo() {}
}
