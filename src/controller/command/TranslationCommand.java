package controller.command;

import model.ImageModel;
import view.Fenetre;
import view.Perspective;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

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
    private int xDiff;
    private int yDiff;


    public TranslationCommand(ImageModel imageModel, int x, int y, int xDiff, int yDiff) {
        this.imageModel = imageModel;
        this.x = x;
        this.y = y;
        this.xDiff = xDiff;
        this.yDiff = yDiff;

    }


    @Override
    public boolean execute() {

        if (imageModel.getImage() != null){
            imageModel.setX(x+xDiff);
            imageModel.setY(y+yDiff);
            return true;
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
