package controller.command;

import model.ImageModel;
import view.Fenetre;
import model.Perspective;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class LoadImageCommand implements Command {
    public static final String[][] EXTENSIONS = {
            {"jpg", "Fichier d'extension JPG"},
            {"png", "Fichier d'extension PNG"},
            {"jpeg", "Fichier d'extension JPEG"}
    };
    private JFileChooser fileChooser;
    private Fenetre fenetre;

    public LoadImageCommand(Fenetre fenetre) {
        this.fenetre = fenetre;

        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setCurrentDirectory(new File("src")); // Default FileChooser Directory
        fileChooser.setDialogTitle("Sélectionnez une image");

        // Allowed File extensions
        for (String[] extension : EXTENSIONS) {
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(extension[1], extension[0]));
        }
    }

    @Override
    public boolean execute() {
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            for (Perspective perspective: fenetre.getPerspectives()) {
                perspective.removeAll();
                ImageModel imageModel = new ImageModel(fileChooser.getSelectedFile());
                imageModel.addObserver(perspective);
                perspective.setImageModel(imageModel);
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
