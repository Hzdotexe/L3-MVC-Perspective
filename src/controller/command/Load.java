package controller.command;

import view.Fenetre;
import view.Perspective;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Anyin Zhang, Isaac David Zolana,
               Hanz Sami, Fatsy Ramampiarison,
               Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: Load.java
 Date créé: 2021-11-20
 *******************************************************/

public class Load implements Command{

    private  Fenetre window;

    public  void setWindow(Fenetre window)
    {
        this.window = window;
    }
    @Override
    public boolean execute() {

        if(window.getImg() != null) {

            for (Perspective perspective:window.getPerspectives())
            {
                JLabel picLabel = new JLabel(new ImageIcon(window.getImg()));
                //remove existing JLabel in the JPanel
                perspective.removeAll();
                //add JLabel that was just created
                perspective.add(picLabel);
            }
        }
        //refresh the UI when something is loaded
        SwingUtilities.updateComponentTreeUI(window);
        return window.getImg() != null;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
