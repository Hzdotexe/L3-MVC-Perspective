/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s:  Anyin Zhang, Isaac David Zolana,
                Hanz Sami, Fatsy Ramampiarison,
                Nureddin Aida
 Professeur : Vincent Lacasse
 Nom du fichier: Command.java
 Date créé: 2021-11-22
 *******************************************************/
package controller.command;

public interface Command {
    /**
     * Executes the command.
     *
     * @return True if command was executed
     */
    boolean execute();

    /**
     * Undo the command.
     */
    void undo();

    /**
     * Redo the command
     */
    void redo();
}
