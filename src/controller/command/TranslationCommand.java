package controller.command;

import model.ImageModel;

import javax.swing.*;

/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Anyin Zhang, Isaac David Zolana,
               Hanz Sami, Fatsy Ramampiarison,
               Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: TranslationCommand.java
 Date créé: 2021-11-20
 *******************************************************/

public class TranslationCommand extends JPanel implements Command{
    private ImageModel imageModel;
    private int x;
    private int y;

    public TranslationCommand(ImageModel imageModel, int x, int y) {
        this.imageModel = imageModel;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute() {
        if (imageModel != null){
            imageModel.setX(imageModel.getX()+x);
            imageModel.setY(imageModel.getY()+y);
            return true;
        }

        return false;
    }

    @Override
    public void undo() {}

    @Override
    public void redo() {}
}
