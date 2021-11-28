package controller.action;

import controller.command.TranslationCommand;
import controller.singleton.CommandManager;
import model.ImageModel;
import view.Fenetre;
import view.Perspective;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Anyin Zhang, Isaac David Zolana,
               Hanz Sami, Fatsy Ramampiarison,
               Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: PerspectiveTranslationAction.java
 Date créé: 2021-11-22
 *******************************************************/

public class PerspectiveTranslationAction implements MouseMotionListener, MouseListener {
    protected final static CommandManager cm = CommandManager.getInstance();
    protected Fenetre view;
    protected ImageModel img;
    private int xDiff;
    private int yDiff;
    private int x;
    private int y;
    private Point startPoint;
    private boolean dragger;
    private boolean released;

    public PerspectiveTranslationAction(Fenetre view, ImageModel img, String text, Icon icon, String description, Integer mnemonic) {
        this.view = view;
        this.img = img;
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("mouse dragged");
        Point currentPoint = e.getLocationOnScreen();
        System.out.println("currentPoint"+currentPoint);
        xDiff = currentPoint.x - startPoint.x;
        yDiff = currentPoint.y - startPoint.y;
        System.out.println(xDiff);
        System.out.println(yDiff);

        dragger = true;
        cm.execute(new TranslationCommand(img,img.getX(),img.getY(),xDiff,yDiff));
        System.out.println("image dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // get location of the image by the mouse.
        System.out.println("mouse pressed");
        released = false;
        startPoint = e.getPoint();
        System.out.println("press point" +startPoint);
        cm.execute(new TranslationCommand(img,img.getX(),img.getY(),xDiff,yDiff));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        released = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
