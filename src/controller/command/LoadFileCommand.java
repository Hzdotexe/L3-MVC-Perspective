/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s:  Anyin Zhang, Isaac David Zolana,
                Hanz Sami, Fatsy Ramampiarison,
                Nureddin Aida
 Professeur : Vincent Lacasse
 Nom du fichier: LoadFileCommand.java
 Date créé: 2021-11-22
 *******************************************************/
package controller.command;

import view.Fenetre;
import model.Perspective;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.Serializable;

public class LoadFileCommand implements Command, Serializable {
    public static final String[] EXTENSIONS = {"ser"};
    private JFileChooser fileChooser;
    private Fenetre fenetre;

    public LoadFileCommand(Fenetre fenetre) {
        this.fenetre = fenetre;

        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setCurrentDirectory(new File("src")); // Default FileChooser Directory
        fileChooser.setDialogTitle("Sélectionnez une image");

        // Allowed File extensions
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Perspectives", EXTENSIONS);
        this.fileChooser.addChoosableFileFilter(filter);
        this.fileChooser.setFileFilter(filter);
    }

    @Override
    public boolean execute() {
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {

            for (Perspective perspective: fenetre.getPerspectives()) {
                fenetre.remove(perspective);
            }

            fenetre.getPerspectives().clear();
            Perspective perspective;

            try {
                FileInputStream fis = new FileInputStream(fileChooser.getSelectedFile().getAbsolutePath());
                ObjectInputStream input = new ObjectInputStream(fis);

                for (int i=0; i<3; i++) {
                    perspective = (Perspective) input.readObject();
                    System.out.println(perspective.getType());
                    fenetre.getPerspectives().add(perspective);
                    fenetre.showPerspectives();
                }

                input.close();
                fis.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            //refresh the UI when something is loaded
            SwingUtilities.updateComponentTreeUI(fenetre);
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
