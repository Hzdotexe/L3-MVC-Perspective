package controller.command;

import model.ImageModel;
import view.Fenetre;
import model.Perspective;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

/**
 * Load image of the application
 */
public class LoadImageCommand implements Command {
    public static final String[] EXTENSIONS = {"jpg", "png", "jpeg"};
    private JFileChooser fileChooser;
    private Fenetre fenetre;

    /**
     * Setup the Load image dialog
     */
    public LoadImageCommand(Fenetre fenetre) {
        this.fenetre = fenetre;

        this.fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        this.fileChooser.setCurrentDirectory(new File("src")); // Default FileChooser Directory
        this.fileChooser.setDialogTitle("Sélectionnez une image");

        // Allowed File extensions
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", EXTENSIONS);
        this.fileChooser.addChoosableFileFilter(filter);
        this.fileChooser.setFileFilter(filter);
    }

    @Override
    public boolean execute() {
        int returnValue = this.fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            for (Perspective perspective: this.fenetre.getPerspectives()) {
                perspective.removeAll();
                ImageModel imageModel = new ImageModel(this.fileChooser.getSelectedFile());
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
