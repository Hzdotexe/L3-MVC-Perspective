package controller.command;

import model.ImageModel;
import view.Fenetre;
import view.Perspective;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class LoadCommand implements Command {
    public static final String[][] EXTENSIONS = {
            {".jpg", "Fichier d'extension JPG"},
            {".png", "Fichier d'extension PNG"},
            {".jpeg", "Fichier d'extension JPEG"}
    };
    private JFileChooser fileChooser;
    private Fenetre fenetre;

    public LoadCommand(Fenetre fenetre) {
        this.fenetre = fenetre;

        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setCurrentDirectory(new File("src")); // Default FileChooser Directory
        fileChooser.setDialogTitle("Sélectionnez une image");

        // Allowed File extensions
        for (int i = 0; i < EXTENSIONS.length; i++) {
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(EXTENSIONS[i][0], EXTENSIONS[i][1]));
        }
    }

    @Override
    public boolean execute() {
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            for (Perspective perspective: fenetre.getPerspectives()) {
                // remove existing JLabel in the JPanel
                perspective.removeAll();
                perspective.setImageModel(new ImageModel(fileChooser.getSelectedFile()));
            }

            //refresh the UI when something is loaded
            SwingUtilities.updateComponentTreeUI(fenetre);
        }

        return returnValue == JFileChooser.APPROVE_OPTION;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
