/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s:  Anyin Zhang, Isaac David Zolana,
                Hanz Sami, Fatsy Ramampiarison,
                Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: SaveCommand.java
 Date créé: 2021-11-22
 *******************************************************/
package controller.command;

import model.Perspective;
import view.Fenetre;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class SaveCommand implements Command {
    private Fenetre fenetre;
    private String directoryPath;
    private String fileName;

    public SaveCommand(Fenetre fenetre) {
        this.fenetre = fenetre;
        File src = new File("src");
        directoryPath = src.getAbsolutePath() + "/Saved Perspectives";

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            boolean created = directory.mkdir();
        }

        fileName = "perspective.ser";
    }

    @Override
    public boolean execute() {
        try {
            FileOutputStream fos = new FileOutputStream(directoryPath + "/" + fileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);

            for (Perspective perspective: fenetre.getPerspectives()) {
                out.writeObject(perspective);
            }

            out.close();
            fos.close();
            System.out.println("Sauvegarde des perspectives dans src/Saved Perspectives/perspective.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
