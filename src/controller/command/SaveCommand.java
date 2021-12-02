package controller.command;

import model.Perspective;
import view.Fenetre;

import java.io.*;

/**
 * Save the perspectives as one image in the new file "Saved Perspectives"
 */
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
