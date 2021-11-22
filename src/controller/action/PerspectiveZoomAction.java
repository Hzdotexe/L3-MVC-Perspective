package controller.action;

import controller.command.ZoomCommand;
import model.Image;
import view.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Anyin Zhang, Isaac David Zolana,
               Hanz Sami, Fatsy Ramampiarison,
               Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: PerspectiveZoomAction.java
 Date créé: 2021-11-22
 *******************************************************/

public class PerspectiveZoomAction extends PerspectiveAbstractAction{
    public PerspectiveZoomAction(Fenetre view, Image img, String text, Icon icon, String description, Integer mnemonic) {
        super(view, img, text, icon, description, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PerspectiveAbstractAction.cm.execute(new ZoomCommand(view.getImg(),img.getHeight(),img.getWidth()));
        System.out.println("Image zoomed successfully");
    }
}
