package controller.command;

import model.ImageModel;
import javax.swing.JPanel;

/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Anyin Zhang, Isaac David Zolana,
               Hanz Sami, Fatsy Ramampiarison,
               Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: ZoomCommand.java
 Date créé: 2021-11-20
 *******************************************************/
public class ZoomCommand extends JPanel implements Command {
    private ImageModel imageModel;
    private int width;
    private int height;
    private int oldWidth;
    private int oldHeight;

    public ZoomCommand(ImageModel imageModel, int width, int height) {
        this.imageModel = imageModel;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean execute() {
        if (imageModel != null) {
            imageModel.setWidth(imageModel.getWidth() + width);
            imageModel.setHeight(imageModel.getHeight() + height);
            return true;
        }
        return false;
    }

    @Override
    public void undo() {
        oldWidth = width;
        oldHeight = height;
        imageModel.setWidth(imageModel.getWidth() - oldWidth);
        imageModel.setHeight(imageModel.getHeight() - oldHeight);
    }

    @Override
    public void redo() {}
}
