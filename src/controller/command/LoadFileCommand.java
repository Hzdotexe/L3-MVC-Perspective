package controller.command;

import view.Fenetre;
import model.Perspective;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.*;

public class LoadFileCommand implements Command {
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
            Perspective perspective;
            fenetre.getPerspectives().clear();
            try {
                FileInputStream fis = new FileInputStream(fileChooser.getSelectedFile().getAbsolutePath());
                ObjectInputStream input = new ObjectInputStream(fis);
                perspective = (Perspective) input.readObject();
                fenetre.getPerspectives().add(perspective);

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
